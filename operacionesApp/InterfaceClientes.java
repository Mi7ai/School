package operacionesApp;

import java.util.Collection;

import facturacion.Factura;
import tipoClientes.Cliente;

public interface InterfaceClientes {
	public  boolean existeCliente(String NIF);
	public  boolean altaCliente(Cliente Cliente);
	public  String bajaCliente(String NIF);
	public  Cliente getDatosCliente(String NIF);
	public  String cambiarTarifa(String NIF, float precioTarifa);
	public  Collection<Cliente> getListadoClientes();
	
}
