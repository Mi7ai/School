package tipoClientes;

import java.time.LocalDateTime;

import facturacion.Tarifa;

public class Particular extends Cliente{
	private String apellido;
	
	public Particular() {
		super();
	}

	public Particular(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion,String apellido){
		super(nombre, NIF, correo, fechaAlta, tarifa, direccion);
 		this.apellido = apellido;
	}
	
	 
	
	 
 
}
