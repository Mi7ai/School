package facturacion;

public class TarifaDiaSemana extends TarifaExtra{
	private Tarifa tarifa;

	public TarifaDiaSemana(Tarifa tarifa, float precioTarifa) {
		// TODO Auto-generated constructor stub
		super(tarifa, precioTarifa);//a la tarifa actual le añado el precio que sea
 	}
	@Override
	public float getPrecioMinuto() {
		// TODO Auto-generated method stub
		return super.getPrecioMinuto() + tarifa.getPrecioMinuto();
	}

	@Override
	public void setPrecioTarifa(float precioTarifa) {
		// TODO Auto-generated method stub
		super.setPrecioTarifa(precioTarifa);
	}
	
	
}
