package com.elcai.compraventaElCAI.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @EmbeddedId
    VentaVehiculoPK Id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "placa_vehiculo")
    private String placa;
}
