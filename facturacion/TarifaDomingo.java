package facturacion;

public class TarifaDomingo extends DecoradorTarifa{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6348087253474925419L;
 	private Tarifa tarifa;
	
 	public TarifaDomingo(Tarifa tarifa, float precioTarifa) {
 		super(tarifa, precioTarifa); 
 		this.tarifa = tarifa;
 	}
 	
 
	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Tarifa domingos gratis.";
	}

	@Override
	public float precioLlamada(Llamada llamada) {
		if (llamada.getFecha().getDayOfWeek().getValue() == 7) {
			return 0.f;
		}
		return tarifa.precioLlamada(llamada);
	}
	 

}
