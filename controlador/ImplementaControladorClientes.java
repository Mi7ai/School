package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;

import factoria.FactoriaCliente;
import factoria.FactoriaClientes;
import factoria.FactoriaTarifa;
import facturacion.Llamada;
import facturacion.Tarifa;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import vista.VistaCliente;

public class ImplementaControladorClientes implements controlador.MetodosVista, controlador.MetodosModelo{
	vista.MetodosControlador vista;//tiene que tener los metodos de esta clase en en la interfaz vista joder
	modelo.MetodosControlador modelo;//tiene que tener los metodos de esta clase en en la interfaz modelo joder
	private String nombre,apellido,dni,email,provincia,poblacion;
	Integer cp;
	private Tarifa tarifa;
	private Direccion  direccion;
	LocalDateTime fechaAlta;
	FactoriaCliente factoriaCliente;
	FactoriaTarifa factoriaTarifa;
	public void setVista(vista.MetodosControlador vista) {
		this.vista = vista;
	}
	public void setModelo(modelo.MetodosControlador modelo) {
		this.modelo = modelo;
	}
	
	private void  recogerDatos(){
		nombre = vista.getNombre();
		 apellido = vista.getApellido();
		 dni = vista.getDni();
		 email = vista.getEmail();
		 tarifa = factoriaTarifa.getTarifaBasica();
		 cp =  Integer.parseInt(vista.getCp());
		 provincia = (String) vista.getProvincia();
		 poblacion = (String) vista.getPoblacion();

		 direccion = new Direccion(cp, provincia, poblacion);
		 
	}
	@Override
	public void anadirCliente() {
	
		recogerDatos();
		System.out.println(nombre);
		if (vista.jbParticular()) {// si esta activado el radiobutton particular
			Cliente particular = factoriaCliente.crearClienteParticular(nombre, dni, email, fechaAlta, tarifa,direccion, apellido);
			modelo.anadirClienteParticular(particular);
		}
		Cliente empresa = factoriaCliente.crearClienteEmpresa(nombre, dni, email, fechaAlta, tarifa, direccion);
		modelo.anadirClienteEmpresa(empresa);
		

	}

	@Override
	public void borrarCliente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarTarifaCliente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void datosCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listadoCliente() {
		// TODO Auto-generated method stub

	}
}
	
	 