package logic;

import entities.City;
import ui.UIMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UIMainLogic implements ActionListener {
    private UIMain uiMain;
    private ArrayList<City> arrayCities,arrayDrawCities, arrayDRawConexion;
    private  double LATITUDEMIN = 15.5, LATITUDEMAX= 17.6, LONGITUDEMIN=96, LONGITUDEMAX=98.1, PANELW =630, PANELH=900;

    public UIMainLogic(UIMain uiMain, ArrayList<City> arrayCities) {
        this.uiMain = uiMain;
        this.arrayCities = arrayCities;
        uiMain.btnAdd.addActionListener(this);
        uiMain.btnDelete.addActionListener(this);
        uiMain.btnGenerate.addActionListener(this);
        uiMain.btnReset.addActionListener(this);
        fillContent();
    }

    //Se rellenan los ComboBox y la tabla con los nombres de las cuidades
    public void fillContent(){
        uiMain.comboBoxOr.addItem("Selecciona");
        uiMain.comboBoxDes.addItem("Selecciona");
        uiMain.comboBoxOr2.addItem("Selecciona");
        uiMain.comboBoxDes2.addItem("Selecciona");
        String[] data  = new String[2];
        int aux = 0;
        for (City city : arrayCities){
            //Se añaden las cuidades a los JComboBox
            uiMain.comboBoxOr.addItem(city.getName());
            uiMain.comboBoxDes.addItem(city.getName());
            uiMain.comboBoxOr2.addItem(city.getName());
            uiMain.comboBoxDes2.addItem(city.getName());
            //Se rellena la tabla
            data[0]=  String.valueOf(aux+1);
            data[1] = city.getName();
            uiMain.modelTableCity.addRow(data);
            aux++;
        }
    }
    // se añade una nueva conexion
    private void addConexion(){
        // se validan las cuidades seleccionadas
        if (validateSelection()){
            // Se busca la cuidad origen y la cuida destino seleccionado
            City origin = null, destination = null;
            int aux =0,indexOrigin=0,indexDestination =0;
            //Recorre el array de cuidades y guarda la cuidad origen y destino, incluyendo el index del origen
            for (City city: arrayCities){
                if (city.getName().equalsIgnoreCase(uiMain.comboBoxOr.getSelectedItem().toString())){
                    origin = city;
                    indexOrigin = aux;
                }
                if (city.getName().equalsIgnoreCase(uiMain.comboBoxDes.getSelectedItem().toString())){
                    destination = city;
                    indexDestination = aux;
                }
                aux ++;
            }
            //Valida que no haya una conexion entre estas dos cuidades
            if (validateDuplicateConnections(origin,destination)){
                // se agreega la cuidad destino al ArrayCityConexions de la cuidad origen y viceversa
                arrayCities.get(indexOrigin).addCityConexion(destination);
                arrayCities.get(indexDestination).addCityConexion(origin);
                //se dibujan las cuidades y la conexión si esta no existe
                validateCityDrawing(origin,indexOrigin,destination,indexDestination);
                System.out.println("Conexion Agregada: "+origin.getName()+" ---> "+destination.getName());
            }
        }
    }
    private void deleteConexion(){

    }
    private void resetRoute(){

    }

    private void generateRoute(){
        //Imprime las conexiones
        for (City city :arrayCities){
            System.out.println("Ciudad: "+city.getName());
            for (City cityConexion : city.getArrayCitiesConexion()){
                System.out.println(cityConexion.getName());
            }
        }
    }
    private void validateCityDrawing(City origin,int indexOrigin, City destination, int indexDestination){
        //Recupera x y y de cada cuidad y verifica que sean distintas a 0, si es asi los dibuja
        if (origin.getX() ==0 && origin.getY() == 0){
            scaleCoordinates(origin);
            uiMain.drawingPanel.addDrawCity(origin,indexOrigin);
            scaleCoordinates(origin);
        }
        if (destination.getX() == 0 && destination.getY() == 0 ){
            scaleCoordinates(destination);
            uiMain.drawingPanel.addDrawCity(destination,indexDestination);
        }
        uiMain.drawingPanel.drawConexion(origin,destination);
    }
    //Escala las coordenadas
    private void scaleCoordinates(City city){
        //Calculamos la coordenada para dibujar dentro del panel
        double scalaLatitude =  (Math.abs(LATITUDEMAX) - Math.abs(LATITUDEMIN));
        double scalaLongitude =  (Math.abs(LONGITUDEMAX) - Math.abs(LONGITUDEMIN));
        scalaLatitude = (PANELW/scalaLatitude);
        scalaLongitude = (PANELH/scalaLongitude);
        int x = (int) ((LONGITUDEMAX - Math.abs(city.getLongitude())) * scalaLongitude);
        int y = (int) ((LATITUDEMAX - Math.abs(city.getLatitude())) * scalaLatitude);
        //Agregas las coordenadas al objeto
        city.setX(x);
        city.setY(y);
    }


    private void calculateHeuristic(){

    }

    //Se validan que se seleccionaron ciudades y que no sean iguales
    private boolean validateSelection(){
        boolean flag = false;
        if (!uiMain.comboBoxOr.getSelectedItem().toString().equalsIgnoreCase("Selecciona")){
            if (!uiMain.comboBoxDes.getSelectedItem().toString().equalsIgnoreCase("Selecciona")){
                if (!uiMain.comboBoxOr.getSelectedItem().toString().equalsIgnoreCase(uiMain.comboBoxDes.getSelectedItem().toString())){
                    flag = true;
                }else{
                    JOptionPane.showMessageDialog(null,"El origen y destino no pueden ser iguales");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Selecciona una cuidad Destino");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Selecciona una cuidad Origen");
        }
        return flag;
    }
    //Valida que no se repita una conexion ya sea de a->b o de b->a
    private boolean validateDuplicateConnections(City origin, City destination){
        boolean flag = true;
        //Recorre el arrayCitiesConexion del destino para ver si ya existe una conexion entre la cuidad origen y destino
        if (destination.getArrayCitiesConexion().size() >= 0){
            for (City city : destination.getArrayCitiesConexion()){
                if (origin.getName().equalsIgnoreCase(city.getName())){
                    flag = false;
                    JOptionPane.showMessageDialog(null,"Ya existe una conexion entre estas cuidades");
                    break;
                }
            }
        }
        return  flag;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(uiMain.btnAdd)){
            addConexion();
        }else if (e.getSource().equals(uiMain.btnDelete)){
            deleteConexion();
        }else if (e.getSource().equals(uiMain.btnReset)){
            resetRoute();
        }else if (e.getSource().equals(uiMain.btnGenerate)){
            generateRoute();
        }
    }
}