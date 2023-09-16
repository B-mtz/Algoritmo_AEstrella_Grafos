package test;

import com.formdev.flatlaf.FlatLightLaf;
import logic.GetCitiesLogic;
import logic.HaversineFormula;
import ui.GetCities;
import ui.UIMain;

public class TestConsole {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());
        //UIMainLogic uiMainLogic = new UIMainLogic(new UIMain());
        //HaversineFormula haversineFormula = new HaversineFormula();

        //double distance = haversineFormula.calculateDistance(17.06784, -96.72686, 16.33395, -96.59144);
        //System.out.println(distance);
    }
}
