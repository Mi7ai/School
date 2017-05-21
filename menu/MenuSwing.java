package menu;

import controlador.*;
import modelo.*;
import operacionesApp.OperacionesClienteEmpresa;
import operacionesApp.OperacionesClienteParticular;
import operacionesApp.OperacionesFacturas;
import operacionesApp.OperacionesLlamadas;
import vista.*;

public class MenuSwing {

	public static void main(String args[]) {
 		//---Vistas
		VistaCliente vistaClientes = new VistaCliente(); 
		//crear para facturas 
		//crear para llamadas
		//---Vistas
		
		//---Modelos
 		OperacionesClienteParticular particular = new OperacionesClienteParticular();
		OperacionesClienteEmpresa empresa = new OperacionesClienteEmpresa();
		OperacionesFacturas facturas = new OperacionesFacturas();
		OperacionesLlamadas llamadas = new OperacionesLlamadas();
		//---Modelos
		
		//---Controladores

		ImplementaControladorClientes controladorClientes = new ImplementaControladorClientes();
		//crear para facturas
		//crear para llamadas
		//---Controladores		
		
		// a lo modelos su vista 
		particular.setVista(vistaClientes);
		empresa.setVista(vistaClientes);

		//a cada controlador su vista y modelo
		controladorClientes.setVista(vistaClientes);
		controladorClientes.setModelo(particular);
		controladorClientes.setModelo(empresa);
		
		//a cada vista ponemos controlador y modelo
		vistaClientes.setModelo(particular);
		vistaClientes.setModelo(empresa);
		vistaClientes.setControlador(controladorClientes);
		vistaClientes.setControlador(controladorClientes);
		 

		ImplementaVistaClientes v = new ImplementaVistaClientes();

		v.creaGUI();

	}

}
