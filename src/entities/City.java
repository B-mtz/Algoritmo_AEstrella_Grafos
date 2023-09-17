package entities;

import java.util.ArrayList;

public class City {
    private String name;
    private double latitude,longitude;
    private  int x,y;
    private ArrayList<City> arrayCityConexions;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.arrayCityConexions = new ArrayList<>();
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addCityConexion(City city){
        arrayCityConexions.add(city);
    }
    public void removeCityConexion(City city){
        arrayCityConexions.remove(city);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<City> getArrayCitiesConexion() {
        return arrayCityConexions;
    }

    public void setArrayCitiesConexion(ArrayList<City> cityConexion) {
        this.arrayCityConexions = cityConexion;
    }
}