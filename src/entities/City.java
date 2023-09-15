package entities;

import java.util.ArrayList;

public class City {
    private String name;
    private double latitude,longitude;
    private ArrayList<City> ArrayCityConexions;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ArrayCityConexions = new ArrayList<>();
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

    public ArrayList<City> getCitiesConexion() {
        return ArrayCityConexions;
    }

    public void setCitiesConexion(ArrayList<City> cityConexion) {
        this.ArrayCityConexions = cityConexion;
    }
}