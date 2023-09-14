package entities;

import java.util.ArrayList;

public class Cities {
    private String name;
    private double latitude,longitude;
    private ArrayList<Cities> citiesConexion = new ArrayList<>();

    public Cities(String name, double latitude, double longitude, Cities next) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ArrayList<Cities> getCitiesConexion() {
        return citiesConexion;
    }

    public void setCitiesConexion(ArrayList<Cities> citiesConexion) {
        this.citiesConexion = citiesConexion;
    }
}