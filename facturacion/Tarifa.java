package facturacion;

public class Tarifa {
	private float precioTarifa;
	
	public Tarifa(float tarifa){
		this.precioTarifa = tarifa;
	}
	
	float getTarifa(){
		return precioTarifa;
	}

	public void setPrecioTarifa(float precioTarifa) {
		this.precioTarifa = precioTarifa;
	}
	
}
