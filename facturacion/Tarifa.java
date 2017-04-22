package facturacion;

import java.io.Serializable;

public class Tarifa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6021356078025287717L;
	private float precioTarifa;
	
	public Tarifa(){
		
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
	
}
