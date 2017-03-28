package facturacion;

public abstract class TarifaExtra extends Tarifa{
	private Tarifa tarifa;
	
	public TarifaExtra(Tarifa tarifa,float precioTarifa) {
		super(precioTarifa);
		this.tarifa = tarifa;
	}

	@Override
	public float getPrecioMinuto(Llamada llamada) {
		// TODO Auto-generated method stub
		//mirar si tienen complemento y sacar el minimo de la llamada dependiendo del complemente.
		return super.getPrecioMinuto(llamada)  tarifa.getPrecioMinuto();
	}

	@Override
	public void setPrecioTarifa(float precioTarifa) {
		// TODO Auto-generated method stub
		super.setPrecioTarifa(precioTarifa);
	}

}
