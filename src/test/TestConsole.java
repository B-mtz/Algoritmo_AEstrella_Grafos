package test;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import logic.GetCitiesLogic;
import ui.GetCities;
import ui.Ui_Main;

public class TestConsole {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());
        //Ui_Main connections = new Ui_Main();
    }
}
