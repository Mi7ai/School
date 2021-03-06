package facturacion;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Llamada implements Fecha, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -268634845588826002L;
	private int nrTelefono;
	private LocalDateTime fecha;
	private int duracion;
	
	public Llamada(){
		
	}
	public Llamada(int nrTelefono, LocalDateTime fecha, int duracion){
		this.nrTelefono = nrTelefono;
		this.fecha = fecha;
		this.duracion = duracion;
	}

	public int getNrTelefono() {
		return nrTelefono;
	}

	@Override
	public LocalDateTime getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}

	public int getDuracion() {
		return duracion;
	}
	
	@Override
	public String toString() {
		return "Llamada [nrTelefono=" + nrTelefono + ", fecha=" + fecha + ", duracion=" + duracion + "]";
	}

	
}
