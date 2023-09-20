package test;

import com.formdev.flatlaf.FlatLightLaf;
import logic.GetCitiesLogic;
import ui.GetCities;
public class Execute {
    public static void main(String[] args) {
        //Nota: se pueden cargar archivos txt para agregar las cuidades mas rapido
        //La estructura de cada linea del archivo txt estrictamente tiene que ser la siguiente: Cuidad_Latitud_Longitud
        FlatLightLaf.setup();
        GetCitiesLogic getCitiesLogic = new GetCitiesLogic(new GetCities());
    }
}
