package tipoClientes;

import java.io.Serializable;
import java.time.LocalDateTime;

import facturacion.Tarifa;

public class Particular extends Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1413410210868514123L;
	private String apellido;
	
	public Particular() {
		super();
	}

	public Particular(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion,String apellido){
		super(nombre, NIF, correo, fechaAlta, tarifa, direccion);
 		this.apellido = apellido;
	}
	
	 
	
	 
 
}
