package facturacion;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6021356078025287717L;
	private float precioTarifa;

	public Tarifa(){
		this.precioTarifa = 15;
	}
	
	public Tarifa(float precioTarifa){
		this.precioTarifa = precioTarifa;
	}
	
	public float getPrecioMinuto(){
		return precioTarifa;
	}
	
	public void setPrecioTarifa(float precioTarifa) {
		this.precioTarifa = precioTarifa;
	}
	
	public abstract float precioLlamada(Llamada llamada);
	
	public String descripcion(){
		return "Tarifa base";
	}	 
	
}
