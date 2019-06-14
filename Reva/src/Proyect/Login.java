package Proyect;

import static Proyect.Principal.high;
import static Proyect.Principal.width;
import static Proyect.Principal.ColorBlueSky;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jondalar
 */
public class Login extends JDialog {

    private Aviso aviso;

    public Login() {

        Components();
        Form();

    }

    private void Components() {
        //Interior de la entrada

        JPanel contenedor = new JPanel();// crea el contenedor para la ventana
        contenedor.setLayout(null);     //da el contenedor hacia abajo
        this.add(contenedor);

        JLabel LabelWelcome = new JLabel("Bienvenido");   // JLabel para poner el bienvenido
        LabelWelcome.setBounds(370, 0, 200, 40);
        contenedor.add(LabelWelcome);// lo agrega a la ventana
        LabelWelcome.setFont(new Font("Arial", Font.BOLD, 32));//caracteristicas de la letra
        LabelWelcome.setForeground(Color.blue);// color de la letra
        LabelWelcome.setBackground(Color.green);

        JLabel LabelStart = new JLabel("Iniciar Sesión"); //JLabel que dice inicio de sesion
        LabelStart.setBounds(395, 50, 130, 20);
        contenedor.add(LabelStart);
        LabelStart.setFont(new Font("Arial", Font.BOLD, 16));
        LabelStart.setForeground(Color.BLACK);

        JLabel LabelUser = new JLabel("Usuario:");  //Jlabel que dice que pide tu usuario
        LabelUser.setBounds(600, 100, 100, 30);
        contenedor.add(LabelUser);
        LabelUser.setFont(new Font("Arial", Font.PLAIN, 26));

        JTextField JTextfielUser = new JTextField(""); // JText registra tu usuario para comparar con el autorizado
        JTextfielUser.setBounds(575, 140, 140, 30);
        contenedor.add(JTextfielUser);
        JTextfielUser.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel LabelPasword = new JLabel("Contraseña:");//Jlabel pide que ingreses la contraseña
        contenedor.add(LabelPasword);
        LabelPasword.setBounds(575, 200, 200, 30);
        LabelPasword.setFont(new Font("Arial", Font.PLAIN, 26));

        JPasswordField JPaswordPasword = new JPasswordField("");// JPassword registra tu contraseña para comparar
        JPaswordPasword.setBounds(575, 240, 140, 30);
        contenedor.add(JPaswordPasword);

        JButton ButtonEnter = new JButton("Entrar"); //Es el boton que valida la información y permite activar la otra pantalla
        ButtonEnter.setBounds(555, 500, 200, 40);
        contenedor.add(ButtonEnter);
        ButtonEnter.setFont(new Font("Arial", Font.PLAIN, 32));
        ButtonEnter.setBackground(ColorBlueSky);
        Login temp = this;

        Image iconFondo = null;
        try {
            //          Icono de Fondo para login
            iconFondo = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\FondoLogin.jpg"));

        } catch (IOException e) {
            System.err.println("Error con el Fondo ");
        }
        iconFondo = new ImageIcon(iconFondo).getImage().getScaledInstance(Principal.width, Principal.high, Image.SCALE_DEFAULT);
        JLabel LabelBack = new JLabel(new ImageIcon(iconFondo));
        LabelBack.setBounds(0, 0, Principal.width, Principal.high);
        contenedor.add(LabelBack);

        ButtonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String StringUser = "admin";
                String StringClave = "admin";
                String StringText = JTextfielUser.getText();
                char[] CharClave = JPaswordPasword.getPassword();
                String claveString = new String(CharClave);

                if (StringText.equals(StringUser) && claveString.equals(StringClave)) {
                    Principal principal = new Principal();
                    principal.setVisible(true);
                    temp.setVisible(false);
                } else {
                    new Aviso("Datos incorrectos intenta nuevamente").setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
                    JTextfielUser.setText("");
                    JPaswordPasword.setText("");
                    return;
                }

            }

        });

    }

    private void Form() {
        //Login para activar la ventana principal
        this.setSize(Principal.width, Principal.high);
        this.setVisible(true);
        this.setLocationRelativeTo(null);// La ventana aparece en el centro de la pantalla
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }
}
