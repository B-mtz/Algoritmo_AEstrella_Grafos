package test;

import com.formdev.flatlaf.FlatLightLaf;
import entities.City;
import logic.GetCitiesLogic;
import logic.HaversineFormula;
import logic.StarAlgorithm;
import ui.GetCities;
import ui.UIMain;
import ui.ViewsLogs;

import java.util.ArrayList;

public class TestConsole {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());
    }
}
