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
        runAlgorithm();
    }
    public void runAlgorithm() {
        // Se evalua el origen
        for (City city : origin.getArrayCitiesConexion()) {
            arrayOpenSet.add(new Register(city, origin, destination));
        }
        // una vez evaluado el origen se agrega a closSet
        arrayClosedSet.add(new Register(origin, origin, destination));

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
                JOptionPane.showMessageDialog(null, "Las cuidades no tienen conexion");
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
        if (arrayOpenSet.size()>0){
            for (int i = 1; i<arrayOpenSet.size();i++){
                if (arrayOpenSet.get(i).getTotal()<auxi.getTotal()){
                    auxi = arrayOpenSet.get(i);
                }
            }
        }
        return auxi;
    }

    public void evaluation(Register actual){
        //Valida que existan conexiones
        if (actual.getCity().getArrayCitiesConexion().size() >=0){
            for (City city : actual.getCity().getArrayCitiesConexion()){
                //Valida que no este en closeSet y open set
                Register auxi = new Register(city,actual.getCity(),destination);
                if (validateClosedSet(auxi)) {
                    if (validateOpenSet(auxi)) {
                        arrayOpenSet.add(auxi);
                        arrayOpenSetHistory.add(auxi);
                    }
                }
            }
        }
    }

    //Valida que el elemento no se encuentre en closeSet
    public boolean validateClosedSet(Register actual){
        boolean flag = false;
        if (arrayClosedSet.isEmpty()){
            flag = true;
        }else{
            for (Register register : arrayClosedSet){
                if (!register.getCity().equals(actual.getCity())){
                    flag = true;
                }
            }
        }
        return flag;
    }
    //Valida que el elemento no se encuentre en openSet
    public boolean validateOpenSet(Register actual){
        boolean flag = false;
        for (Register register : arrayOpenSet){
            //Si existe ya un registro en open set igual al que se evalua
            if (register.getCity().equals(actual.getCity())){
                // Si el registro es mayor al actual se modifica
                if (register.getTotal()>actual.getTotal()){
                    register.setCost(actual.getCost());
                    register.setHeuristic(actual.getHeuristic());
                    register.setTotal(actual.getTotal());
                    register.setOrigin(actual.getOrigin());
                    flag = true;
                }
            }else{
                flag = true;
            }
        }
        return flag;
    }
    public ArrayList<City> generateRoute(){
        System.out.println("RUTA");
        for (Register register : arrayClosedSet){
            cityRoute.add(register.getCity());
        }
        return cityRoute;
    }

    public ArrayList<Register> getArrayClosedSet() {
        return arrayClosedSet;
    }

    public ArrayList<Register> getArrayOpenSetHistory() {
        return arrayOpenSetHistory;
    }
}
