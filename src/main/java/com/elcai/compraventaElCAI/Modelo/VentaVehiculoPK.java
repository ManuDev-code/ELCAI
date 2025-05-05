package com.elcai.compraventaElCAI.Modelo;

import jakarta.persistence.Column;

import java.io.Serializable;

public class VentaVehiculoPK implements Serializable {
    @Column(name = "id_cliente")
    private String ID;
    @Column(name = "placa_vehiculo")
    private String Placa;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }
}
