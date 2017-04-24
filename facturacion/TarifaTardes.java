package facturacion;

public class TarifaTardes extends DecoradorTarifa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6472161976428935811L;
	private Tarifa tarifa;

	public TarifaTardes(Tarifa tarifa, float precioTarifa) {
 		super(tarifa, precioTarifa); 
 		this.tarifa = tarifa;
 	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Tarifa tardes.";
	}

	@Override
	public float precioLlamada(Llamada llamada) {
		if (llamada.getFecha().getHour() >= 16 && llamada.getFecha().getHour() <= 20) {
			return llamada.getDuracion() * super.getPrecioMinuto();
		}
		return tarifa.precioLlamada(llamada);
	}
	 

	 
	
}
