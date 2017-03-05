package tipoClientes;

import java.time.LocalDateTime;

import facturacion.Tarifa;

public class Empresa extends Cliente{

	public Empresa(){
		super();
	}
	public Empresa(String nombre,String NIF, String correo, LocalDateTime fechaAlta,Tarifa tarifa, Direccion direccion) {
		super(nombre, NIF, correo, fechaAlta, tarifa, direccion);
	}
	
}
