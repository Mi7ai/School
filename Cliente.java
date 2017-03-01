package tipoClientes;
import java.time.LocalDateTime;

public abstract class Cliente {
	private String nombre;	
	private char NIF;	
	private String correo;
	private LocalDateTime fechaAlta;
	private float tarifa;
	Direccion direccion ;
	
	//constructor
	public Cliente(){
		
	}	

	public Cliente(String nombre,char NIF, String correo, LocalDateTime fechaAlta,float tarifa, Direccion direccion){
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
	
	public char getNIF() {
		return NIF;
	}

	public String getCorreo() {
		return correo;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public float getTarifa() {
		return tarifa;
	}
}
