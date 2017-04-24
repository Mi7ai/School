package factoria;

import java.time.LocalDateTime;

import facturacion.Tarifa;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Empresa;
import tipoClientes.Particular;

public class FactoriaCliente implements FactoriaClientes{

	@Override
	public Cliente crearClienteParticular(String nombre, String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion, String apellido) {
		return new Particular(nombre, NIF, correo, fechaAlta, tarifa, direccion, apellido);
	}

	@Override
	public Cliente crearClienteEmpresa(String nombre, String NIF, String correo, LocalDateTime fechaAlta, Tarifa tarifa,Direccion direccion) {
		return new Empresa(nombre, NIF, correo, fechaAlta, tarifa, direccion);
	}

}
