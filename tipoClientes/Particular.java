package tipoClientes;

import java.time.LocalDateTime;

public class Particular extends Cliente{
	private String apellido;
	
	public Particular() {
		super();
	}

	public Particular(String nombre,char NIF, String correo, LocalDateTime fechaAlta,float tarifa, Direccion direccion,String apellido){
		super(nombre, NIF, correo, fechaAlta, tarifa,direccion);
 		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getNombreApellido() {
		return super.getNombre()+" "+apellido;
	}
 
}
