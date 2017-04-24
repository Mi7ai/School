package factoria;

import facturacion.Tarifa;
import facturacion.TarifaBasica;
import facturacion.TarifaDomingo;
import facturacion.TarifaTardes;

public class FactoriaTarifa implements FactoriaTarifas{

	@Override
	public Tarifa getTarifaBasica() {
 		return new TarifaBasica();
	}
 
	@Override
	public Tarifa getTarifaExtra(Tarifa tarifa, EnumFactoriaTarifa extra) {
		Tarifa tarifaExtra = new TarifaDomingo(tarifa, 0);
		
		switch (extra) {
		case Tardes:
			return new TarifaTardes(tarifa, 5);
			
		 
			 
 
		}

		return tarifaExtra;
	}

}
