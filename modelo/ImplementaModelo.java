package modelo;

import javax.swing.JPanel;

public class ImplementaModelo implements modelo.MetodosControlador, modelo.MetodosVista{
	vista.MetodosModelo vista;
	
	public void setVista(vista.MetodosModelo vista) {
		 this.vista = vista;		
	}
 
	@Override
	public void addVistaCliente() {
		vista.setVistaCliente();
	}
 
	 
	

}
