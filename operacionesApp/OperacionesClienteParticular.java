package operacionesApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import excepciones.ExClienteNoExistente;
import facturacion.Fecha;
import genericos.ListadoAPartirDeFecha;
import modelo.MetodosControlador;
import modelo.MetodosVista;
import tipoClientes.Cliente;

public class OperacionesClienteParticular implements InterfaceClientes, ListadoAPartirDeFecha, Serializable, vista.MetodosModelo, MetodosControlador, MetodosVista  {
	vista.MetodosModelo vista;
	public void setVista(vista.MetodosModelo vista) {
		 this.vista = vista;		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3945477234045171420L;
	private HashMap<String, Cliente> clientesParticulares;
	
	public OperacionesClienteParticular() {
		// TODO Auto-generated constructor stub
		clientesParticulares = new HashMap<>();
	}
	@Override
	public boolean existeCliente(String NIF) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean altaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if (!existeCliente(cliente.getNIF())) {
			clientesParticulares.put(cliente.getNIF(), cliente);
			return true;
		}
	 
		return false;
	}

	@Override
	public boolean bajaCliente(String NIF) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			clientesParticulares.remove(NIF);			
			return true;
		}
		return false;
	}

	@Override
	public Cliente getDatosCliente(String NIF) throws ExClienteNoExistente{
		// TODO Auto-generated method stub
		if (!clientesParticulares.containsKey(NIF)) 
			throw new ExClienteNoExistente();

		return clientesParticulares.get(NIF);					 
	}
	@Override
	public Collection<Cliente> getListadoClientes() {
		// TODO Auto-generated method stub
		return clientesParticulares.values();	
	}
	@Override
	public String cambiarTarifa(String NIF, float precioTarifa) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			clientesParticulares.get(NIF).getTarifa().setPrecioTarifa(precioTarifa);;
		}
		return null;
	}
	@Override
	public <T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin) {
 		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();
 		
		for (T f : conjunto) {//mostrar listado clientes entre 2 fechas
			if (((Fecha) f).getFecha().isAfter(fechaInicio) && ((Fecha) f).getFecha().isBefore(fechaFin) ) {
				nuevoConjunto.add((Fecha) f);
			}			
		}
		return nuevoConjunto;
	}
	@Override
	public void anadirClienteParticular(Cliente particular) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void anadirClienteEmpresa(Cliente empresa) {
		// TODO Auto-generated method stub
		
	}
	 

	 

}
