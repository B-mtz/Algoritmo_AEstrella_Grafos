package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GetCities extends JFrame{
    private JPanel contentPane = new JPanel(new BorderLayout());
    private JTable cities;
    private JPanel panelNorth, panelCenter, panelSuth;
    private Font font = new Font("Aveir",Font.BOLD,16);

    public GetCities(){
        super("Ingresa los datos de las cuidades");
        this.setSize(500, 640);
        this.setContentPane(contentPane);
        contentPane.setBackground(Color.DARK_GRAY);

        //content panels
        panelNorth = new JPanel(new FlowLayout());
        panelCenter = new JPanel();
        panelSuth = new JPanel(new BorderLayout());

        //North pane: components
        componentsPanelNorth();
        //Center pane: components
        componentsPanelCenter();
        //Suth pane: components
        componentsPanelSouth();

        //Add content paneles : contentPane
        contentPane.add(panelNorth,BorderLayout.NORTH);
        contentPane.add(panelCenter,BorderLayout.CENTER);
        contentPane.add(panelSuth,BorderLayout.SOUTH);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void componentsPanelNorth(){
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelNorth.setBackground(Color.DARK_GRAY);
        JLabel lbTitle = new JLabel("Ingresa las cuidades a evaluar");
        lbTitle.setFont(font);
        lbTitle.setForeground(Color.ORANGE);
        panelNorth.add(lbTitle);
    }
    public void componentsPanelCenter(){
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCenter.setBackground(Color.DARK_GRAY);
        Font font = new Font("Aveir",Font.BOLD,14);
        cities = new JTable();
        DefaultTableModel citiesModel = new DefaultTableModel();
        String[] titles = {"Nombre", "Longitud", "Altitud"};
        String[][] data ={{"Nombre", "Longitud", "Altitud"},{"Nombre", "Longitud", "Altitud"}};
        citiesModel.setColumnIdentifiers(titles);
        cities.getTableHeader().setFont(font);
        cities.getTableHeader().setBackground(Color.DARK_GRAY);
        cities.getTableHeader().setForeground(Color.WHITE);
        cities.setBackground(Color.WHITE);
        cities.setForeground(Color.DARK_GRAY);
        cities.setSelectionBackground(Color.DARK_GRAY);
        cities.setSelectionForeground(Color.ORANGE);
        cities.setRowHeight(20);
        cities.setFont(font);
        cities.setModel(citiesModel);
        JScrollPane scrollBarCities = new JScrollPane(cities);
        panelCenter.add(scrollBarCities);

        citiesModel.setDataVector(data,titles);
    }
    public void componentsPanelSouth(){
        panelSuth.setBorder(BorderFactory.createEmptyBorder(20,20,30,20));
        panelSuth.setBackground(Color.DARK_GRAY);
        JPanel panelLabelTxt = new JPanel( new BorderLayout());
        //Labels
        JPanel panelLabel = new JPanel(new GridLayout(1,3));
        panelLabel.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        panelLabel.setBackground(Color.DARK_GRAY);
        JLabel lbName = new JLabel("Nombre");
        lbName.setHorizontalAlignment(0);
        lbName.setForeground(Color.WHITE);
        JLabel lbLongitude = new JLabel("Longitud");
        lbLongitude.setHorizontalAlignment(0);
        lbLongitude.setForeground(Color.WHITE);
        JLabel lbLatitude = new JLabel("Latitud");
        lbLatitude.setHorizontalAlignment(0);
        lbLatitude.setForeground(Color.WHITE);
        lbName.setFont(font);
        lbLongitude.setFont(font);
        lbLatitude.setFont(font);
        panelLabel.add(lbName);
        panelLabel.add(lbLatitude);
        panelLabel.add(lbLongitude);
        //JTextFields
        JPanel panelTextField = new JPanel(new FlowLayout());
        panelTextField.setBackground(Color.DARK_GRAY);
        JTextField txtName = new JTextField();
        txtName.setColumns(9);
        txtName.setHorizontalAlignment(0);
        JTextField txtLongitude = new JTextField();
        txtLongitude.setColumns(9);
        txtLongitude.setHorizontalAlignment(0);
        JTextField txtLatitude = new JTextField();
        txtLatitude.setColumns(9);
        txtLatitude.setHorizontalAlignment(0);
        txtName.setFont(font);
        txtLongitude.setFont(font);
        txtLatitude.setFont(font);
        panelTextField.add(txtName);
        panelTextField.add(txtLongitude);
        panelTextField.add(txtLatitude);
        //Labels and JTextFields
        panelLabelTxt.add(panelLabel, BorderLayout.NORTH);
        panelLabelTxt.add(panelTextField, BorderLayout.CENTER);
        //JButtons: add and delete
        JPanel panelBtn = new JPanel(new FlowLayout());
        panelBtn.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
        panelBtn.setBackground(Color.DARK_GRAY);
        panelBtn.setOpaque(true);
        JButton btnDelete = new JButton("Eliminar");
        btnDelete.setFont(font);
        panelBtn.add(btnDelete);
        JButton btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        panelBtn.add(btnAdd);
        JButton btnSave = new JButton("Guardar");
        btnSave.setFont(font);
        panelBtn.add(btnSave);

        panelSuth.add(panelLabelTxt,BorderLayout.NORTH);
        panelSuth.add(panelBtn, BorderLayout.CENTER);
    }
}
