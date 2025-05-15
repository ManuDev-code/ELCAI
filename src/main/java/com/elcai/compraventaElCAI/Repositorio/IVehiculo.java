package com.elcai.compraventaElCAI.Repositorio;

import com.elcai.compraventaElCAI.Modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehiculo extends JpaRepository<Vehiculo, String> {
    List<Vehiculo> findByMarca(String Marca);
}
