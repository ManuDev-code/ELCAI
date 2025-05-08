package com.elcai.compraventaElCAI.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Column(name = "id_cliente", length = 20, nullable = false)
    private String idCliente;
    @Column(name = "placa_vehiculo", length = 20, nullable = false)
    private String placa;
    @Column(name = "precio_pactado", nullable = false)
    private Float precioPactado;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pk_clientes", referencedColumnName = "ID")
    private Cliente cliente;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pk_vehiculos", referencedColumnName = "placa")
    private Vehiculo vehiculo;

    public Venta() {
    }

    public Venta(Integer codigo, String idCliente, String placa, Float precioPactado) {
        this.codigo = codigo;
        this.idCliente = idCliente;
        this.placa = placa;
        this.precioPactado = precioPactado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Float getPrecioPactado() {
        return precioPactado;
    }

    public void setPrecioPactado(Float precioPactado) {
        this.precioPactado = precioPactado;
    }
}
