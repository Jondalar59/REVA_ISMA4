/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jondalar
 */
public class Conexion {

    private Connection conexion;
    private Statement st;
    private Aviso aviso;

    public Conexion(String dataBase, String user, String pass) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + dataBase, user, pass);
            st = (Statement) conexion.createStatement();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Imposible acceder a la base de datos");
            new Aviso("Imposible acceder a la base de datos").setVisible(true);
            System.exit(0);
        }
    }

    public ResultSet getAll() {
        ResultSet result = null;
        try {
            result = st.executeQuery("SELECT * FROM vaca");

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Imposible obtener los registros");
            new Aviso("Imposible obtener los registros").setVisible(true);
        } finally {
            return result;
        }

    }

    public ResultSet getArete() {
        ArrayList<Integer> aretes = new ArrayList<Integer>();

        ResultSet RSaretes = null;
        try {
            RSaretes = st.executeQuery("SELECT Arete from vaca");

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Imposible Obtener los datos de aretes");
            new Aviso("Imposible Obtener los Aretes").setVisible(true);
        }
        return RSaretes;

    }

    public void updateUser(String id_vaca, String Arete, String Peso, String Raza, String Sexo, String Nacimiento) {
        //UPDATE usuarios SET nombre="x", apellido_paterno="x", apellido_materno="x", edad = x WHERE id_usuario = 8
        String update = "UPDATE vaca "
                + "SET Arete =" + Arete + ","
                + " Peso=" + Peso + ","
                + " Raza='" + Raza + "',"
                + " Sexo='" + Sexo + "',"
                + "Nacimiento ='" + Nacimiento + "'"
                + " WHERE idVaca = " + id_vaca;

        JOptionPane.showMessageDialog(null, "Elemento Actualizado");

        try {
            st.executeUpdate(update);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error al Actualizar");
            new Aviso("Error al Actualizar").setVisible(true);
        }
    }

    public ResultSet getAllOut() {
        ResultSet result = null;
        try {
            result = st.executeQuery("SELECT * FROM ventamuerte");

        } catch (SQLException e) {
            new Aviso("Imposible obtener los registros").setVisible(true);
            //JOptionPane.showMessageDialog(null, "Imposible obtener los registros");
        } finally {
            return result;
        }

    }

    public void InsertRegitry(String Arete, String Peso, String Raza, String Sexo, String Nacimiento) {
        String Insert = "INSERT INTO vaca (idVaca, Arete, Peso, Raza, Sexo, Nacimiento) "
                + "VALUES (NULL," + Arete + "," + Peso + ",'" + Raza + "','" + Sexo + "','" + Nacimiento + "')";

        try {
            st.executeUpdate(Insert);
        } catch (SQLException e) {
            new Aviso("No es posible crear el nuevo registro").setVisible(true);
            //JOptionPane.showMessageDialog(null, "Imposible crear el núevo registro");
        }

    }

    public void SellDeth(String Arete, String Causa, String Fecha) {
        String Insert = "INSERT INTO ventamuerte (id_venta, arete ,venta_muerte,Fecha) "
                + "VALUES (NULL," + Arete + ",'" + Causa + "','" + Fecha + "')";

        try {
            st.executeUpdate(Insert);
        } catch (SQLException e) {
            new Aviso("Imposible crear el nuevo registro de salida").setVisible(true);
            //JOptionPane.showMessageDialog(null, "Imposible crear el núevo registro");
        }

        String delete = "DELETE FROM vaca WHERE Arete = " + Arete;
        try {
            st.executeUpdate(delete);
            JOptionPane.showMessageDialog(null, "Registro Guardado");

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "No es posible eliminar al usuario");
            new Aviso("No es posible elimiar el registro antiguo").setVisible(true);
        }

    }

    public void closeConexion() {
        try {
            st.close();
            conexion.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "imposible cerrar conexion");
            new Aviso("No se ha cerrado la Conexión").setVisible(true);
        }

    }
}
