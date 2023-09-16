package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GetCities extends JFrame{
    private JPanel contentPane = new JPanel(new BorderLayout());
    private JPanel panelNorth, panelCenter, panelSuth;
    private Font font = new Font("Sans",Font.BOLD,16);
    private Font font1 = new Font("Sans",Font.PLAIN,16);
    private Font font2 = new Font("Sans",Font.PLAIN,14);
    public JTable tableCity;
    public DefaultTableModel modelCity;
    public JButton btnAdd,btnDelete,btnSave, btnReadFile;
    public JTextField txtName,txtLatitude,txtLongitude;
    private  Color color1 = new Color(81, 83, 255), color2 = new Color(207, 210, 252), color3 = new Color(231, 233, 253);

    public GetCities(){
        super("Ingresa los datos de las cuidades");
        this.setSize(500, 640);
        this.setContentPane(contentPane);

        //content panels
        panelNorth = new JPanel(new BorderLayout());
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
    //Creación de componentes Top
    private void componentsPanelNorth() {
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbTitle = new JLabel("Ingresa las cuidades a evaluar");
        lbTitle.setFont(font1);
        lbTitle.setForeground(color1);
        lbTitle.setHorizontalAlignment(0);
        btnReadFile = new JButton();
        btnReadFile.setIcon(new ImageIcon("src/library/txt.png"));
        panelNorth.add(lbTitle,BorderLayout.CENTER);
        panelNorth.add(btnReadFile, BorderLayout.WEST);
    }
    //Creación de componentes centrales
    private void componentsPanelCenter(){
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        tableCity = new JTable();
        modelCity = new DefaultTableModel();
        String[] titles = {"Nombre", "Longitud", "Altitud"};
        modelCity.setColumnIdentifiers(titles);
        tableCity.getTableHeader().setBackground(color1);
        tableCity.getTableHeader().setForeground(Color.WHITE);
        tableCity.getTableHeader().setFont(font2);
        tableCity.setSelectionBackground(color2);
        tableCity.setSelectionForeground(color1);
        tableCity.setRowHeight(20);
        tableCity.setFont(font2);
        tableCity.setModel(modelCity);
        JScrollPane scrollBarCities = new JScrollPane(tableCity);
        panelCenter.add(scrollBarCities);
    }
    //Creación de componentes Bottom
    private void componentsPanelSouth(){
        panelSuth.setBorder(BorderFactory.createEmptyBorder(20,20,30,20));
        JPanel panelLabelTxt = new JPanel( new BorderLayout());
        //Labels
        JPanel panelLabel = new JPanel(new GridLayout(1,3));
        panelLabel.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        JLabel lbName = new JLabel("Nombre");
        lbName.setHorizontalAlignment(0);
        JLabel lbLongitude = new JLabel("Longitud");
        lbLongitude.setHorizontalAlignment(0);
        JLabel lbLatitude = new JLabel("Latitud");
        lbLatitude.setHorizontalAlignment(0);
        lbName.setFont(font2);
        lbLongitude.setFont(font2);
        lbLatitude.setFont(font2);
        panelLabel.add(lbName);
        panelLabel.add(lbLatitude);
        panelLabel.add(lbLongitude);
        //JTextFields
        JPanel panelTextField = new JPanel(new FlowLayout());
        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBackground(color3);
        txtName.setHorizontalAlignment(0);
        txtLongitude = new JTextField();
        txtLongitude.setColumns(10);
        txtLongitude.setBackground(color3);
        txtLongitude.setHorizontalAlignment(0);
        txtLatitude = new JTextField();
        txtLatitude.setColumns(10);
        txtLatitude.setBackground(color3);
        txtLatitude.setHorizontalAlignment(0);
        txtName.setFont(font2);
        txtLongitude.setFont(font2);
        txtLatitude.setFont(font2);
        panelTextField.add(txtName);
        panelTextField.add(txtLatitude);
        panelTextField.add(txtLongitude);
        //Labels and JTextFields
        panelLabelTxt.add(panelLabel, BorderLayout.NORTH);
        panelLabelTxt.add(panelTextField, BorderLayout.CENTER);
        //JButtons: add and delete
        JPanel panelBtn = new JPanel(new FlowLayout());
        panelBtn.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
        panelBtn.setOpaque(true);
        btnDelete = new JButton("Eliminar");
        btnDelete.setFont(font);
        btnDelete.setBackground(new Color(248, 54, 115));
        btnDelete.setForeground(Color.WHITE);
        panelBtn.add(btnDelete);
        btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(108, 172, 35));
        btnAdd.setForeground(Color.WHITE);
        panelBtn.add(btnAdd);
        btnSave = new JButton("Guardar");
        btnSave.setFont(font);
        btnSave.setBackground(new Color(79, 195, 247));
        btnSave.setForeground(Color.WHITE);
        panelBtn.add(btnSave);

        panelSuth.add(panelLabelTxt,BorderLayout.NORTH);
        panelSuth.add(panelBtn, BorderLayout.CENTER);
    }
}
