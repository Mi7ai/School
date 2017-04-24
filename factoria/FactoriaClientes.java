package factoria;

import java.time.LocalDateTime;

import facturacion.Tarifa;
import tipoClientes.Cliente;
import tipoClientes.Direccion;

public interface FactoriaClientes {
	public Cliente crearClienteParticular(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion,String apellido);
	public Cliente crearClienteEmpresa(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion);

}
