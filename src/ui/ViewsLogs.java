package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewsLogs extends JFrame{
    private JPanel contentPane = new JPanel(new BorderLayout());
    private JPanel panelNorth, panelCenter;
    private Font font = new Font("Sans", Font.BOLD, 16);
    private Font font1 = new Font("Sans", Font.PLAIN, 16);
    private Font font2 = new Font("Sans", Font.PLAIN, 14);
    public JTable tableOpenSet, tableClosedSet;
    public DefaultTableModel modelOpenSet, modelClosedSet;
    private Color color1 = new Color(81, 83, 255), color2 = new Color(207, 210, 252);

    public ViewsLogs() {
        super("Logs");
        this.setSize(1000, 700);
        this.setContentPane(contentPane);

        //content panels
        panelNorth = new JPanel(new FlowLayout());
        panelCenter = new JPanel(new GridLayout());

        //North pane: components
        componentsPanelNorth();
        //Center pane: components
        componentsPanelCenter();

        //Add content paneles : contentPane
        contentPane.add(panelNorth, BorderLayout.NORTH);
        contentPane.add(panelCenter, BorderLayout.CENTER);

        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    ////Componentes del panel Norte
    public void componentsPanelNorth() {
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbTitle = new JLabel("Registros");
        lbTitle.setFont(font);
        lbTitle.setForeground(color1);
        lbTitle.setHorizontalAlignment(0);
        panelNorth.add(lbTitle);
    }

    //Componentes del panel Central
    public void componentsPanelCenter() {
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel panelLeft = new JPanel(new BorderLayout());
        panelLeft.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        JPanel panelRight = new JPanel(new BorderLayout());
        panelRight.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        //LEFT: OPENSET
        JLabel title1 = new JLabel("OpenSet");
        title1.setFont(font1);
        title1.setForeground(color1);
        tableOpenSet = new JTable();
        modelOpenSet = new DefaultTableModel();
        String[] titles = {"Ciudad", "Costo", "Heuristica","Total","Origen"};
        modelOpenSet.setColumnIdentifiers(titles);
        tableOpenSet.getTableHeader().setBackground(color1);
        tableOpenSet.getTableHeader().setForeground(Color.WHITE);
        tableOpenSet.getTableHeader().setFont(font2);
        tableOpenSet.setSelectionBackground(color2);
        tableOpenSet.setSelectionForeground(color1);
        tableOpenSet.setRowHeight(20);
        tableOpenSet.setFont(font2);
        tableOpenSet.setModel(modelOpenSet);
        JScrollPane scrollBarOpenSet = new JScrollPane(tableOpenSet);
        panelLeft.add(title1, BorderLayout.NORTH);
        panelLeft.add(scrollBarOpenSet, BorderLayout.CENTER);

        //RIGHT: CLOSEDSET
        JLabel title2= new JLabel("ClosedSet");
        title2.setFont(font1);
        title2.setForeground(color1);
        tableClosedSet = new JTable();
        modelClosedSet = new DefaultTableModel();
        modelClosedSet.setColumnIdentifiers(titles);
        tableClosedSet.getTableHeader().setBackground(color1);
        tableClosedSet.getTableHeader().setForeground(Color.WHITE);
        tableClosedSet.getTableHeader().setFont(font2);
        tableClosedSet.setSelectionBackground(color2);
        tableClosedSet.setSelectionForeground(color1);
        tableClosedSet.setRowHeight(20);
        tableClosedSet.setFont(font2);
        tableClosedSet.setModel(modelClosedSet);
        JScrollPane scrollBarClosedSet = new JScrollPane(tableClosedSet);
        panelRight.add(title2, BorderLayout.NORTH);
        panelRight.add(scrollBarClosedSet, BorderLayout.CENTER);

        panelCenter.add(panelLeft,BorderLayout.WEST);
        panelCenter.add(panelRight, BorderLayout.EAST);
    }

}
