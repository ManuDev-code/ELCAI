package com.elcai.compraventaElCAI.Servicio;

import com.elcai.compraventaElCAI.Modelo.Vehiculo;
import com.elcai.compraventaElCAI.Repositorio.IVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioVehiculo {

    // Inyectar repositorio de modelo
    @Autowired
    IVehiculo iVehiculo;

    public Vehiculo guardar(String placa, Vehiculo datosGuardar) throws Exception {
        try {
            Optional<Vehiculo> vehiculoEncontrado = this.iVehiculo.findById(placa);
            if (!vehiculoEncontrado.isPresent())
                return this.iVehiculo.save(datosGuardar);
            else {
                throw new Exception("El vehículo ya fue registrado");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // Fin del metodo guardar

    public List<Vehiculo> consultaGeneral() throws Exception {
        try {
            return this.iVehiculo.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin del metodo consulta general


    public Vehiculo consultaIndividual(String placaVehiculo) throws Exception {
        try {
            Optional<Vehiculo> vehiculoEncontrado = this.iVehiculo.findById(placaVehiculo);
            if (vehiculoEncontrado.isPresent())
                return vehiculoEncontrado.get();
            else
                throw new Exception("Vehiculo no encontrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin del metodo consulta individual

    public List<Vehiculo> consultarMarca(String marca) throws Exception {
        try {
            return this.iVehiculo.findByMarca(marca);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarVehiculo (String placaVehiculo) throws Exception {
        try {
            Optional<Vehiculo> vehiculoEncontrado = this.iVehiculo.findById(placaVehiculo);
            if (vehiculoEncontrado.isPresent()){
                this.iVehiculo.deleteById(placaVehiculo);
                return true;
            } else {
                throw new Exception("No se pudo eliminar el vehículo porque no está registrada la placa: " + placaVehiculo);
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin del metodo eliminar

    public Vehiculo modificarVehiculo (String placaVehiculo, Vehiculo datosModificar) throws Exception {
        try {
            Optional<Vehiculo> vehiculoEncontrado = this.iVehiculo.findById(placaVehiculo);
            if (vehiculoEncontrado.isPresent()){
                Vehiculo vehiculoModificar = vehiculoEncontrado.get();
                vehiculoModificar.setMarca(datosModificar.getMarca());
                vehiculoModificar.setModelo(datosModificar.getModelo());
                vehiculoModificar.setValor(datosModificar.getValor());
                vehiculoModificar.setEstado(datosModificar.getEstado());
                return this.iVehiculo.save(vehiculoModificar);
            } else {
                throw new Exception("No se puede modificar el auto porque la placa " + placaVehiculo + " no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        } // Fin del metodo modificar
    }
}
