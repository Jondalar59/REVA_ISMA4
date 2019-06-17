package Proyect;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewRegister extends JDialog {

    public static Conexion conexion;
    public static String Arete, Peso, Raza, Sexo, Nacimento;
    private static NewRegister temp;
    private static String id;

    public NewRegister() {

        conexion = new Conexion("ganado", "root", "");

        //Ventana de nuevo Registro
        this.setVisible(false);
        this.setTitle("Nuevo Registro");
        this.setLocation(400, 200);
        this.setSize(new Dimension(400, 400));
        this.setResizable(false);
        insideRegister();
        this.add(PanelRegister);  //agregado de todo a la ventana de Nuevo registro
        temp = this;
    }

    public NewRegister(Registros r) {
        conexion = new Conexion("ganado", "root", "");

        //Ventana de nuevo Registro
        this.setTitle("Actualizar Registro");
        this.setLocation(400, 200);
        this.setSize(new Dimension(400, 400));
        this.setResizable(false);
        insideRegister(r);
        this.add(PanelRegister);  //agregado de todo a la ventana de Nuevo registro
        temp = this;
        this.id = id;
    }

    public static void clearPanel() {
        PanelRegister = new JPanel();
        insideRegister();
    }

    public static JPanel PanelRegister = new JPanel();
    public static int NuevoEditar = 0;

    public static void insideRegister() {
        PanelRegister.removeAll();

        PanelRegister.setBackground(Principal.ColorBlueSky);

        PanelRegister.setLayout(null);
        //Interior de nuevo Registro
        JLabel LabelEarring = new JLabel("N° de Arete");   //Label indica lo que se solicita
        LabelEarring.setBounds(40, 10, 100, 20);
        PanelRegister.add(LabelEarring);

        JTextField TextFieldEarring = new JTextField("");// text fiel para poder ingresar el numero de arete
        TextFieldEarring.setBounds(20, 40, 150, 20);
        PanelRegister.add(TextFieldEarring);

        JLabel LabelWeight = new JLabel("Peso del elemento");// label para pedir el peso
        LabelWeight.setBounds(40, 95, 150, 20);
        PanelRegister.add(LabelWeight);

        JTextField TextFieldWeight = new JTextField("");// textField para poder ingresar el peso
        TextFieldWeight.setBounds(20, 120, 150, 20);
        PanelRegister.add(TextFieldWeight);

        JLabel LabelBreed = new JLabel("Raza");// label que pide ingresar la raz
        LabelBreed.setBounds(220, 95, 100, 20);
        PanelRegister.add(LabelBreed);

        JComboBox comboBreed = new JComboBox();//textField para poder ingresar la raza
        comboBreed.addItem("Beefmaster");
        comboBreed.addItem("Charolais");
        comboBreed.addItem("Simmental");
        comboBreed.addItem("Angus");
        comboBreed.addItem("Brangus");
        comboBreed.addItem("Santa Gertrudis");
        comboBreed.addItem("Limousin");
        comboBreed.addItem("Hereford");
        comboBreed.addItem("Cebú Brahman");
        comboBreed.addItem("Belgian Blue");
        comboBreed.addItem("Suiza");
        comboBreed.addItem("Jersey");
        comboBreed.addItem("Holstein");
        comboBreed.addItem("Holstein-freisian");
        comboBreed.addItem("Otra");

        comboBreed.setBounds(200, 120, 160, 20);
        PanelRegister.add(comboBreed);

        JLabel LabelMale = new JLabel("Macho");
        LabelMale.setBounds(220, 150, 80, 20); //Labels para poder distinguir machos de  hembras
        PanelRegister.add(LabelMale);

        JRadioButton RadioButtonMale = new JRadioButton("Macho", true);
        RadioButtonMale.setBounds(230, 175, 20, 20);
        RadioButtonMale.setBackground(Principal.ColorBlueSky);
        RadioButtonMale.setActionCommand("M");
        PanelRegister.add(RadioButtonMale);

        JLabel LabelFemale = new JLabel("Hembra");
        LabelFemale.setBounds(290, 150, 80, 20);
        PanelRegister.add(LabelFemale);                        // RadioButtons para escojer el sexo

        JRadioButton RadioButtonFemale = new JRadioButton("Hembra", false);
        RadioButtonFemale.setBounds(310, 175, 20, 20);
        RadioButtonFemale.setBackground(Principal.ColorBlueSky);
        RadioButtonFemale.setActionCommand("H");
        PanelRegister.add(RadioButtonFemale);

        ButtonGroup ButtonGroupSex = new ButtonGroup();  // ButtonGroup para que solo se pueda escojer uno de los dos sexos
        ButtonGroupSex.add(RadioButtonMale);
        ButtonGroupSex.add(RadioButtonFemale);

        JLabel LabelBirth = new JLabel("Fecha de Nacimiento");// label que pide la fecha de nacimiento
        LabelBirth.setBounds(220, 10, 150, 20);
        PanelRegister.add(LabelBirth);

        JComboBox comboDia = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            if (i <= 9) {
                comboDia.addItem("0" + i);
            } else {
                comboDia.addItem("" + i);
            }
        }
        comboDia.setBounds(200, 30, 50, 20);
        PanelRegister.add(comboDia);

        JComboBox comboMes = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            if (i < 9) {
                comboMes.addItem("0" + i);
            } else {
                comboMes.addItem("" + i);
            }
        }
        comboMes.setBounds(260, 30, 50, 20);
        PanelRegister.add(comboMes);

        JComboBox comboAño = new JComboBox();
        for (int i = 1990; i <= 2019; i++) {
            comboAño.addItem("" + i);

        }
        comboAño.setBounds(320, 30, 60, 20);
        PanelRegister.add(comboAño);

        JButton ButtonSave = new JButton("Guardar");
        ButtonSave.setBounds(230, 240, 100, 40);
        PanelRegister.add(ButtonSave);

        Image iconFondo = null;
        try {

            iconFondo = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\Logo.jpg"));

        } catch (Throwable e) {
            System.err.println("Error con el Fondo ");
        }
        iconFondo = new ImageIcon(iconFondo).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        JLabel LabelBack = new JLabel(new ImageIcon(iconFondo));
        LabelBack.setBounds(5, 160, 180, 180);
        PanelRegister.add(LabelBack);               //Imagen del logo

        ButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Arete = TextFieldEarring.getText();
                    Peso = TextFieldWeight.getText();
                    Raza = (String) comboBreed.getSelectedItem();
                    Nacimento = (String) comboAño.getSelectedItem();
                    Nacimento += ("-" + comboMes.getSelectedItem());
                    Nacimento += ("-" + comboDia.getSelectedItem());
                    Sexo = ButtonGroupSex.getSelection().getActionCommand();
                    if (NuevoEditar == 0) {
                        boolean realiazarconexion = true;
                        ResultSet r = conexion.getArete();
                        while (r.next()) {
                            if (Arete.equals(r.getString("Arete"))) {

                                new Aviso("Arete ya registrado").setVisible(true);
                                //JOptionPane.showMessageDialog(null, "Arete Repetido Ingresa uno nuevo");
                                realiazarconexion = false;
                            }
                        }
                        if (realiazarconexion == true) {
                            conexion.InsertRegitry(Arete, Peso, Raza, Sexo, Nacimento);

                            TextFieldEarring.setText("");
                            TextFieldWeight.setText("");

                        } else {
                            TextFieldEarring.setText("");
                            // JOptionPane.showMessageDialog(null, "Arete Repetido");
                            new Aviso("Arete repetido").setVisible(true);
                        }
                    } else {
                        try {
                            conexion.updateUser(id, Arete, Peso, Raza, Sexo, Nacimento);

                            temp.dispose();
                            clearPanel();
                            DialogTotal dialog = new DialogTotal();
                            dialog.setVisible(true);
                            ModelTableRegistros model = new ModelTableRegistros();
                            model.clear();
                        } catch (Exception e) {
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

                NuevoEditar = 0;

            }
        });

    }

    public static void insideRegister(Registros r) {
        PanelRegister.removeAll();

        PanelRegister.setBackground(Principal.ColorBlueSky);

        PanelRegister.setLayout(null);
        //Interior de nuevo Registro
        JLabel LabelEarring = new JLabel("N° de Arete");   //Label indica lo que se solicita
        LabelEarring.setBounds(40, 10, 100, 20);
        PanelRegister.add(LabelEarring);

        JTextField TextFieldEarring = new JTextField();// text fiel para poder ingresar el numero de arete
        TextFieldEarring.setBounds(20, 40, 150, 20);
        TextFieldEarring.setText(Integer.toString(r.getArete()));
        PanelRegister.add(TextFieldEarring);

        JLabel LabelWeight = new JLabel("Peso del elemento");// label para pedir el peso
        LabelWeight.setBounds(40, 95, 150, 20);
        PanelRegister.add(LabelWeight);

        JTextField TextFieldWeight = new JTextField();// textField para poder ingresar el peso
        TextFieldWeight.setBounds(20, 120, 150, 20);
        TextFieldWeight.setText(Double.toString(r.getPeso()));
        PanelRegister.add(TextFieldWeight);

        JLabel LabelBreed = new JLabel("Raza");// label que pide ingresar la raz
        LabelBreed.setBounds(220, 95, 100, 20);
        PanelRegister.add(LabelBreed);

        JComboBox comboBreed = new JComboBox();//textField para poder ingresar la raza
        String[] razas = {"Beefmaster", "Charolais", "Simmental", "Angus", "Brangus", "Santa Gertrudis", "Limousin", "Hereford", "Cebú Brahman", "Belgian Blue",
            "Suiza", "Jersey", "Holstein", "Holstein-freisian", "Otra"};
        int index = 0;
        for (int i = 0; i < razas.length; i++) {
            comboBreed.addItem(razas[i]);
        }
        comboBreed.setSelectedItem(r.getRaza());
        comboBreed.setBounds(200, 120, 160, 20);
        PanelRegister.add(comboBreed);

        JLabel LabelMale = new JLabel("Macho");
        LabelMale.setBounds(220, 150, 80, 20); //Labels para poder distinguir machos de  hembras
        PanelRegister.add(LabelMale);

        JRadioButton RadioButtonMale = new JRadioButton("Macho", true);
        RadioButtonMale.setBounds(230, 175, 20, 20);
        RadioButtonMale.setBackground(Principal.ColorBlueSky);
        RadioButtonMale.setActionCommand("M");
        PanelRegister.add(RadioButtonMale);

        JLabel LabelFemale = new JLabel("Hembra");
        LabelFemale.setBounds(290, 150, 80, 20);
        PanelRegister.add(LabelFemale);                        // RadioButtons para escojer el sexo

        JRadioButton RadioButtonFemale = new JRadioButton("Hembra", false);
        RadioButtonFemale.setBounds(310, 175, 20, 20);
        RadioButtonFemale.setBackground(Principal.ColorBlueSky);
        RadioButtonFemale.setActionCommand("H");
        PanelRegister.add(RadioButtonFemale);

        ButtonGroup ButtonGroupSex = new ButtonGroup();  // ButtonGroup para que solo se pueda escojer uno de los dos sexos
        ButtonGroupSex.add(RadioButtonMale);
        ButtonGroupSex.add(RadioButtonFemale);

        if (r.getSexo().equals("M")) {
            RadioButtonMale.setSelected(true);
        } else {
            RadioButtonFemale.setSelected(true);
        }

        String StringDia, StringMes, StringAño, StringFecha;

        StringFecha = r.getNacimiento();

        String[] PartesFecha = StringFecha.split("-");
        StringAño = PartesFecha[0];
        StringMes = PartesFecha[1];
        StringDia = PartesFecha[2];

        JLabel LabelBirth = new JLabel("Fecha de Nacimiento");// label que pide la fecha de nacimiento
        LabelBirth.setBounds(220, 10, 150, 20);
        PanelRegister.add(LabelBirth);

        JComboBox comboDia = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            if (i <= 9) {
                comboDia.addItem("0" + i);
            } else {
                comboDia.addItem("" + i);
            }
        }
        comboDia.setBounds(200, 30, 50, 20);
        comboDia.setSelectedItem(StringDia);
        PanelRegister.add(comboDia);

        JComboBox comboMes = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            if (i < 9) {
                comboMes.addItem("0" + i);
            } else {
                comboMes.addItem("" + i);
            }
        }
        comboMes.setSelectedItem(StringMes);
        comboMes.setBounds(260, 30, 50, 20);
        PanelRegister.add(comboMes);

        JComboBox comboAño = new JComboBox();
        for (int i = 1990; i <= 2019; i++) {
            comboAño.addItem("" + i);

        }
        comboAño.setSelectedItem(StringAño);
        comboAño.setBounds(320, 30, 60, 20);
        PanelRegister.add(comboAño);

        JButton ButtonSave = new JButton("Guardar");
        ButtonSave.setBounds(230, 240, 100, 40);
        PanelRegister.add(ButtonSave);

        Image iconFondo = null;
        try {

            iconFondo = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\Logo.jpg"));

        } catch (Throwable e) {
            System.err.println("Error con el Fondo ");
        }
        iconFondo = new ImageIcon(iconFondo).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        JLabel LabelBack = new JLabel(new ImageIcon(iconFondo));
        LabelBack.setBounds(5, 160, 180, 180);
        PanelRegister.add(LabelBack);               //Imagen del logo

        ButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Arete = TextFieldEarring.getText();
                    Peso = TextFieldWeight.getText();
                    Raza = (String) comboBreed.getSelectedItem();
                    Nacimento = (String) comboAño.getSelectedItem();
                    Nacimento += ("-" + comboMes.getSelectedItem());
                    Nacimento += ("-" + comboDia.getSelectedItem());
                    Sexo = ButtonGroupSex.getSelection().getActionCommand();
                    if (NuevoEditar == 0) {
                        boolean realiazarconexion = true;
                        ResultSet r = conexion.getArete();
                        while (r.next()) {
                            if (Arete.equals(r.getString("Arete"))) {

                                new Aviso("Arete ya registrado").setVisible(true);
                                //JOptionPane.showMessageDialog(null, "Arete Repetido Ingresa uno nuevo");
                                realiazarconexion = false;
                            }
                        }
                        if (realiazarconexion == true) {
                            conexion.InsertRegitry(Arete, Peso, Raza, Sexo, Nacimento);

                            TextFieldEarring.setText("");
                            TextFieldWeight.setText("");

                        } else {
                            TextFieldEarring.setText("");
                            // JOptionPane.showMessageDialog(null, "Arete Repetido");
                            new Aviso("Arete repetido").setVisible(true);
                        }
                    } else {
                        try {
                            conexion.updateUser(Integer.toString(r.getId()), Arete, Peso, Raza, Sexo, Nacimento);
                            temp.dispose();
                            clearPanel();
                            DialogTotal dialog = new DialogTotal();
                            dialog.setVisible(true);
                            ModelTableRegistros model = new ModelTableRegistros();
                            model.clear();
                        } catch (Exception e) {
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

                NuevoEditar = 0;

            }
        });

    }

}
