package com.elcai.compraventaElCAI.Controlador;

import com.elcai.compraventaElCAI.Modelo.Venta;
import com.elcai.compraventaElCAI.Servicio.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class ControladorVenta {

    @Autowired
    ServicioVenta servicioVenta;

    @PostMapping("/{codigo}")
    public ResponseEntity<?> guardar (@PathVariable int codigo, @RequestBody Venta ventaNueva) throws Exception {
        try {
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicioVenta.guardar(codigo, ventaNueva));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> consultaGeneral() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVenta.consultaGeneral());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> consultaIndividual(@PathVariable int codigo) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVenta.consultaIndividual(codigo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @DeleteMapping("/{placa}")
    public ResponseEntity<?> eliminarVenta (@PathVariable int codigo) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVenta.eliminarVenta(codigo));

        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @PutMapping("/placa")
    public ResponseEntity<?> modificarVenta(@PathVariable int codigo, @RequestBody Venta datosModificar) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioVenta.modificarVenta(codigo, datosModificar));

        } catch (Exception error) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @PutMapping("/negociar/{codigo}")
    public Venta negociarPrecio(
            @PathVariable int codigo,
            @RequestBody Double contraofertaCliente
    ) throws Exception {
        return servicioVenta.negociarPrecio(codigo, contraofertaCliente);
    }
}
