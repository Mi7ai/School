package modelo;

import java.util.Collection;

import excepciones.ExClienteNoExistente;
import tipoClientes.Cliente;

public interface MetodosVista {
	Cliente getDatosCliente(String NIF) throws ExClienteNoExistente;
    Collection<Cliente> getListadoClientes();
}
