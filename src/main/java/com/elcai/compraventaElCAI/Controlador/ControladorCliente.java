package com.elcai.compraventaElCAI.Controlador;

import com.elcai.compraventaElCAI.Modelo.Cliente;
import com.elcai.compraventaElCAI.Servicio.ServicioCliente;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    @Autowired // Indica que se inyecta instancia de servicioCliente
    ServicioCliente servicioCliente;

    @PostMapping("/{idCliente}")
    public ResponseEntity<?> guardar(@PathVariable String idCliente, @RequestBody Cliente datosGuardar) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicioCliente.guardar(idCliente, datosGuardar));
        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo guardar

    @GetMapping("")
    public ResponseEntity<?> consultaGeneral() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.consultaGeneral());
        } catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo consulta general


    @GetMapping("/{idCliente}")
    public ResponseEntity<?> consultaIndividual (@PathVariable String idCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.consultaIndividual(idCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin metodo consulta individual

    @GetMapping("/{nombreCliente}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombreCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.findByNombre(nombreCliente));
        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin metodo consulta por nombre


    @GetMapping("/{estadoCliente}")
    public  ResponseEntity<?> findByEstado (@PathVariable String estadoCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.findByEstado(estadoCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<?> elimininarCliente (@PathVariable String idCliente) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.eliminarCliente(idCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin metodo eliminar


    @PutMapping("/{idCliente}")
    public ResponseEntity<?> modificarCliente(@PathVariable String idCliente, @RequestBody Cliente datosModificar) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioCliente.modificarCliente(idCliente, datosModificar));
        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // Fin del metodo modificar

}
