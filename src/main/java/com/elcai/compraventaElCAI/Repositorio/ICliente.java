package com.elcai.compraventaElCAI.Repositorio;

import com.elcai.compraventaElCAI.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICliente extends JpaRepository<Cliente, String> {
    List<Cliente> findByNombre(String Nombre);

    List<Cliente> findByEstado(String Estado);
}

