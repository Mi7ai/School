package menu;

import java.time.LocalDateTime;
import java.util.Scanner;

import facturacion.Tarifa;
import operacionesApp.OperacionesClienteEmpresa;
import operacionesApp.OperacionesClienteParticular;
import operacionesApp.OperacionesFacturas;
import operacionesApp.OperacionesLlamadas;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Empresa;
import tipoClientes.Particular;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option1, option2, option3;
		OperacionesClienteEmpresa clienteEmpresa = new OperacionesClienteEmpresa();
		OperacionesClienteParticular clienteParticular = new OperacionesClienteParticular();
		OperacionesLlamadas clienteLlamadas = new OperacionesLlamadas();
		
		
		do {				
		System.out.println("Elige una opcion: ");
		System.out.println("1 --> Operacion Clientes");
		System.out.println("2 --> Operacion Facturas");
		System.out.println("3 --> Operacion Llamada");
		System.out.println("0 --> Salir");
		option1 = sc.nextInt();
		
			
				
			switch (option1) {
			case 1:
				//clientes
				System.out.println("----- MENU OPERACION CLIENTES -----: ");
				System.out.println("1 -->: Alta Cliente");
				System.out.println("2 -->: Baja Cliente");
				System.out.println("3 -->: Cambiar Tarifa Cliente");
				System.out.println("4 -->: Ver Datos Cliente");
				System.out.println("5 -->: Listado Clientes");
				System.out.println("0 -->: Salir");
				option2 = sc.nextInt();
				 
				switch (option2) {
					case 1:
						System.out.println("Alta Cliente: --- Introduce Cliente ---");
						System.out.println("---------------------------------------");
						System.out.println("Alta Cliente: - Cliente Particular - ");
						System.out.println("Alta Cliente: - Cliente Empresa - ");
						option3 = sc.nextInt();
						switch (option3) {
							case 1:
								clienteParticular.altaCliente(crearCliente(1));
								break;
							case 2:
								clienteParticular.altaCliente(crearCliente(2));
								break;
							default:
								break;
							}
						break;
					case 2:
						System.out.println("Baja Cliente: --- Introduce NIF Cliente ---");
						break;
					case 3:
						System.out.println("Cambio Tarifa: --- Introduce NIF Cliente---");
						break;
					case 4:
						System.out.println("Datos Cliente: --- Introduce NIF Cliente---");
		
						break;
					case 5:
						System.out.println("--- Listado Clientes ---");
		
						break;
					
					default:
						
						break;
					}
				if (option2 == 0) {
					break;
				}
			case 2:
					//facturas
					System.out.println("----- MENU OPERACION FACTURAS -----: ");
					System.out.println("1 -->: Emitir Factura");
					System.out.println("2 -->: Recuperar Datos Factura");
					System.out.println("3 -->: Recuperar Facturas Cliente");
					System.out.println("0 -->: Salir");
					option2 = sc.nextInt();
					switch (option2) {
						case 1:
							System.out.println("Emision Factura: --- Cliente, llamada, Factura ---");
							
							break;
						case 2:
							System.out.println("Recuperando Datos: --- Introduce Codigo Factura ---");
							break;
						case 3:
							System.out.println("Recuperando Facturas: --- Introduce NIF Cliente---");
							break;
						default:
							  	
							break;
					}
					if (option2 == 0) {
						break;
					}
			case 3:
				//llamadas
				System.out.println("----- MENU OPERACION FACTURAS -----: ");
				System.out.println("1 -->: Alta Llamada");
				System.out.println("2 -->: Lista Llamada");
				System.out.println("0 -->: Salir");
				option2 = sc.nextInt();
				switch (option2) {
					case 1:
						System.out.println("Alta Llamada: --- Introduce NIF, llamada");
						break;
					case 2:
						System.out.println("Lista Llamada: --- Introduce NIF");
						break;
					default:
						break;
				}
				if (option2 == 0) {
					break;
				}
	 
			default:
				break;
			}//switch option1
		} while (option1 != 0);
		
		 
	}
	
	private static Cliente crearCliente(int tipo){
		Cliente nuevoCliente;
		if (tipo == 1) {
			Tarifa nuevaTarifa = new Tarifa(2.3f);
			Direccion nuevaDireccion = new Direccion(12004, "Castellon", "Castellon");			 
			 
		   nuevoCliente = new Particular("Mihai","X9457019V", "email", LocalDateTime.now(), nuevaTarifa, nuevaDireccion, "Manea");			  
		}else{
			Tarifa nuevaTarifa = new Tarifa(2.5f);
			Direccion nuevaDireccion = new Direccion(12004, "Valencia", "Valencia");	
			nuevoCliente = new Empresa("Mihai", "X9457019V", "email", LocalDateTime.now(), nuevaTarifa, nuevaDireccion);
		}
		
		return nuevoCliente;
		
	}

}
