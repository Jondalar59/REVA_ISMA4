/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect;

/**
 *
 * @author Jondalar
 */
public class RegistrosMenos {

    private int id_venta;
    private int arete;
    private String venta_muerte;
    private String Fecha;

    public RegistrosMenos(int id_venta, int arete, String venta_muerte, String Fecha) {
        this.id_venta = id_venta;
        this.arete = arete;
        this.venta_muerte = venta_muerte;
        this.Fecha = Fecha;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setArete(int arete) {
        this.arete = arete;
    }

    public void setVenta_muerte(String venta_vuerte) {
        this.venta_muerte = venta_muerte;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getArete() {
        return arete;
    }

    public String getVenta_muerte() {
        return venta_muerte;
    }

    public String getFecha() {
        return Fecha;
    }

}
