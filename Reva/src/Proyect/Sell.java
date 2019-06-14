package Proyect;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Jondalar
 */
public class Sell extends JDialog {

    public static Conexion conexion;

    private JPanel PanelRegister;

    public Sell() {
        conexion = new Conexion("ganado", "root", "");

        //Ventana de Venta
        //JDialog para registrar la venta o muerte esta como falso para
        this.setVisible(false);                      // activarse con el boton correspondiente
        this.setLocation(420, 250);                    // con color de fondo y un panel para ingresar y acomodar
        this.setSize(new Dimension(355, 250));          // los elementos
        this.setResizable(false);
        this.setTitle("Registro de Venta o Muerte");

        inside();

    }

    public void inside() {
        //Interior de Venta
        PanelRegister = new JPanel();
        PanelRegister.setBackground(Principal.ColorBlueSky);

        PanelRegister.setLayout(null);

        Image iconFondo = null;
        try {

            iconFondo = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\Logo.jpg"));

        } catch (Throwable e) {
            System.err.println("Error con el Fondo ");
        }
        iconFondo = new ImageIcon(iconFondo).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        JLabel LabelBack = new JLabel(new ImageIcon(iconFondo));
        LabelBack.setBounds(10, 10, 180, 180);
        PanelRegister.add(LabelBack);               //Imagen del logo

        JLabel LabelEarring = new JLabel("N° de Arete");   //Label indica lo que se solicita
        LabelEarring.setBounds(220, 10, 100, 20);
        PanelRegister.add(LabelEarring);

        JTextField TextFieldEarring = new JTextField("");// text fiel para poder ingresar el numero de arete
        TextFieldEarring.setBounds(200, 40, 100, 20);
        PanelRegister.add(TextFieldEarring);

        JLabel LabelSell = new JLabel("Venta");
        LabelSell.setBounds(215, 70, 80, 20); //Labels para poder distinguir Venta de muete
        PanelRegister.add(LabelSell);

        JRadioButton RadioButtonSell = new JRadioButton("Venta", true);
        RadioButtonSell.setBounds(225, 95, 20, 20);
        PanelRegister.add(RadioButtonSell);
        RadioButtonSell.setActionCommand("V");
        RadioButtonSell.setBackground(Principal.ColorBlueSky);

        JLabel LabelDeath = new JLabel("Muerte");
        LabelDeath.setBounds(260, 70, 80, 20);
        PanelRegister.add(LabelDeath);                        // RadioButtons para escojer el motivo de la baja

        JRadioButton RadioButtonDeath = new JRadioButton("Muerte", false);
        RadioButtonDeath.setBounds(265, 95, 20, 20);
        RadioButtonDeath.setActionCommand("M");
        RadioButtonDeath.setBackground(Principal.ColorBlueSky);
        PanelRegister.add(RadioButtonDeath);

        ButtonGroup ButtonGroupDecline = new ButtonGroup();  // ButtonGroup para que solo se pueda escojer uno de los dos sexos
        ButtonGroupDecline.add(RadioButtonDeath);
        ButtonGroupDecline.add(RadioButtonSell);

        JLabel LabelBirth = new JLabel("Fecha");// label que pide la fecha de nacimiento
        LabelBirth.setBounds(230, 115, 150, 20);
        PanelRegister.add(LabelBirth);

        JComboBox comboDia = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            if (i <= 9) {
                comboDia.addItem("0" + i);
            } else {
                comboDia.addItem("" + i);
            }
        }
        // textfield para poder ingresar la fecha de nacimiento
        comboDia.setBounds(190, 155, 50, 20);
        PanelRegister.add(comboDia);

        JComboBox comboMes = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            if (i <= 9) {
                comboMes.addItem("0" + i);
            } else {
                comboMes.addItem("" + i);
            }
        }
        comboMes.setBounds(240, 155, 50, 20);
        PanelRegister.add(comboMes);

        JComboBox comboAño = new JComboBox();
        for (int i = 1990; i <= 2019; i++) {

            comboAño.addItem("" + i);

        }
        // textfield para poder ingresar la fecha de nacimiento
        comboAño.setBounds(290, 155, 60, 20);
        PanelRegister.add(comboAño);

        JButton ButtonSave = new JButton("Guardar");
        ButtonSave.setBounds(40, 200, 90, 20);
        PanelRegister.add(ButtonSave);

        ButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Arete, venta_muerte, Fecha;
                Arete = TextFieldEarring.getText();
                Fecha = (String) comboAño.getSelectedItem();
                Fecha += ("-" + comboMes.getSelectedItem());
                Fecha += ("-" + comboDia.getSelectedItem());
                venta_muerte = ButtonGroupDecline.getSelection().getActionCommand();

                conexion.SellDeth(Arete, venta_muerte, Fecha);

                TextFieldEarring.setText("");

            }
        });

        this.add(PanelRegister);  // agregado de todo

    }

}
