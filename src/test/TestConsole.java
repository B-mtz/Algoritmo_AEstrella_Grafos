package test;

import com.formdev.flatlaf.FlatLightLaf;
import entities.City;
import logic.GetCitiesLogic;
import logic.HaversineFormula;
import logic.StarAlgorithm;
import ui.GetCities;
import ui.UIMain;

import java.util.ArrayList;

public class TestConsole {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());

        // HaversineFormula haversineFormula = new HaversineFormula();
        //double distance = haversineFormula.calculateDistance(17.06784, -96.72686, 16.33395, -96.59144);
        //System.out.println(distance);
    }
}
