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
    private Double precioPactado;
    private Double precioInicial;
    private Double contraofertaCliente;
    private Boolean aceptadoPorVendedor;

    public Double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(Double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public Double getContraofertaCliente() {
        return contraofertaCliente;
    }

    public void setContraofertaCliente(Double contraofertaCliente) {
        this.contraofertaCliente = contraofertaCliente;
    }

    public Boolean getAceptadoPorVendedor() {
        return aceptadoPorVendedor;
    }

    public void setAceptadoPorVendedor(Boolean aceptadoPorVendedor) {
        this.aceptadoPorVendedor = aceptadoPorVendedor;
    }

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

    public Venta(Integer codigo, String idCliente, String placa, Double precioPactado) {
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

    public Double getPrecioPactado() {
        return precioPactado;
    }

    public void setPrecioPactado(Double precioPactado) {
        this.precioPactado = precioPactado;
    }
}
