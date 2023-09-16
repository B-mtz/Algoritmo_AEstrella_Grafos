package ui;

import javax.swing.*;
import java.awt.*;

public class UIMain extends JFrame {
    private JPanel contentPane = new JPanel(new BorderLayout());
    private Font font = new Font("Sans",Font.BOLD,16);
    private Font font2 = new Font("Sans",Font.PLAIN,14);
    private Font font3 = new Font("Sans",Font.PLAIN,12);
    private JPanel panelNorth, panelSuth,panelCenter, panelLeft, panelRight;
    private JTable cities;
    private JComboBox comboBoxOr, comboBoxDes, comboBoxOr2, comboBoxDes2;
    private JButton btnDelete,btnAdd,btnGenerate,btnReset;
    private  Color color1 = new Color(81, 83, 255), color2 = new Color(207, 210, 252), color3 = new Color(231, 233, 253);

    private int rows,columns;
    public UIMain(){
        super("Generar Conexiones y Ruta");
        this.setSize(1280, 720);
        this.setContentPane(contentPane);

        //content panels
        panelNorth = new JPanel(new FlowLayout());
        panelCenter = new JPanel();
        panelSuth = new JPanel();
        panelLeft = new JPanel(new BorderLayout());
        panelRight = new JPanel();

        //North pane: components
        componentsPanelNorth();
        //Center pane: components
        componentsPanelCenter();
        //Suth pane: components
        componentsPanelSouth();
        //Left pane: components
        componentsPanelLeft();
        //Right pane: components
        componentsPanelRight();

        //Add content paneles : contentPane
        contentPane.add(panelNorth,BorderLayout.NORTH);
        contentPane.add(panelCenter,BorderLayout.CENTER);
        contentPane.add(panelSuth,BorderLayout.SOUTH);
        contentPane.add(panelLeft, BorderLayout.WEST);
        contentPane.add(panelRight,BorderLayout.EAST);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //Componentes del panel Norte
    public void componentsPanelNorth(){
        panelNorth.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
    }
    //Componentes del panel Central
    public void componentsPanelCenter(){
        panelCenter.setBackground(color3);
        panelCenter.setBorder(BorderFactory.createLineBorder(color2,2,true));
        panelCenter.add(new JLabel("Hola"));
    }
    //Componentes del panel Sur
    public void componentsPanelSouth(){
        panelSuth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    //Componentes del panel izquierdo
    public void componentsPanelLeft(){
        panelLeft.setBorder(BorderFactory.createEmptyBorder(50,20,20,20));
        JPanel panelLeftNorth = new JPanel(new BorderLayout());
        JPanel panelLeftSouth = new JPanel(new BorderLayout());
        GridLayout gridLayout = new GridLayout();
        gridLayout.setHgap(10);

        //# PanelLeftNorth: PanelLeftNorthTitle, PanelLeftNorthContent
        //## PanelLeftNorthTitle
        JPanel panelLeftNorthTitle = new JPanel(new FlowLayout());
        JLabel title = new JLabel("Generar Conexiones");
        title.setFont(font);
        title.setForeground(color1);
        panelLeftNorthTitle.add(title);
        //## PanelLeftNorthContent: panelLeftNorthContentLabls, pabelLeftNorthContentJCombo, panelLeftNorthBtns
        JPanel panelLeftNorthContent = new JPanel(new BorderLayout());
        //## panelLeftNorthContentLabls
        JPanel panelLeftNorthContetnLabels = new JPanel(gridLayout);
        panelLeftNorthContetnLabels.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        JLabel lbOrigin = new JLabel("Origen");
        lbOrigin.setHorizontalAlignment(0);
        lbOrigin.setFont(font2);
        JLabel lbDestination = new JLabel("Destino");
        lbDestination.setHorizontalAlignment(0);
        lbDestination.setFont(font2);
        panelLeftNorthContetnLabels.add(lbOrigin);
        panelLeftNorthContetnLabels.add(lbDestination);
        //### pabelLeftNorthContentJCombo
        JPanel pabelLeftNorthContentJCombo = new JPanel(gridLayout);
        comboBoxOr = new JComboBox();
        comboBoxDes = new JComboBox();
        pabelLeftNorthContentJCombo.add(comboBoxOr);
        pabelLeftNorthContentJCombo.add(comboBoxDes);
        //### panelLeftNorthBtns
        JPanel panelLeftNorthBtns = new JPanel(new FlowLayout());
        panelLeftNorthBtns.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        btnDelete = new JButton("Eliminar");
        btnDelete.setFont(font);
        btnDelete.setBackground(color1);
        btnDelete.setForeground(Color.WHITE);
        panelLeftNorthBtns.add(btnDelete);
        btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        btnAdd.setBackground(color1);
        btnAdd.setForeground(Color.WHITE);
        panelLeftNorthBtns.add(btnAdd);
        panelLeftNorthContent.add(panelLeftNorthContetnLabels,BorderLayout.NORTH);
        panelLeftNorthContent.add(pabelLeftNorthContentJCombo,BorderLayout.CENTER);
        panelLeftNorthContent.add(panelLeftNorthBtns, BorderLayout.SOUTH);

        panelLeftNorth.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        panelLeftNorth.add(panelLeftNorthTitle,BorderLayout.NORTH);
        panelLeftNorth.add(panelLeftNorthContent, BorderLayout.CENTER);

        //# PanelLeftCenter: PanelLeftCenterTitle, PanelLeftSouthContent
        //##  PanelLeftCenterTitle
        JPanel panelLeftSouthTitle = new JPanel(new FlowLayout());
        JLabel title2 = new JLabel("Generar Ruta");
        title2.setFont(font);
        title2.setForeground(color1);
        panelLeftSouthTitle.add(title2);
        //##  PanelLeftSouthContent: panelLeftsouthContetnLabels, panelLeftSouthContentJCombo, panelLeftSouthBtns
        JPanel PanelLeftSouthContent = new JPanel(new BorderLayout());
        //### panelLeftsouthContetnLabels
        JPanel panelLeftsouthContetnLabels = new JPanel(gridLayout);
        panelLeftsouthContetnLabels.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        JLabel lbOrigin2 = new JLabel("Origen");
        lbOrigin2.setHorizontalAlignment(0);
        lbOrigin2.setFont(font2);
        JLabel lbDestination2 = new JLabel("Destino");
        lbDestination2.setHorizontalAlignment(0);
        lbDestination2.setFont(font2);
        panelLeftsouthContetnLabels.add(lbOrigin2);
        panelLeftsouthContetnLabels.add(lbDestination2);
        //### panelLeftSouthContentJCombo
        JPanel panelLeftSouthContentJCombo = new JPanel(gridLayout);
        comboBoxOr2 = new JComboBox();
        comboBoxDes2 = new JComboBox();
        panelLeftSouthContentJCombo.add(comboBoxOr2);
        panelLeftSouthContentJCombo.add(comboBoxDes2);
        //### panelLeftSouthBtns
        JPanel panelLeftSouthBtns = new JPanel(new FlowLayout());
        panelLeftSouthBtns.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        btnReset= new JButton("Reiniciar");
        btnReset.setFont(font);
        btnReset.setBackground(color1);
        btnReset.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnReset);
        btnGenerate = new JButton("Generar");
        btnGenerate.setFont(font);
        btnGenerate.setBackground(color1);
        btnGenerate.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnGenerate);
        PanelLeftSouthContent.add(panelLeftsouthContetnLabels,BorderLayout.NORTH);
        PanelLeftSouthContent.add(panelLeftSouthContentJCombo,BorderLayout.CENTER);
        PanelLeftSouthContent.add(panelLeftSouthBtns, BorderLayout.SOUTH);

        panelLeftSouth.setBorder(BorderFactory.createEmptyBorder(0,0,150,0));
        panelLeftSouth.add(panelLeftSouthTitle,BorderLayout.NORTH);
        panelLeftSouth.add(PanelLeftSouthContent, BorderLayout.CENTER);

        panelLeft.add(panelLeftNorth,BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth,BorderLayout.SOUTH);

    }
    //Componentes del panel derecho
    public void componentsPanelRight(){
        panelRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
}
