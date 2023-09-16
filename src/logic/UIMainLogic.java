package logic;

import entities.City;
import ui.UIMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UIMainLogic implements ActionListener {
    private UIMain uiMain;
    private ArrayList<City> arrayCities = new ArrayList<>();
    public UIMainLogic(UIMain uiMain, ArrayList<City> arrayCities) {
        this.uiMain = uiMain;
        this.arrayCities = arrayCities;
        uiMain.btnAdd.addActionListener(this);
        uiMain.btnDelete.addActionListener(this);
        uiMain.btnGenerate.addActionListener(this);
        uiMain.btnReset.addActionListener(this);
        fillComboBox();
    }

    public void fillComboBox(){
        for (City city : arrayCities){
            uiMain.comboBoxOr.addItem(city.getName());
            uiMain.comboBoxDes.addItem(city.getName());
        }
    }
    private void addConexion(){

    }
    private void deleteConexion(){

    }
    private void resetConexion(){}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(uiMain.btnAdd)){

        }else if (e.getSource().equals(uiMain.btnDelete)){

        }else if (e.getSource().equals(uiMain.btnReset)){

        }else if (e.getSource().equals(uiMain.btnGenerate)){}
    }
}
