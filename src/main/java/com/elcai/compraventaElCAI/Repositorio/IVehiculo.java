package com.elcai.compraventaElCAI.Repositorio;

import com.elcai.compraventaElCAI.Modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculo extends JpaRepository<Vehiculo, String> {
}
