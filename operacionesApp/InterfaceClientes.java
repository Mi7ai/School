package operacionesApp;

import java.time.LocalDateTime;
import java.util.Collection;

import excepciones.ExClienteNoExistente;
import facturacion.Factura;
import facturacion.Fecha;
import tipoClientes.Cliente;

public interface InterfaceClientes {
	public  boolean existeCliente(String NIF);
	public  boolean altaCliente(Cliente Cliente);
	public  boolean bajaCliente(String NIF);
	public  Cliente getDatosCliente(String NIF) throws ExClienteNoExistente;
	public  String cambiarTarifa(String NIF, float precioTarifa);
	public  Collection<Cliente> getListadoClientes();
	<T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
}
