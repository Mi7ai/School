package practica1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tipoClientes.Direccion;

public class DireccionTest {

	private static Direccion direccion;

    @BeforeClass
    public static void init(){
        direccion = new Direccion (12004,"Castellon", "Castellon");
    }

    @AfterClass
    public static void end(){
        direccion = null;
    }

    @Test
    public void getDireccionTest(){
        assertEquals(direccion.getCP(),12004);
        assertEquals(direccion.getPoblacion(),"Castellon");
        assertEquals(direccion.getProvincia(),"Castellon");
    }

    @Test
    public void toStringTest(){
        assertEquals(direccion.toString(),"Direccion [CP=12004, provincia=Castellon, poblacion=Castellon]");
    }
}
