package logic;

import entities.City;
import ui.GetCities;
import ui.Ui_Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GetCitiesLogic implements ActionListener {
    private GetCities getCitiesUi;
    private String name;
    private double latitude, longitude;
    private ArrayList<City> arrayCities = new ArrayList<>();
    public GetCitiesLogic(GetCities getCitiesUi){
        this.getCitiesUi = getCitiesUi;
       getCitiesUi.btnDelete.addActionListener(this);
       getCitiesUi.btnAdd.addActionListener(this);
       getCitiesUi.btnSave.addActionListener(this);
    }
    //Crea un nuevo objeto City y añade nueva fila a la tabla
    public void addCity(){
        //valida datos de entrada
        if (getDataJTxtField()){
            if (validateTable()){
                clearJTextField();
                //agrega nueva fila
                String  data[] = {name,String.valueOf(latitude),String.valueOf(longitude)};
                getCitiesUi.modelCity.addRow(data);
                //crea nuevo objeto City
                City city = new City(name,latitude,longitude);
                arrayCities.add(city);
                System.out.printf("AGREGADO : nombre: %s longitud: %f latitud: %f\n", name, longitude, latitude);
            }
        }
    }
    public void deleteCity(){
        if (getCitiesUi.tableCity.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Seleccione una fila para eliminar");
        }else{
            //Se eleimina del arrayCities
            for (City city : arrayCities){
                if (city.getName().equalsIgnoreCase(getCitiesUi.modelCity.getValueAt(getCitiesUi.tableCity.getSelectedRow(),0).toString())){
                    arrayCities.remove(city);
                    System.out.printf("ELIMINADO: nombre: %s longitud: %f latitud: %f\n", city.getName(), city.getLatitude(), city.getLongitude());
                    break;
                }
            }
            //Se elimina de la tabla
            getCitiesUi.modelCity.removeRow(getCitiesUi.tableCity.getSelectedRow());
        }
    }
    public void saveCities() {
        if (arrayCities.size()>2){
            getCitiesUi.dispose();
            Ui_Main uiMain = new Ui_Main();
        }else{
            JOptionPane.showMessageDialog(null,"Agrega minimo 3 cuidades");
        }
    }

    //Valida los datos ingresados a los JTextField desde la interfaz
    private Boolean getDataJTxtField(){
        if (getCitiesUi.txtName.getText().isEmpty() || getCitiesUi.txtLatitude.getText().isEmpty() || getCitiesUi.txtLongitude.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa los datos de la ciudad");
            return false;
        }else {
            //Obtiene el nombre, latitud y longitud
            try{
                name = getCitiesUi.txtName.getText();
                latitude = Double.parseDouble(getCitiesUi.txtLatitude.getText());
                longitude = Double.parseDouble(getCitiesUi.txtLongitude.getText());
                return true;
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Solo se permiten numeros");
                return false;
            }
        }
    }
    //Valida que no se dupliquen filas en la tabla
    private boolean validateTable(){
        boolean flag = true;
        for (City city : arrayCities){
            if (city.getName().equalsIgnoreCase(name)){
                JOptionPane.showMessageDialog(null,"Ya existe una cuidad con ese nombre");
                flag = false;
                break;
            }else if (city.getLatitude() == latitude && city.getLongitude() == longitude){
                JOptionPane.showMessageDialog(null,"Ya existe una cuidad con esas coordenadas");
                flag = false;
                break;
            }else {
                flag = true;
            }
        }
        return flag;
    }
    //Limpia los JTextField
    public void clearJTextField(){
        getCitiesUi.txtName.setText("");
        getCitiesUi.txtLatitude.setText("");
        getCitiesUi.txtLongitude.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getCitiesUi.btnDelete)){
            deleteCity();
        } else if (e.getSource().equals(getCitiesUi.btnAdd)) {
            addCity();
        } else if (e.getSource().equals(getCitiesUi.btnSave)) {
            saveCities();
        }
    }
}
