package logic;

import entities.City;
import entities.Register;

import javax.swing.*;
import java.util.ArrayList;
// AL enviar el origen y destino validar que estos tengan conexiones por que si no tiene ninguna conexion no se puede


public class StarAlgorithm {
    private ArrayList<City> arrayCities;
    private ArrayList<Register> arrayOpenSet,arrayOpenSetHistory;
    private ArrayList<Register> arrayClosedSet;
    private ArrayList<City> cityRoute;
    private City origin, destination;
    private HaversineFormula formula;
    private boolean meta;
    public StarAlgorithm(ArrayList<City> arrayCities, City origin, City destination){
        this.arrayCities = arrayCities;
        this.origin = origin;
        this.destination = destination;
        this.meta = false;
        arrayOpenSet = new ArrayList<>();
        arrayClosedSet = new ArrayList<>();
        arrayOpenSetHistory = new ArrayList<>();
        cityRoute = new ArrayList<>();
        formula = new HaversineFormula();
        runAlgorithm();
    }
    public void runAlgorithm() {
        // Se crea un registro origen y se evaluan sus conexiones
        Register registerOrigin = new Register(origin,origin);
        registerOrigin.setHeuristic(formula.calculateDistance(origin.getLatitude(),origin.getLongitude(),destination.getLatitude(),destination.getLongitude()));
        registerOrigin.setCost(0);
        registerOrigin.setTotal(registerOrigin.getCost()+registerOrigin.getHeuristic());
        for (City city : registerOrigin.getCity().getArrayCitiesConexion()) {
            //Calcular la heuristica, el costo y el total.
            Register registerCity = new Register(city,registerOrigin.getCity());
            registerCity.setHeuristic(formula.calculateDistance(city.getLatitude(),city.getLongitude(),destination.getLatitude(),destination.getLongitude()));
            Double costAux = formula.calculateDistance(registerOrigin.getCity().getLatitude(),registerOrigin.getCity().getLongitude(),city.getLatitude(),city.getLongitude());
            registerCity.setCost(costAux+registerOrigin.getCost());
            registerCity.setTotal(registerCity.getCost()+registerCity.getHeuristic());
            arrayOpenSet.add(registerCity);
        }
        // una vez evaluado el origen se agrega a closSet
        arrayClosedSet.add(registerOrigin);
        // se evalua OpenSet
        while (!meta) {
            //Verifica que openSet no este vacio, si esta vacio indica que no se llego a la meta
            if (!arrayOpenSet.isEmpty()) {
                //Recupera el registro en openSet con menor costo
                Register actual = getMinCost();
                //Evalua las conexiones del registro actual
                evaluation(actual);
                //Verifica si se llego a la meta
                if (actual.getCity().getName().equalsIgnoreCase(destination.getName())) {
                    //Ruta encontrada
                    arrayClosedSet.add(actual);
                    arrayOpenSet.remove(actual);
                    meta = true;
                }else {//Si no se llego a la meta se agrega a cloSet
                    arrayClosedSet.add(actual);
                    arrayOpenSet.remove(actual);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar la ruta");
                meta = true;
            }
        }
    }
    private void printOpenClosedSet(){
        System.out.println("OPENSET");
        for (Register register : arrayOpenSet){
            System.out.println(register.getCity().getName()+"--"+register.getCost()+"--"+
                    register.getHeuristic()+"--"+register.getTotal()+"--"+register.getOrigin().getName());
        }
        System.out.println("CLOSET");
        for (Register register : arrayClosedSet){
            System.out.println(register.getCity().getName()+"--"+register.getCost()+"--"+
                    register.getHeuristic()+"--"+register.getTotal()+"--"+register.getOrigin().getName());
        }
    }

    public Register getMinCost(){
        Register auxi= arrayOpenSet.get(0);
            for (int i = 1; i<arrayOpenSet.size();i++){
                if (arrayOpenSet.get(i).getTotal()<auxi.getTotal()){
                    auxi = arrayOpenSet.get(i);
                }
            }
        return auxi;
    }

    //El segundo ya no se deberia evaluar ya que es el origen
    public void evaluation(Register actual){
        //Valida que existan conexiones
        if (actual.getCity().getArrayCitiesConexion().size() >1){
            for (City city : actual.getCity().getArrayCitiesConexion()){
               Register registerAux = new Register(city,actual.getCity());
               //Se calcula el costo, la heuristica y el total
                registerAux.setHeuristic(formula.calculateDistance(city.getLatitude(),city.getLongitude(),destination.getLatitude(),destination.getLongitude()));
                Double costAux = formula.calculateDistance(actual.getCity().getLatitude(),actual.getCity().getLongitude(),city.getLatitude(),city.getLongitude());
                registerAux.setCost(costAux+actual.getCost());
                registerAux.setTotal(registerAux.getCost()+ registerAux.getHeuristic());


                if (validateOpenSet(registerAux)) {
                    if (validateClosedSet(registerAux)) {
                        //System.out.println("Origen : "+actual.getCity().getName()+"--  Conexiones: "+registerAux.getCity().getName());
                        arrayOpenSet.add(registerAux);
                       // System.out.println(registerAux.getCity().getName()+"---"+registerAux.getCost()+"---"+registerAux.getHeuristic()+"---"+registerAux.getTotal()+"---"+registerAux.getOrigin().getName());
                        arrayOpenSetHistory.add(registerAux);
                    }
                }
            }
        }
    }

    //Valida que el elemento no se encuentre en closeSet
    public boolean validateClosedSet(Register registerAux){
        boolean flag = false;
        for (Register registerClosedSet : arrayClosedSet){
            if (!registerClosedSet.getCity().getName().equalsIgnoreCase(registerAux.getCity().getName())){
                //System.out.println("ValidarClosedSet: "+registerClosedSet.getCity().getName()+"--"+actual.getCity().getName());
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    //Valida que el elemento no se encuentre en openSet
    public boolean validateOpenSet(Register registerAux){
        boolean flag = false;
        for (Register register : arrayOpenSet){
            //Si existe ya un registro en open set igual al que se evalua
            if (register.getCity().getName().equalsIgnoreCase(registerAux.getCity().getName())){
                // Si el registro es mayor al registerAux se modifica
                if (registerAux.getTotal() > register.getTotal()){
                    registerAux.setCost(register.getCost());
                    registerAux.setHeuristic(register.getHeuristic());
                    registerAux.setTotal(register.getTotal());
                    registerAux.setOrigin(register.getOrigin());
                }else{
                    register.setCost(registerAux.getCost());
                    register.setHeuristic(registerAux.getHeuristic());
                    register.setTotal(registerAux.getTotal());
                    register.setOrigin(registerAux.getOrigin());
                }
                flag = false;
                break;
            }else{
                flag = true;
            }
        }
        return flag;
    }
    public ArrayList<City> generateRoute(){

        System.out.println("RUTA");
        /*
        City aux = arrayClosedSet.get(0).getCity();
        for (Register register : arrayClosedSet){
            if (register.getOrigin().equals(aux)){
                aux = register.getCity();
                cityRoute.add(register.getCity());
                System.out.print("["+register.getCity().getName()+"]");
            }
        }
        System.out.println("");
        */
        City aux = arrayClosedSet.get(arrayClosedSet.size()-1).getCity();
        for (int i = arrayClosedSet.size() - 1; i >= 0; i--) {
            Register register = arrayClosedSet.get(i);
            if (register.getCity().equals(aux)) {
                cityRoute.add(register.getCity());
                aux = register.getOrigin();
                System.out.print("[" + register.getCity().getName()+ "]");
            }
        }
        //cityRoute.add(arrayClosedSet.get(arrayClosedSet.size()-1).getOrigin());
        //System.out.print("[" + arrayClosedSet.get(arrayClosedSet.size()-1).getOrigin().getName() + "]");
        System.out.println("");
        return cityRoute;
    }

    public ArrayList<Register> getArrayClosedSet() {
        return arrayClosedSet;
    }

    public ArrayList<Register> getArrayOpenSet() {
        return arrayOpenSet;
    }
}
