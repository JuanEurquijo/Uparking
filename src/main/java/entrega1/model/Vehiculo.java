/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega1.model;

/**
 *
 * @author User
 */
public class Vehiculo {
    
    private String propietrario;
    private String tipoVeh;
    private String placa;
    private String modelo;
    private int anio;
    private String marca;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String propietrario, String tipoVeh, String placa, String modelo, int anio, String marca, String color) {
        this.propietrario = propietrario;
        this.tipoVeh = tipoVeh;
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.marca = marca;
        this.color = color;
    }

    public String getPropietrario() {
        return propietrario;
    }

    public void setPropietrario(String propietrario) {
        this.propietrario = propietrario;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  propietrario + "," + tipoVeh + "," + placa + "," + modelo + "," + anio + "," + marca + "," + color;
    }

    
    
    

    
}
