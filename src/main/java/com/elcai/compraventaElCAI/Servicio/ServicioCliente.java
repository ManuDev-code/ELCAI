package com.elcai.compraventaElCAI.Servicio;

import com.elcai.compraventaElCAI.Modelo.Cliente;
import com.elcai.compraventaElCAI.Repositorio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {
    // Inyectar repositorio
    @Autowired
    ICliente iCliente;

    public Cliente guardar(String idCliente, Cliente datosGuardar) throws Exception {
        try {
            Optional<Cliente> clienteEncontrado = this.iCliente.findById(idCliente);
            if(!clienteEncontrado.isPresent())
                return this.iCliente.save(datosGuardar);
            else
                throw new Exception("Cliente ya registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin metodo guardar

    public List<Cliente> consultaGeneral() throws Exception {
        try {
            return this.iCliente.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin metodo consulta general

    public Cliente consultaIndividual(String idCliente) throws Exception {
        try {
            Optional<Cliente> clienteEncontrado = this.iCliente.findById(idCliente);
            if (clienteEncontrado.isPresent())
                return  clienteEncontrado.get();
            else
                throw new Exception("Cliente no está registrado");

        } catch (Exception error) {
            throw new Exception(error);
        }
    } // Fin metodo consulta individual


    public List<Cliente> consultaNombreCliente(String nombreCliente) throws Exception {
        try {
            return this.iCliente.findByNombre(nombreCliente);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin metodo consultar por nombre de usuario


    public List<Cliente> consultaEstadoCliente (String estadoCliente) throws Exception {
        try {
            return this.iCliente.findByEstado(estadoCliente);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // Fin metodo consultar por estado


    public Boolean eliminarCliente(String idCliente) throws Exception {
        try {
            Optional<Cliente> clienteEncontrado = this.iCliente.findById(idCliente);
            if(clienteEncontrado.isPresent()){
                this.iCliente.deleteById(idCliente);
                return true;
            }else {
                throw new Exception("No se puede eliminar cliente de id " + idCliente);
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // Fin del metodo eliminar


    public Cliente modificarCliente (String idCliente, Cliente datosModificar) throws Exception{
        try {
            Optional<Cliente> clienteEncontrado = this.iCliente.findById(idCliente);
            if (clienteEncontrado.isPresent()) {
                Cliente clienteModificar = clienteEncontrado.get();
                clienteModificar.setNombre(datosModificar.getNombre());
                clienteModificar.setDireccion(datosModificar.getDireccion());
                clienteModificar.setTelefono(datosModificar.getTelefono());
                clienteModificar.setEstado(datosModificar.getEstado());
                return this.iCliente.save(clienteModificar);
            } else
                throw new Exception("Usuario no encontrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
