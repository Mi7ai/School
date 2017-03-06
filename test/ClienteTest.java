package practica1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import facturacion.Tarifa;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Particular;

public class ClienteTest {
	private static Cliente nuevoCliente;
	private static Tarifa nuevaTarifa;
	private static Direccion nuevaDireccion;

	@BeforeClass
	public static void init() {
		nuevaTarifa = new Tarifa(2.3f);
		nuevaDireccion = new Direccion(12004, "Castellon", "Castellon");
		nuevoCliente = new Particular("Mihai", "X9457019V", "email", LocalDateTime.now(), nuevaTarifa, nuevaDireccion,"Manea");
	}

	@AfterClass
	public static void end() {
		nuevoCliente = null;
	}

	@Test
    public void nifClienteTest(){
         assertEquals(nuevoCliente.getNIF(), "X9457019V");
    }
	
	@Test
    public void noExisteClienteTest(){
         assertEquals(nuevoCliente.getClienteNoExistente(), "No hay ningun cliente con el NIF proporcionado.");
    }
}
