package facturacion;

public class TarifaBasica extends Tarifa{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4745230981367570667L;
	
	public TarifaBasica() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public TarifaBasica(float precioTarifa) {
		super(precioTarifa);
		// TODO Auto-generated constructor stub
	}
	 
	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Tarifa basica";
	}

	@Override
	public float precioLlamada(Llamada llamada) {
 		return super.getPrecioMinuto()*llamada.getDuracion();
	}

 

}
