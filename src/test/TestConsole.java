package test;

import com.formdev.flatlaf.FlatLightLaf;
import logic.GetCitiesLogic;
import ui.GetCities;
public class TestConsole {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());
    }
}
