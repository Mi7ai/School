package factoria;

import facturacion.Tarifa;

public interface FactoriaTarifas {
	public Tarifa getTarifaBasica();
	public Tarifa getTarifaExtra(Tarifa tarifa, EnumFactoriaTarifa extra);
}
