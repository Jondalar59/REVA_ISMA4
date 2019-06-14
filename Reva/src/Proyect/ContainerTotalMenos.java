/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jondalar
 */
public class ContainerTotalMenos extends Container {

    private JTable dataTable;
    private ModelTableMenos modelTable;
    private Conexion conexion;
    private Aviso aviso;

    public ContainerTotalMenos(Conexion conexion) {
        this.conexion = conexion;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        iniTable();
        iniDefaultData();
        add(Box.createRigidArea(new Dimension(0, 5)));

    }

    private void iniTable() {
        Container tableInformation = new JPanel();
        tableInformation.setBackground(Color.WHITE);
        tableInformation.setLayout(new BoxLayout(tableInformation, BoxLayout.Y_AXIS));
        JLabel text = new JLabel("Registro General de Salidas");
        text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableInformation.add(text);
        modelTable = new ModelTableMenos();
        dataTable = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataTable.setFillsViewportHeight(true);
        tableInformation.add(scrollPane);
        this.add(tableInformation);

    }

    public void iniDefaultData() {
        try {
            modelTable.clear();
            ResultSet r = conexion.getAllOut();
            while (r.next()) {
                modelTable.addUsuario(new RegistrosMenos(
                        Integer.parseInt(r.getString("id_venta")),
                        Integer.parseInt(r.getString("arete")),
                        r.getString("venta_muerte"),
                        r.getString("Fecha")));
            }
        } catch (SQLException e) {
            new Aviso("No es posible mostrar los registros en la tabla").setVisible(true);
            //JOptionPane.showMessageDialog(null, "No es posible mostrar los datos en la tabla");
        }
    }

}
