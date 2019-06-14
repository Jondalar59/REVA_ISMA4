/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jondalar
 */
public class Aviso extends JDialog {

    public Aviso(String Mensaje) {

        iniWindow(Mensaje);
        defaulConfiguration();
        this.setVisible(true);

    }

    private void iniWindow(String Mensaje) {
        JPanel PanelAviso = new JPanel();
        PanelAviso.setLayout(null);

        Image iconAviso = null;
        try {
            //          Icono de Fondo para login
            iconAviso = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\VacaAlerta.jpeg"));

        } catch (IOException e) {
            System.err.println("Error con Imagen");
        }
        iconAviso = new ImageIcon(iconAviso).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel LabelImagen = new JLabel(new ImageIcon(iconAviso));
        LabelImagen.setBounds(50, 30, 100, 100);
        PanelAviso.add(LabelImagen);

        JLabel LabelTexto = new JLabel(Mensaje);
        LabelTexto.setBounds(160, 80, 300, 20);
        PanelAviso.add(LabelTexto);

        PanelAviso.setBackground(Color.WHITE);

        this.add(PanelAviso);

    }

    private void defaulConfiguration() {
        this.setSize(400, 200);
        this.setTitle("Algo Paso");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

}
