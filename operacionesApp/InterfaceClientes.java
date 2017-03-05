package operacionesApp;

import java.util.Collection;

import facturacion.Factura;
import tipoClientes.Cliente;

public interface InterfaceClientes {
	public  boolean existeCliente(char NIF);
	public  boolean altaCliente(Cliente Cliente);
	public  String bajaCliente(char NIF);
	public  Cliente getDatosCliente(char NIF);
	public  String cambiarTarifa(char NIF, float precioTarifa);
	public  Collection<Cliente> getListadoClientes();
	
}
