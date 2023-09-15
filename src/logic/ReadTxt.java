package logic;

import entities.City;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTxt {
    private JFileChooser fileChooser;
    private File file;
    private ArrayList<City> arrayCities = new ArrayList<>();
    public ArrayList<City> readFile(){
        //Se crea una ventana para seleccionar el archivo
        fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        // Si el usuario selecciono un archivo se guardan los datos
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Se obtiene el archivo seleccionado y se verifica la extencion .txt
            file = fileChooser.getSelectedFile();
            String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            if (extension.equals("txt")) {
                try {
                    // Se lee el contenido del archivo
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    readLine(br);
                    br.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"El formato por linea debe ser: Ciudad_Latitud_Longitud");
                }
            } else {
                // El archivo no es .txt
                JOptionPane.showMessageDialog(null,"Selecciona un archivo .txt");
            }
        }
        return arrayCities;
    }

    private void readLine(BufferedReader br) throws IOException {
        // Leemos cada renglón del archivo
        String line;
        while ((line = br.readLine()) != null) {
            // separamos el renglon por _
            String[] attributes = line.split("_");
            try {
                City city = new City(attributes[0],Double.parseDouble(attributes[1]),Double.parseDouble(attributes[1]));
                arrayCities.add(city);
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Las coordenadas contenidas en el archivo deben ser numeros");
            }
        }
    }
}
