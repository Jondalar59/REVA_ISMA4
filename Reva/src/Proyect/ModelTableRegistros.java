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
public class ModelTableRegistros extends AbstractTableModel {

    public static final String[] NAME_COLS = {"Arete", "Peso", "Raza", "Sexo", "Fecha de Nacimiento"};
    private ArrayList<Registros> Registers;

    public ModelTableRegistros() {
        Registers = new ArrayList<Registros>();
    }

    @Override
    public String getColumnName(int index) {
        return NAME_COLS[index];
    }

    @Override
    public int getRowCount() {
        return Registers.size();
    }

    @Override
    public int getColumnCount() {
        return NAME_COLS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Registros aux = Registers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aux.getArete();
            case 1:
                return aux.getPeso();
            case 2:
                return aux.getRaza();
            case 3:
                return aux.getSexo();
            case 4:
                return aux.getNacimiento();
            default:
                return null;
        }
    }

    public String[] getTitles() {
        return NAME_COLS;
    }

    public void addUsuario(Registros registro) {
        Registers.add(registro);
        this.fireTableDataChanged();
    }

    public Registros getUsuario(int index) {
        if (index < Registers.size()) {
            return Registers.get(index);
        }
        return null;
    }

    public void deleteUsuario(int index) {
        if (index < Registers.size()) {
            Registers.remove(index);
            this.fireTableDataChanged();
        } else {
            //JOptionPane.showMessageDialog(null, "Imposible eliminar el registro");
            new Aviso("No es posible eliminar el registro solicitado").setVisible(true);
        }
    }

    public void clear() {
        Registers.removeAll(Registers);
        this.fireTableDataChanged();
    }

}
