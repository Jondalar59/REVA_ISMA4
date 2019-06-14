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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Damián
 */
public class ContainerTotal extends Container {

    private DialogTotal DT;
    private JTable dataTable;
    private ModelTableRegistros modelTable;
    private Conexion conexion;
    private Aviso aviso;

    public ContainerTotal(Conexion conexion) {
        this.conexion = conexion;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        iniTable();
        iniDefaultData();
        iniButton();
        add(Box.createRigidArea(new Dimension(0, 5)));
    }

    public ContainerTotal(Conexion conexion, DialogTotal dt) {
        this.conexion = conexion;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        iniTable();
        iniDefaultData();
        iniButton();
        add(Box.createRigidArea(new Dimension(0, 5)));
        this.DT = dt;
    }

    private void iniTable() {
        Container tableInformation = new JPanel();
        tableInformation.setBackground(Color.WHITE);
        tableInformation.setLayout(new BoxLayout(tableInformation, BoxLayout.Y_AXIS));
        JLabel text = new JLabel("Total de Registros");
        text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableInformation.add(text);
        modelTable = new ModelTableRegistros();
        dataTable = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataTable.setFillsViewportHeight(true);
        tableInformation.add(scrollPane);
        this.add(tableInformation);

    }

    private void iniButton() {
        Container ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));

        JButton ButtonEditar = new JButton("Editar");
        ButtonPanel.add(Box.createRigidArea(new Dimension(2, 5)));
        ButtonPanel.add(ButtonEditar);
        this.add(ButtonPanel);

        ButtonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (dataTable.getSelectedRow() != -1) {

                    Registros r = modelTable.getUsuario(dataTable.getSelectedRow());
                    r.getId();
                    String id = String.valueOf(r.getId());
                    DT.dispose();
                    NewRegister newRegister = new NewRegister(id);
                    newRegister.setVisible(true);
                    NewRegister.NuevoEditar = 1;
                } else {
                    new Aviso("Selecciona un Registro").setVisible(true);

                    //JOptionPane.showMessageDialog(null, "Selecciona un Registro");
                }
            }
        });

    }

    public void iniDefaultData() {
        try {
            modelTable.clear();
            ResultSet r = conexion.getAll();
            while (r.next()) {
                modelTable.addUsuario(new Registros(
                        Integer.parseInt(r.getString("idVaca")),
                        Integer.parseInt(r.getString("Arete")),
                        Double.parseDouble(r.getString("Peso")),
                        r.getString("Raza"),
                        r.getString("Sexo"),
                        r.getString("Nacimiento")));
            }
        } catch (SQLException e) {
            new Aviso("No es posible mostrar los registros en la tabla").setVisible(true);
            //JOptionPane.showMessageDialog(null, "No es posible mostrar los registros en la tabla");
        }
    }

}
