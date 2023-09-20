package ui;

import entities.DrawingPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UIMain extends JFrame {
    private JPanel contentPane = new JPanel(new BorderLayout());
    private Font font = new Font("Sans",Font.BOLD,16);
    private Font font2 = new Font("Sans",Font.PLAIN,14);
    private JPanel panelNorth, panelSuth, panelLeft, panelRight;
    public DrawingPanel drawingPanel;
    public JPanel panelCenter;
    private JTable tableCity;
    public DefaultTableModel modelTableCity;
    public JComboBox<String> comboBoxOr, comboBoxDes, comboBoxOr2, comboBoxDes2;
    public JButton btnDelete,btnAdd,btnGenerate, btnViewTables;
    private  Color color1 = new Color(81, 83, 255), color2 = new Color(207, 210, 252), color3 = new Color(231, 233, 253);

    //Constructor
    public UIMain(){
        super("Generar Conexiones y Ruta");
        this.setSize(1280, 720);
        this.setContentPane(contentPane);

        //content panels
        panelNorth = new JPanel(new FlowLayout());
        panelCenter = new JPanel(new BorderLayout());
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
        panelCenter.setBorder(BorderFactory.createLineBorder(color2,2,true));
        panelCenter.setBackground(color1);
        drawingPanel = new DrawingPanel();
        panelCenter.add(drawingPanel);

    }

    //Componentes del panel Sur
    public void componentsPanelSouth(){
        panelSuth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    //Componentes del panel izquierdo
    public void componentsPanelLeft(){
        panelLeft.setBorder(BorderFactory.createEmptyBorder(0,20,5,20));
        JPanel panelLeftNorth = new JPanel(new BorderLayout());
        panelLeftNorth.setPreferredSize(new Dimension(250,220));
        JPanel panelLeftSouth = new JPanel(new BorderLayout());
        panelLeftSouth.setPreferredSize(new Dimension(250,220));
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
        btnDelete.setBackground(new Color(247, 39, 105));
        btnDelete.setForeground(Color.WHITE);
        panelLeftNorthBtns.add(btnDelete);
        btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(129, 201, 38));
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
        JLabel lbOrigin2 = new JLabel("Inicio");
        lbOrigin2.setHorizontalAlignment(0);
        lbOrigin2.setFont(font2);
        JLabel lbDestination2 = new JLabel("Fin");
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
        panelLeftSouthBtns.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
        btnViewTables = new JButton("Ver Registros");
        btnViewTables.setFont(font);
        btnViewTables.setBackground(new Color(134, 144, 250));
        btnViewTables.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnViewTables);
        btnGenerate = new JButton("Generar");
        btnGenerate.setFont(font);
        btnGenerate.setBackground(new Color(64, 190, 246));
        btnGenerate.setForeground(Color.WHITE);
        panelLeftSouthBtns.add(btnGenerate);
        PanelLeftSouthContent.add(panelLeftsouthContetnLabels,BorderLayout.NORTH);
        PanelLeftSouthContent.add(panelLeftSouthContentJCombo,BorderLayout.CENTER);
        PanelLeftSouthContent.add(panelLeftSouthBtns, BorderLayout.SOUTH);
        //Se crea un label para el link
        JLabel lbAutor = new JLabel("  Autor: https://github.com/B-mtz");
        lbAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbAutor.setForeground(Color.gray);
        // Agrega un MouseListener al JLabel para abrir el enlace cuando se hace clic
        lbAutor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Abre el enlace en el navegador web predeterminado
                    Desktop.getDesktop().browse(new URI("https://github.com/B-mtz"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambia el color del texto cuando el ratón entra
                lbAutor.setForeground(color1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaura el color del texto cuando el ratón sale
                lbAutor.setForeground(Color.gray);
            }
        });

        panelLeftSouth.setBorder(BorderFactory.createEmptyBorder(20,0,4,0));
        panelLeftSouth.add(panelLeftSouthTitle,BorderLayout.NORTH);
        panelLeftSouth.add(PanelLeftSouthContent, BorderLayout.CENTER);
        panelLeftSouth.add(lbAutor,BorderLayout.SOUTH);

        //Panel Tabla
        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.setPreferredSize(new Dimension(250,50));
        tableCity = new JTable();
        modelTableCity = new DefaultTableModel();
        String[] titles = {"ID", "Nombre"};
        modelTableCity.setColumnIdentifiers(titles);
        //tableCity.getTableHeader().setBackground(new Color(105, 111, 252));
        tableCity.getTableHeader().setForeground(color1);
        tableCity.getTableHeader().setFont(font2);
        tableCity.setSelectionBackground(color2);
        tableCity.setSelectionForeground(color1);
        tableCity.setRowHeight(20);
        tableCity.setFont(font2);
        tableCity.setModel(modelTableCity);
        JScrollPane scrollBarCities = new JScrollPane(tableCity);
        panelTable.add(scrollBarCities);
        TableColumnModel columnModel = tableCity.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(50);

        panelLeft.add(panelLeftNorth,BorderLayout.NORTH);
        panelLeft.add(panelTable,BorderLayout.CENTER);
        panelLeft.add(panelLeftSouth,BorderLayout.SOUTH);

    }
    //Componentes del panel derecho
    public void componentsPanelRight(){
        panelRight.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));

    }
}
