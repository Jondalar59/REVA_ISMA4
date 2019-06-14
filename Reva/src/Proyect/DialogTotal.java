package Proyect;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Proyect.ContainerTotal;
import java.awt.Color;

/**
 *
 * @author Jondalar
 */
public class DialogTotal extends JDialog {

    private Conexion conexion;

    public DialogTotal() {
        conexion = new Conexion("Ganado", "root", "");
        in();
        form();


        /*ContainerTotal containerTotal = new ContainerTotal(conexion);
        this.add(containerTotal);*/
    }

    private void in() {

        JPanel JPanelPanel = new JPanel();
        /*JPanelPanel.setLayout(null);

        JLabel LabelBoard = new JLabel("Tabla");
        LabelBoard.setBounds(((getWidth() / 2) - 50), 10, 100, 20);
        JPanelPanel.add(LabelBoard);

        JLabel LabelEarring = new JLabel("Arete");
        LabelEarring.setBounds(10, 50, 100, 20);
        JPanelPanel.add(LabelEarring);

        JLabel LabelWeight = new JLabel("Peso");
        LabelWeight.setBounds(110, 50, 100, 20);
        JPanelPanel.add(LabelWeight);

        JLabel LabelBreed = new JLabel("Raza");
        LabelBreed.setBounds(220, 50, 100, 20);
        JPanelPanel.add(LabelBreed);

        JLabel LabelSex = new JLabel("Sexo");
        LabelSex.setBounds(330, 50, 90, 20);
        JPanelPanel.add(LabelSex);

        JLabel LabelBirth = new JLabel("Nacimiento");
        LabelBirth.setBounds(420, 50, 100, 20);
        JPanelPanel.add(LabelBirth);
        JPanelPanel.setBackground(Principal.ColorBlueSky);
         */

        ContainerTotal containerTotal = new ContainerTotal(conexion, this);
        JPanelPanel.add(containerTotal);
        JPanelPanel.setBackground(Color.WHITE);
        this.add(JPanelPanel);
    }

    private void form() {
        this.setTitle("Registro Total");
        this.pack();
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Todos los Registros");

    }

}
