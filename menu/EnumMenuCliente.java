package menu;

import java.time.LocalDateTime;

import facturacion.Tarifa;
import facturacion.TarifaBasica;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Empresa;
import tipoClientes.Particular;

public enum EnumMenuCliente {
	Salir("Salir"), //0
	Alta_Cliente("Alta Cliente."), //1
	Baja_Cliente("Baja Cliente."), //2
	Cambiar_Tarifa_Cliente("Cambiar Tarifa Cliente."), //3
	Ver_Datos_Cliente("Ver Datos Cliente."), //4
	Listado_Clientes("Listado Clientes."), //5
	Listado_Clientes_Entre_2_Fechas("Listado Clientes entre dos fechas.");
	
	private String descripcion;

	private EnumMenuCliente(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static EnumMenuCliente getOpcion(int posicion) {
		return values()[posicion]; //devuelve la opcion en tipo EnumMenuOperaciones
	}
	public static String getMenuCliente() {
		StringBuilder sb = new StringBuilder();
		
		for(EnumMenuCliente opcion: EnumMenuCliente.values()) {
			sb.append(opcion.ordinal());
			sb.append(" -->");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	public Cliente ejecutaCrearCliente(int tipo ){
		Cliente nuevoCliente;
		if (tipo == 1) {
			Tarifa nuevaTarifa = new TarifaBasica(2.3f);
			Direccion nuevaDireccion = new Direccion(12004, "Castellon", "Castellon");			 
			 
		   nuevoCliente = new Particular("Mihai","X9457019V", "email", LocalDateTime.now(), nuevaTarifa, nuevaDireccion, "Manea");			  
		}else{
			Tarifa nuevaTarifa = new TarifaBasica(2.5f);
			Direccion nuevaDireccion = new Direccion(12004, "Valencia", "Valencia");	
			nuevoCliente = new Empresa("Mihai", "X9457019V", "email", LocalDateTime.now(), nuevaTarifa, nuevaDireccion);
		}
		
		return nuevoCliente;
	}
}
