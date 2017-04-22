package facturacion;

public abstract class TarifaExtra extends Tarifa{
	private Tarifa tarifa;
	
	public TarifaExtra(Tarifa tarifa,float precioTarifa) {
		super(precioTarifa);
		this.tarifa = tarifa;
	}

	@Override
	public float getPrecioMinuto() {//improve
		return 0;
		// TODO Auto-generated method stub
		//mirar si tienen complemento y sacar el minimo de la llamada dependiendo del complemente.
		 
	}

	@Override
	public void setPrecioTarifa(float precioTarifa) {
		// TODO Auto-generated method stub
		super.setPrecioTarifa(precioTarifa);
	}

}
