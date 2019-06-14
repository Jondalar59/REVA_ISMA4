/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jondalar
 */
public class ModelTableMenos extends AbstractTableModel {

    public static final String[] NAME_COLS = {"Arete", "Tipo de Salida", "Fecha"};
    private ArrayList<RegistrosMenos> RegistersM;
    private Aviso aviso;

    public ModelTableMenos() {
        RegistersM = new ArrayList<RegistrosMenos>();
    }

    @Override
    public String getColumnName(int index) {
        return NAME_COLS[index];
    }

    @Override
    public int getRowCount() {
        return RegistersM.size();
    }

    @Override
    public int getColumnCount() {
        return NAME_COLS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegistrosMenos aux = RegistersM.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aux.getArete();
            case 1:
                return aux.getVenta_muerte();
            case 2:
                return aux.getFecha();

            default:
                return null;
        }
    }

    public String[] getTitles() {
        return NAME_COLS;
    }

    public void addUsuario(RegistrosMenos registro) {
        RegistersM.add(registro);
        this.fireTableDataChanged();
    }

    public RegistrosMenos getUsuario(int index) {
        if (index < RegistersM.size()) {
            return RegistersM.get(index);
        }
        return null;
    }

    public void deleteUsuario(int index) {
        if (index < RegistersM.size()) {
            RegistersM.remove(index);
            this.fireTableDataChanged();
        } else {
            //JOptionPane.showMessageDialog(null, "Imposible eliminar el registro");
            new Aviso("No es posible eliminar el registro solicitado").setVisible(true);
        }
    }

    public void clear() {
        RegistersM.removeAll(RegistersM);
        this.fireTableDataChanged();
    }

}
