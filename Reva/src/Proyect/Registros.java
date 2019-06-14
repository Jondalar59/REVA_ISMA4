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
public class Registros {

    private int id;
    private int arete;
    private double peso;
    private String raza;
    private String sexo;
    private String nacimiento;

    public Registros(int id, int arete, double peso, String raza, String sexo, String nacimiento) {
        this.id = id;
        this.arete = arete;
        this.peso = peso;
        this.raza = raza;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
    }

    public int getId() {
        return id;
    }

    public int getArete() {
        return arete;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaza() {
        return raza;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArete(int arete) {
        this.arete = arete;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

}
