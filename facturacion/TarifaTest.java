package facturacion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TarifaTest {

	@Test
	public void testTarifas() {
		Tarifa tarifa = new TarifaBasica(2f);
		tarifa = new TarifaTardes(tarifa, 2);
		assertEquals(tarifa.getPrecioMinuto(), 4f, 0.000f);
 		tarifa = new TarifaDomingo(tarifa, 0.00f);
		assertEquals(tarifa.getPrecioMinuto(), 4f, 0.000f);
}

}
