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
        arrayCityDrawing = new ArrayList<>();
        arrayConnectionDrawing = new ArrayList<>();
    }
    public void addDrawCity(City origin, int index) {
        arrayCityDrawing.add(new CityDrawing(origin,index));
        paintCity(origin,index);
        repaint();
    }
    //Crea un nuevo CityDrawing y dibuja la ciudad
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

    //Crea un nuevo objeto ConnectionDrawing y dibuja la conexion
    public void drawConexion(City origin, City destine) {
        arrayConnectionDrawing.add(new ConnectionDrawing(origin, destine));
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
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen en el panel
        g.drawImage(image, 0, 0, this);
    }
}
