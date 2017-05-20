package menu;

import controlador.*;
import modelo.*;
import vista.*;

public class MenuSwing {

	public static void main(String args[]) {
		ImplementaControlador controlador = new ImplementaControlador();
		
		VistaCliente vistaClientes = new VistaCliente();
		//crear para facturas 
		//crear para llamadas
		
		ImplementaModelo modelo = new ImplementaModelo();
		
		
		
		modelo.setVista(vistaClientes);
		
		controlador.setVista(vistaClientes);
		controlador.setModelo(modelo);
		
		vistaClientes.setModelo(modelo);
		vistaClientes.setControlador(controlador);
		 

		ImplementaVista v = new ImplementaVista();

		v.creaGUI();

	}

}
