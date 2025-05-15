package com.elcai.compraventaElCAI.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placa", length = 20, nullable = false)
    private String placa;
    @Column(name = "marca", length = 20, nullable = false)
    private String marca;
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
    @Column(name = "valor", nullable = false)
    private Float valor;
    @Column(name = "estado", nullable = false)
    private String estado = "disponible";

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, Float valor, String estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
