package com.elcai.compraventaElCAI.Repositorio;

import com.elcai.compraventaElCAI.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICliente extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    List<Cliente> consultaNombreCliente(@Param("nombre") String nombre);

    @Query("SELECT c From Cliente c WHERE c.estado = :estado")
    List<Cliente> consultaEstadoCliente(@Param("estado")String estadoCliente);
}

