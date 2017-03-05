package operacionesApp;

import java.util.Collection;
import java.util.HashMap;

import tipoClientes.Cliente;

public class OperacionesClienteEmpresa implements InterfaceClientes{
	private HashMap<Character, Cliente> clientesEmpresas;
	
	public OperacionesClienteEmpresa() {
		 clientesEmpresas = new HashMap<>();
	}

	@Override
	public boolean existeCliente(char NIF) {
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
	public String bajaCliente(char NIF) {
		// TODO Auto-generated method stub
		if (clientesEmpresas.containsKey(NIF)) {
			clientesEmpresas.remove(NIF);			
			return "Cliente(Empresa) con NIF: "+NIF+" borrado.";
		}
		return clientesEmpresas.get(NIF).getClienteNoExistente();
		 
	}

	@Override
	public Cliente getDatosCliente(char NIF) {
		// TODO Auto-generated method stub
		if (clientesEmpresas.containsKey(NIF)) {
			return clientesEmpresas.get(NIF);
		}
		return null;
	}

	@Override
	public String cambiarTarifa(char NIF, float precioTarifa) {
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

}
