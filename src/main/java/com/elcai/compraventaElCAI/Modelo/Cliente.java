package com.elcai.compraventaElCAI.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 20, nullable = false)
    private String ID;
    @Column(name = "nombre", length = 100, nullable = false)
    private String Nombre;
    @Column(name = "direccion", length = 200, nullable = false )
    private String Direccion;
    @Column(name = "telefono", length = 20, nullable = false)
    private String Telefono;
    @Column(name = "estado")
    private String Estado = "activo";

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    List<Venta> ventas;
    public Cliente() {
    }

    public Cliente(String ID, String nombre, String direccion, String telefono, String estado) {
        this.ID = ID;
        Nombre = nombre;
        Direccion = direccion;
        Telefono = telefono;
        Estado = estado;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
