package facturacion;

public abstract class DecoradorTarifa extends Tarifa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5015178259618112537L;
	private Tarifa tarifa;
	
	public DecoradorTarifa(Tarifa tarifa,float precioTarifa) {
		super(precioTarifa);
		this.tarifa = tarifa;
	}

	@Override
	public float getPrecioMinuto() {
		return tarifa.getPrecioMinuto() + super.getPrecioMinuto(); 
	}
	 
	public String descripcion() {
		// TODO Auto-generated method stub
		return tarifa.descripcion();
	}
 
}
