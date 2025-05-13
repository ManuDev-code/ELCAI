package com.elcai.compraventaElCAI.Controlador;

import com.elcai.compraventaElCAI.Modelo.Vehiculo;
import com.elcai.compraventaElCAI.Servicio.ServicioVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class ControladorVehiculo {

    @Autowired // Para indicar que se inyecta instacia de ServicioVehiculo
    //Inyectar Servicios
    ServicioVehiculo servicioVehiculo;

    @PostMapping("/{placa}")
    public ResponseEntity<?> guardar (@PathVariable String placa, @RequestBody Vehiculo vehiculoNuevo) throws Exception {
        try {
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicioVehiculo.guardar(placa, vehiculoNuevo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo guardar

    @GetMapping("")
    public ResponseEntity<?> consultaGeneral() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVehiculo.consultaGeneral());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo consulta general

    @GetMapping("/{placa}")
    public ResponseEntity<?> consultaIndividual(@PathVariable String placa) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVehiculo.consultaIndividual(placa));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin metodo consulta individual

    @GetMapping("/{marca}")
    public ResponseEntity<?> consultarMarca (@PathVariable String marca) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVehiculo.consultarMarca(marca));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin metodo consulta por marca


    @DeleteMapping("/{placa}")
    public ResponseEntity<?> eliminarVehiculo (@PathVariable String placa) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVehiculo.eliminarVehiculo(placa));

        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo eliminar


    @PutMapping("/placa")
    public ResponseEntity<?> modificarVehiculo(@PathVariable String placa, @RequestBody Vehiculo datosModificar) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVehiculo.modificarVehiculo(placa, datosModificar));

        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    } // Fin del metodo modificar

}
