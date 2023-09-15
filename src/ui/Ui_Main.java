package ui;

import javax.swing.*;
import java.awt.*;

public class Ui_Main extends JFrame {
    private JPanel contentPane = new JPanel(new BorderLayout());
    private Font font = new Font("Sans",Font.BOLD,16);
    private JPanel panelNorth, panelSuth, panelLeft, panelRight;
    private JScrollPane panelCenter;
    private Font font2 = new Font("Sans",Font.PLAIN,14);
    private JTable cities;
    private JComboBox comboBoxOr, comboBoxDes, comboBoxOr2, comboBoxDes2;
    private JButton btnDelete,btnAdd,btnGenerate,btnReset;
    private int rows,columns;
    public Ui_Main(){
        super("Generar Conexiones y Ruta");
        this.setSize(1280, 720);
        this.setContentPane(contentPane);
        contentPane.setBackground(Color.DARK_GRAY);

        //content panels
        panelNorth = new JPanel(new FlowLayout());
        panelCenter = new JScrollPane();
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
    public void componentsPanelNorth(){
        panelNorth.setBackground(Color.DARK_GRAY);
        panelNorth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    public void componentsPanelCenter(){
        panelCenter.setBackground(Color.WHITE);
        panelCenter.add(new JLabel("Hola"));
    }
    public void componentsPanelSouth(){
        panelSuth.setBackground(Color.DARK_GRAY);
        panelSuth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
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
        title.setForeground(Color.ORANGE);
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
        comboBoxOr.addItem("Juquila");
        comboBoxDes.addItem("Santa catarinaJuquila");
        pabelLeftNorthContentJCombo.add(comboBoxOr);
        pabelLeftNorthContentJCombo.add(comboBoxDes);
        //### panelLeftNorthBtns
        JPanel panelLeftNorthBtns = new JPanel(new FlowLayout());
        panelLeftNorthBtns.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        btnDelete = new JButton("Eliminar");
        btnDelete.setFont(font);
        btnDelete.setBackground(new Color(248, 54, 115));
        btnDelete.setForeground(Color.WHITE);
        panelLeftNorthBtns.add(btnDelete);
        btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(109, 157, 31));
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
        title2.setForeground(Color.ORANGE);
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
        comboBoxOr2.addItem("Juquila");
        comboBoxDes2.addItem("Santa catarinaJuquila");
        panelLeftSouthContentJCombo.add(comboBoxOr2);
        panelLeftSouthContentJCombo.add(comboBoxDes2);
        //### panelLeftSouthBtns
        JPanel panelLeftSouthBtns = new JPanel(new FlowLayout());
        panelLeftSouthBtns.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        btnGenerate = new JButton("Generar");
        btnGenerate.setFont(font);
        btnGenerate.setBackground(new Color(248, 54, 115));
        btnGenerate.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnGenerate);
        btnReset= new JButton("Reiniciar");
        btnReset.setFont(font);
        btnReset.setBackground(new Color(109, 157, 31));
        btnReset.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnReset);
        PanelLeftSouthContent.add(panelLeftsouthContetnLabels,BorderLayout.NORTH);
        PanelLeftSouthContent.add(panelLeftSouthContentJCombo,BorderLayout.CENTER);
        PanelLeftSouthContent.add(panelLeftSouthBtns, BorderLayout.SOUTH);

        panelLeftSouth.setBorder(BorderFactory.createEmptyBorder(0,0,150,0));
        panelLeftSouth.add(panelLeftSouthTitle,BorderLayout.NORTH);
        panelLeftSouth.add(PanelLeftSouthContent, BorderLayout.CENTER);

        panelLeft.add(panelLeftNorth,BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth,BorderLayout.SOUTH);

    }
    public void componentsPanelRight(){
        panelRight.setBackground(Color.DARK_GRAY);
        panelRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
}
