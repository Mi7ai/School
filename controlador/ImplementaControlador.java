package controlador;

import vista.VistaCliente;

public class ImplementaControlador implements controlador.MetodosVista, controlador.MetodosModelo{
	vista.MetodosControlador vista;//tiene que tener los metodos de esta clase en en la interfaz vista joder
	modelo.MetodosControlador modelo;//tiene que tener los metodos de esta clase en en la interfaz modelo joder
	public void setVista(vista.MetodosControlador vista) {
		this.vista = vista;
	}
	public void setModelo(modelo.MetodosControlador modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void cambiarVistaClientes() {
 		//tengo que poner una vista del cliente, por lo tanto hay que crear una
		modelo.addVistaCliente();//tipo Jpane
	}
	
	 

}
