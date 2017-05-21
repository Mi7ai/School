package modelo;

import java.util.Collection;

import javax.swing.JPanel;

import excepciones.ExClienteNoExistente;
import operacionesApp.OperacionesClienteEmpresa;
import operacionesApp.OperacionesClienteParticular;
import tipoClientes.Cliente;

public class ImplementaModeloClientes implements modelo.MetodosControlador, modelo.MetodosVista{
	vista.MetodosModelo vista;
	OperacionesClienteParticular clienteParticular;
	OperacionesClienteEmpresa  clienteEmpresa;
	public void setVista(vista.MetodosModelo vista) {
		 this.vista = vista;		
	}

	@Override
	public Cliente getDatosCliente(String NIF) throws ExClienteNoExistente {
		if (clienteParticular.existeCliente(NIF)) {
			return clienteParticular.getDatosCliente(NIF);

		}else if (clienteEmpresa.existeCliente(NIF)) {
			return clienteEmpresa.getDatosCliente(NIF);

		}
 		return null;
	 
	}

	@Override
	public Collection<Cliente> getListadoClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void anadirClienteParticular(Cliente particular) {
		// TODO Auto-generated method stub
		clienteParticular.altaCliente(particular);
	}

	@Override
	public void anadirClienteEmpresa(Cliente empresa) {
		// TODO Auto-generated method stub
		clienteEmpresa.altaCliente(empresa);
	}

	 
 

	 
	 
 
	 
	

}
