package com.elcai.compraventaElCAI.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placa", length = 20, nullable = false)
    private String Placa;
    @Column(name = "marca", length = 20, nullable = false)
    private String Marca;
    @Column(name = "modelo", length = 50, nullable = false)
    private String Modelo;
    @Column(name = "valor", nullable = false)
    private Float Valor;
    @Column(name = "estado", nullable = false)
    private String Estado = "disponible";

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, Float valor, String estado) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Valor = valor;
        Estado = estado;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float valor) {
        Valor = valor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
