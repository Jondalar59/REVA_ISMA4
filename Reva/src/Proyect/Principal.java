package Proyect;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jondalar
 */
public class Principal extends JFrame {

    public static Color ColorBlueSky = new Color(36, 186, 194);
    public static Color ColorBack = new Color(81, 49, 0);
    public static int high = 700,
            width = 900;
    private static JPanel PanelBase = new JPanel();

    Conexion conexion;

    public Principal() {
        super();

        conexion = new Conexion("ganado", "root", "");

        //Ventana Principal
        this.setSize(new Dimension(width, high));
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);// La ventana aparece en el centro de la pantalla
        PanelBase.setBackground(ColorBack);
        PanelBase.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.repaint();
        initComponents();
        getIconImage();

        //Interior de la Ventana
    }

    /* @Override
    public Image getIconImage() {
        Image retValue = null;
        try {
            retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\Logo.jpg"));
            return retValue;

        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return retValue;
    }*/
    private void initComponents() {

        Image iconFondo = null;
        try {

            iconFondo = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\ReinoVacas.jpg"));

        } catch (Throwable e) {
            System.err.println("Error con el Fondo ");
        }
        iconFondo = new ImageIcon(iconFondo).getImage().getScaledInstance(width, high, Image.SCALE_DEFAULT);
        JLabel LabelBack = new JLabel(new ImageIcon(iconFondo));
        LabelBack.setBounds(1, 1, width, high);

        Image icon = null;
        try {
            icon = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\icono++.jpg"));
        } catch (IOException ex) {
            System.err.println("IMPOSIBLE ACCEDER AL RECURSO icono++.jpg");
        }
        icon = new ImageIcon(icon).getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);

        JButton ButtonNew = new JButton("", new ImageIcon(icon)); // Boton uno para registrar nuevo ganado
        ButtonNew.setFont(new Font("Arial", Font.BOLD, 16));
        ButtonNew.setBounds(500, 20, 200, 180);
        PanelBase.add(ButtonNew);
        String NewString = "Nuevo Registro";
        ButtonNew.setToolTipText(NewString);

        ButtonNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NewRegister newRegister = new NewRegister();
                newRegister.setVisible(true);
            }
        });

        Image icon2 = null;
        try {
            icon2 = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\iconoTT.jpg"));
        } catch (IOException ex) {
            System.err.println("IMPOSIBLE ACCEDER AL RECURSO icono.++");
        }
        icon2 = new ImageIcon(icon2).getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);

        JButton ButtonTotal = new JButton("", new ImageIcon(icon2)); //Boton dos para acceder al registro Total
        ButtonTotal.setFont(new Font("Arial", Font.BOLD, 16));

        ButtonTotal.setBounds(500, 240, 100, 90);
        String TotalString = "Registro General";    // crea el mensaje de lo que hace el boton
        ButtonTotal.setToolTipText(TotalString);

        ButtonTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent bc) {
                DialogTotal dialogTotal = new DialogTotal();
                dialogTotal.setVisible(true);

            }
        });
        PanelBase.add(ButtonTotal);

        Image icon4 = null;
        try {
            icon4 = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\ImagenSalida.jpeg"));
        } catch (IOException ex) {
            System.err.println("IMPOSIBLE ACCEDER AL RECURSO FondoMenos");
        }
        icon4 = new ImageIcon(icon4).getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);

        JButton ButtonMenos = new JButton("", new ImageIcon(icon4)); //Boton dos para acceder al registro Total
        ButtonMenos.setFont(new Font("Arial", Font.BOLD, 16));

        ButtonMenos.setBounds(600, 330, 100, 90);
        String MenosString = "Registro General de salidas";    // crea el mensaje de lo que hace el boton
        ButtonMenos.setToolTipText(MenosString);

        ButtonMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent mc) {
                DialogMenos dialogMenos = new DialogMenos();
                dialogMenos.setVisible(true);

            }
        });

        PanelBase.add(ButtonMenos);

        Image icon3 = null;
        try {
            icon3 = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\Proyect\\Imagenes\\icono--.jpg"));
        } catch (IOException ex) {
            System.err.println("IMPOSIBLE ACCEDER AL RECURSO");
        }
        icon3 = new ImageIcon(icon3).getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);

        JButton ButtonWastage = new JButton("", new ImageIcon(icon3)); //Boton tres para registrar la venta o la muerte de una vaca
        ButtonWastage.setHorizontalTextPosition(SwingConstants.CENTER);
        ButtonWastage.setBounds(500, 470, 200, 180);
        ButtonWastage.setFont(new Font("Arial", Font.BOLD, 16));
        String WastageString = "Registrar Venta o Muerte";
        ButtonWastage.setToolTipText(WastageString);

        PanelBase.add(ButtonWastage);
        ButtonWastage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent VM) {
                Sell sell = new Sell();
                sell.setVisible(true);
            }
        });

        PanelBase.add(LabelBack);
        this.add(PanelBase);//agregado del panel a Principal

    }

}
