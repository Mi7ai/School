package factoria;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import facturacion.Llamada;
import facturacion.Tarifa;

public class FactoriaTarifaTest {
	private static FactoriaTarifas fac;
	private static Llamada basica;
	private static Llamada tarde;
	private static Llamada domingo; 
	private static Tarifa tarifa;
	
	@BeforeClass
	public static void init() throws Exception {
		fac = new FactoriaTarifa();
		basica = new Llamada(646569666, LocalDateTime.of(2017,1,1,10,00),3); //y-mounth-dayMonth-hour-min
		tarde = new Llamada(646569666, LocalDateTime.of(2017,1,1,18,10),4);
		domingo = new Llamada(646569666, LocalDateTime.of(2017,1,7,15,00),3);
	}

	@Before
    public void basicaTest(){
        tarifa= fac.getTarifaBasica();
         
    }

	@Test
    public void TarifaBasicaTest(){		 
        assertThat(tarifa.precioLlamada(basica), is(45.0f));
        assertThat(tarifa.precioLlamada(tarde), is(60.0f));
        assertThat(tarifa.precioLlamada(domingo), is(45.0f));
    }
	
	@Test
    public void TarifaTardesTest(){		
		tarifa = fac.getTarifaExtra(tarifa, EnumFactoriaTarifa.Tardes);
 
		System.out.println(tarifa.getPrecioMinuto());
        assertThat(tarifa.precioLlamada(basica), is(45.0f));
        assertThat(tarifa.precioLlamada(tarde), is(80.0f));//5*4
        assertThat(tarifa.precioLlamada(domingo), is(45.0f));
    }
	
	@Test
    public void TarifaDomingosTest(){		
		tarifa = fac.getTarifaExtra(tarifa, EnumFactoriaTarifa.Domingos);
		
		System.out.println(tarifa.getPrecioMinuto());
		
        assertThat(tarifa.precioLlamada(basica), is(0.0f));
        assertThat(tarifa.precioLlamada(tarde), is(0.0f));//5*4
        assertThat(tarifa.precioLlamada(domingo), is(45.0f));
    }
}
