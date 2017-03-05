package facturacion;

public class Tarifa {
	private float precioTarifa;
	
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
