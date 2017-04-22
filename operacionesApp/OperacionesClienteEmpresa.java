package operacionesApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import excepciones.ExClienteNoExistente;
import facturacion.Fecha;
import genericos.ListadoAPartirDeFecha;
import tipoClientes.Cliente;

public class OperacionesClienteEmpresa implements InterfaceClientes, ListadoAPartirDeFecha, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6801689914571359738L;
	private HashMap<String, Cliente> clientesEmpresas;
	
	public OperacionesClienteEmpresa() {
		 clientesEmpresas = new HashMap<>();
	}

	@Override
	public boolean existeCliente(String NIF) {
		// TODO Auto-generated method stub
		if (clientesEmpresas.containsKey(NIF)) {
			return true;
		}
		return false;
 	}

	@Override
	public boolean altaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if (!existeCliente(cliente.getNIF())) {
			clientesEmpresas.put(cliente.getNIF(), cliente);
			return true;
		}
		return false;
	}

	@Override
	public boolean bajaCliente(String NIF) {
		// TODO Auto-generated method stub
		if (clientesEmpresas.containsKey(NIF)) {
			clientesEmpresas.remove(NIF);			
			return true;
		}
		return false;
		 
	}

	@Override
	public Cliente getDatosCliente(String NIF) throws ExClienteNoExistente{
		// TODO Auto-generated method stub
		if (!clientesEmpresas.containsKey(NIF)) {
			throw new ExClienteNoExistente();		
		}
		return clientesEmpresas.get(NIF);
	}

	@Override
	public String cambiarTarifa(String NIF, float precioTarifa) {
		// TODO Auto-generated method stub
		if (clientesEmpresas.containsKey(NIF)) {
			clientesEmpresas.get(NIF).getTarifa().setPrecioTarifa(precioTarifa);;
		}		 
		return null;

		 
	}

	@Override
	public Collection<Cliente> getListadoClientes() {
		// TODO Auto-generated method stub
		return clientesEmpresas.values();
	}

	@Override
	public <T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();
		for (Fecha f : nuevoConjunto) {//mostrar listado clientes entre 2 fechas
			if (f.getFecha().isAfter(fechaInicio) && f.getFecha().isBefore(fechaFin) ) {
				nuevoConjunto.add(f);
			}			
		}
		return nuevoConjunto;
	}

}
