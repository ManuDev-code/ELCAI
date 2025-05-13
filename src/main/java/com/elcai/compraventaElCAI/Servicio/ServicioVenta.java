package com.elcai.compraventaElCAI.Servicio;

import com.elcai.compraventaElCAI.Modelo.Venta;
import com.elcai.compraventaElCAI.Repositorio.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioVenta {

    @Autowired
    IVenta iVenta;

    public Venta guardar(int codigo, Venta datosGuardar) throws Exception {
        try {
            Optional<Venta> ventaFinalizada = this.iVenta.findById(codigo);
            if (!ventaFinalizada.isPresent())
                return this.iVenta.save(datosGuardar);
            else {
                throw new Exception("Numero de factura ya existente");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Venta> consultaGeneral() throws Exception {
        try {
            return this.iVenta.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarVenta (int codigo) throws Exception {
        try {
            Optional<Venta> ventaEncontrada = this.iVenta.findById(codigo);
            if (ventaEncontrada.isPresent()){
                this.iVenta.deleteById(codigo);
                return true;
            } else {
                throw new Exception("No se pudo eliminar la factura por que el codigo: " + codigo + " no existe");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Venta consultaIndividual(int codigo) throws Exception {
        try {
            Optional<Venta> ventaEncontrado = this.iVenta.findById(codigo);
            if (ventaEncontrado.isPresent())
                return ventaEncontrado.get();
            else
                throw new Exception("Codigo de venta no encontrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Venta modificarVenta (int codigo, Venta datosModificar) throws Exception {
        try {
            Optional<Venta> ventaEncontrado = this.iVenta.findById(codigo);
            if (ventaEncontrado.isPresent()){
                Venta ventaModificar = ventaEncontrado.get();
                ventaModificar.setCodigo(datosModificar.getCodigo());
                ventaModificar.setPlaca(datosModificar.getPlaca());
                ventaModificar.setIdCliente(datosModificar.getIdCliente());
                ventaModificar.setPrecioPactado(datosModificar.getPrecioPactado());
                return this.iVenta.save(ventaModificar);
            } else {
                throw new Exception("No se puede modificar la venta porque el codigo de venta " + codigo + " no es existente");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Venta negociarPrecio(int codigo, Double contraofertaCliente) throws Exception {
        try {
            Optional<Venta> ventaOptional = this.iVenta.findById(codigo);
            if (ventaOptional.isPresent()) {
                Venta venta = ventaOptional.get();

                // Suponemos que no se puede ofrecer menos del 80% del precio inicial
                Double precioMinimoAceptable = venta.getPrecioInicial() * 0.8;

                venta.setContraofertaCliente(contraofertaCliente);

                if (contraofertaCliente >= precioMinimoAceptable) {
                    venta.setPrecioPactado(contraofertaCliente);
                    venta.setAceptadoPorVendedor(true);
                } else {
                    venta.setAceptadoPorVendedor(false);
                    throw new Exception("La contraoferta es demasiado baja. El mínimo aceptable es: " + precioMinimoAceptable);
                }

                return this.iVenta.save(venta);
            } else {
                throw new Exception("No se encontró la venta para negociar el precio.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
