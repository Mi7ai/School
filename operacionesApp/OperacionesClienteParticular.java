package operacionesApp;

import java.util.Collection;
import java.util.HashMap;

import tipoClientes.Cliente;

public class OperacionesClienteParticular implements InterfaceClientes{
	private HashMap<Character, Cliente> clientesParticulares;
	
	public OperacionesClienteParticular() {
		// TODO Auto-generated constructor stub
		clientesParticulares = new HashMap<>();
	}
	@Override
	public boolean existeCliente(char NIF) {
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
	public String bajaCliente(char NIF) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			clientesParticulares.remove(NIF);			
			return "Cliente con NIF: "+NIF+" borrado.";
		}
		return clientesParticulares.get(NIF).getClienteNoExistente();
	}

	@Override
	public Cliente getDatosCliente(char NIF) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			return clientesParticulares.get(NIF);
		}
			
		return null; 
	}
	@Override
	public Collection<Cliente> getListadoClientes() {
		// TODO Auto-generated method stub
		return clientesParticulares.values();
		
	}
	@Override
	public String cambiarTarifa(char NIF, float precioTarifa) {
		// TODO Auto-generated method stub
		if (clientesParticulares.containsKey(NIF)) {
			clientesParticulares.get(NIF).getTarifa().setPrecioTarifa(precioTarifa);;
		}
		return null;
	}

	 

}
