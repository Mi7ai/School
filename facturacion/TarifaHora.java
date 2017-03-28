package facturacion;

public class TarifaHora extends TarifaExtra{
	private Tarifa tarifa;
	
	public TarifaHora(Tarifa tarifa, float precioTarifa) {
		// TODO Auto-generated constructor stub
		super(tarifa, precioTarifa);//a la tarifa actual le añado el precio que sea en el intervalo elegido
 	}
	 

}
