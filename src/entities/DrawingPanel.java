package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private Image image;
    private Graphics2D graphics2D;
    private ArrayList<CityDrawing> arrayCityDrawing;
    private ArrayList<ConnectionDrawing> arrayConnectionDrawing;
    private Font fontNumber = new Font("Cascadia code",Font.BOLD,14);
    public DrawingPanel() {
        // Inicializa la imagen como un BufferedImage
        image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) image.getGraphics();
        //Inicializa los arreglos para guardar los objetos a dibujar
        arrayCityDrawing = new ArrayList<>();
        arrayConnectionDrawing = new ArrayList<>();
        this.setBackground(new Color(231, 233, 253));
    }
    //Dibuja una ciudad creando un objeto CityDrawing
    public void addDrawCity(City origin, int index) {
        arrayCityDrawing.add(new CityDrawing(origin,index));
    }
    //Crea un nuevo objeto ConnectionDrawing y dibuja la conexion
    public void addConexion(City origin, City destine) {
        arrayConnectionDrawing.add(new ConnectionDrawing(origin, destine));
    }
    //Busca la cuidad dentro del array para eliminarlo
    public void deleteDrawCity(City origin, int index) {
        CityDrawing aux = null;
        for (CityDrawing cityDrawing : arrayCityDrawing) {
            //Si encuentra una simulitud guarda la referencia
            if (cityDrawing.getCity().equals(origin)) {
                System.out.println("Se eliminó " + cityDrawing.getCity().getName());
                aux = cityDrawing;
                break;
            }
        }
        //Si la referencia no esta vacia elimina el objeto con la referencia
        if (aux != null) {
            arrayCityDrawing.remove(aux);
            repaint();
        }
    }
    //Elimina la conexión dentro del array que coincida con el origen o destino
    public void deleteConexion(City origin, City destine) {
        int aux = 0;
        ConnectionDrawing connectionAux = null;
        for (ConnectionDrawing connectionDrawing : arrayConnectionDrawing) {
            //Verifica si encuentra una conexion con origen y destino igual al que se desea eliminar
            if (connectionDrawing.getOrigin().equals(origin) && connectionDrawing.getDestine().equals(destine)) {
                connectionAux = connectionDrawing;
                break;
            }
            //Verifica si encuentra una conexion con destino = al origen y viceversa
            if (connectionDrawing.getDestine().equals(origin) && connectionDrawing.getOrigin().equals(destine)){
                connectionAux = connectionDrawing;
                break;
            }
            aux++;
        }
        // si la connectionAux es diferente a null elimina la referencia al objeto y vacia el panel para volver a pintarlo
        if (connectionAux != null) {
            // Elimina por índice en lugar de por referencia
            arrayConnectionDrawing.remove(aux);
            image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
            graphics2D = (Graphics2D) image.getGraphics();
        }
    }

    //dibuja una cuidad con su index
    private void paintCity(City origin, int index){
        graphics2D.setColor(new Color(81, 83, 255));
        graphics2D.fillOval(origin.getX(),origin.getY(),20,20);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawOval(origin.getX(),origin.getY(),20,20);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(fontNumber);
        if (index<=8){
            graphics2D.drawString(String.valueOf(index+1), (int) (origin.getX()+6),origin.getY()+14);
        }else{
            graphics2D.drawString(String.valueOf(index+1),origin.getX()+2,origin.getY()+14);
        }
    }
    //dibuja una conexion
    private void  paintConexion(City origin, City destine){
        graphics2D.setColor(new Color(81, 83, 255));
        //Izquierda
        if (origin.getX() > destine.getX()) {
            //Arriba
            if (origin.getY()> destine.getY()){
                graphics2D.drawLine(origin.getX()+10, origin.getY(), destine.getX() + 10, destine.getY() + 20);
            }//abajo
            else{
                graphics2D.drawLine(origin.getX()+10, origin.getY()+20, destine.getX()+10, destine.getY());
            }
        }//Derecha
        else{
            //Arriba
            if (origin.getY()> destine.getY()){
                graphics2D.drawLine(origin.getX()+10, origin.getY(), destine.getX() + 10, destine.getY() + 20);
            }//Abajo
            else{
                graphics2D.drawLine(origin.getX()+10, origin.getY()+20, destine.getX()+10, destine.getY());
            }
        }
    }

    //Se sobreescribe el metodo para pintar en cada actualizacion donde se agrega o elimina
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja las ciudades almacenadas en arrayCityDrawing
        for (CityDrawing cityDrawing : arrayCityDrawing){
            paintCity(cityDrawing.getCity(),cityDrawing.getIndex());
        }
        // Dibuja las conexiones almacenadas en arrayConnectionDrawing
        if (arrayConnectionDrawing.size()>0){
            for (ConnectionDrawing connectionDrawing: arrayConnectionDrawing) {
                paintConexion(connectionDrawing.origin, connectionDrawing.getDestine());
            }
        }
        // Dibuja la imagen en el panel
        g.drawImage(image, 0, 0, this);
    }
}
