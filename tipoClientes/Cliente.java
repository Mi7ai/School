package tipoClientes;
import java.io.Serializable;
import java.time.LocalDateTime;

import facturacion.Fecha;
import facturacion.Tarifa;
import genericos.ListadoAPartirDeFecha;

public abstract class Cliente implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7183352456291061555L;
	private String nombre;	
	private String NIF;	
	private String correo;
	private LocalDateTime fechaAlta;
	private Tarifa tarifa;
	Direccion direccion ;
	
	//constructor
	public Cliente(){	
	}	

	public Cliente(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion){
		this.nombre = nombre;
		this.NIF = NIF;
		this.correo = correo;
		this.fechaAlta = fechaAlta;
		this.tarifa = tarifa;
		this.direccion = direccion;
	}
	

	public String getNombre() {
		return nombre;
	}	
	
	public String getNIF() {
		return NIF;
	}

	public String getCorreo() {
		return correo;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}
	
	public String getClienteNoExistente(){
		return "No hay ningun cliente con el NIF proporcionado.";
	}
	 
	@Override
	public String toString() {
		return "Cliente [getNombre()=" + getNombre() + ", getNIF()=" + getNIF() + ", getCorreo()=" + getCorreo()
				+ ", getFechaAlta()=" + getFechaAlta() + ", getTarifa()=" + getTarifa().getPrecioMinuto() + "]";
	}
}
