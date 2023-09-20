package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private Image image;
    private Graphics2D graphics2D;
    private ArrayList<CityDrawing> arrayCityDrawing, arrayCityRoute;
    private ArrayList<ConnectionDrawing> arrayConnectionDrawing, getArrayConnectionRoute;
    private Color  colorConexionNormal = new Color(81, 83, 255), colorConexionRoute = new Color(254, 174, 19);
    private Font fontNumber = new Font("Cascadia code",Font.BOLD,14);
    //Constructor
    public DrawingPanel() {
        // Inicializa la imagen como un BufferedImage
        image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) image.getGraphics();
        //Inicializa los arreglos para guardar los objetos a dibujar
        arrayCityDrawing = new ArrayList<>();
        arrayCityRoute = new ArrayList<>();
        arrayConnectionDrawing = new ArrayList<>();
        getArrayConnectionRoute = new ArrayList<>();
        this.setBackground(new Color(231, 233, 253));
    }
    //Dibuja una ciudad creando un objeto CityDrawing
    public void addDrawCity(City origin, int index) {
        arrayCityDrawing.add(new CityDrawing(origin,index));
    }
    public void addDrawCityRoute(City city){
        arrayCityRoute.add( new CityDrawing(city,0));
    }
    //Crea un nuevo objeto ConnectionDrawing y dibuja la conexion
    public void addConexion(City origin, City destine) {
        arrayConnectionDrawing.add(new ConnectionDrawing(origin, destine));
    }
    public  void addConexionRoute(City origin,City destine){
        getArrayConnectionRoute.add(new ConnectionDrawing(origin, destine));
    }
    //Limpia la ruta generada cada vez que se elimina
    public void resetRoute(){
        arrayCityRoute.clear();
        getArrayConnectionRoute.clear();
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
    //Metodos que pintan el inicio, fin y la ruta encontrada
    private void paintCityStart(City origin){
        graphics2D.setColor(new Color(129, 201, 38));
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawOval(origin.getX(),origin.getY(),20,20);
    }
    private void paintCityEnd(City origin){
        graphics2D.setColor(new Color(247, 39, 105));
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawOval(origin.getX(),origin.getY(),20,20);
    }
    private void paintCityRoute(City origin){
        graphics2D.setColor(new Color(254, 174, 19));
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawOval(origin.getX(),origin.getY(),20,20);
    }
    //dibuja una conexion
    private void  paintConexion(City origin, City destine, Color color){
        graphics2D.setColor(color);
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
        for (ConnectionDrawing connectionDrawing: arrayConnectionDrawing) {
            paintConexion(connectionDrawing.getOrigin(), connectionDrawing.getDestine(),colorConexionNormal);
        }

        // Dibuja las ciudades almacenadas en arrayCityRoute
        int aux = 0;
        for (CityDrawing cityDrawing : arrayCityRoute){
            if (aux== 0){
                paintCityStart(cityDrawing.getCity());
            } else if (aux+1 == arrayCityRoute.size()) {
                paintCityEnd(cityDrawing.getCity());
            }else{
                paintCityRoute(cityDrawing.getCity());
            }
            aux++;
        }
        // Dibuja las ciudades almacenadas en arrayConnectionRoute
        for (ConnectionDrawing connectionDrawing: getArrayConnectionRoute) {
            paintConexion(connectionDrawing.getOrigin(), connectionDrawing.getDestine(),colorConexionRoute);
        }
        // Dibuja la imagen en el panel
        g.drawImage(image, 0, 0, this);
    }
}
