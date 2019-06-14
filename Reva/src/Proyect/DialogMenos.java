/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Jondalar
 */
public class DialogMenos extends JDialog {

    private Conexion conexion;

    public DialogMenos() {
        conexion = new Conexion("ganado", "root", "");
        form();
        in();

    }

    private void in() {

        JPanel JPanelMenos = new JPanel();
        ContainerTotalMenos containerTotalMenos = new ContainerTotalMenos(conexion);
        JPanelMenos.add(containerTotalMenos);
        JPanelMenos.setBackground(Color.WHITE);
        this.add(JPanelMenos);

    }

    private void form() {
        this.setTitle("Registro de Salidas");
        this.setSize(new Dimension(500, 500));
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

    }

}
