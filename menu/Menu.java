package menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import facturacion.Factura;
import facturacion.Llamada;
import facturacion.PeriodoFacturacion;
import facturacion.Tarifa;
import operacionesApp.OperacionesClienteEmpresa;
import operacionesApp.OperacionesClienteParticular;
import operacionesApp.OperacionesFacturas;
import operacionesApp.OperacionesLlamadas;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Empresa;
import tipoClientes.Particular;

public class Menu  {

	 
	public static Scanner scanGeneral() {
		 Scanner sc = new Scanner(System.in);
		 return sc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option1, option2, option3;
		OperacionesClienteEmpresa clienteEmpresa = new OperacionesClienteEmpresa();
		OperacionesClienteParticular clienteParticular = new OperacionesClienteParticular();
		OperacionesLlamadas clienteLlamadas = new OperacionesLlamadas();
		OperacionesFacturas clienteFacturas = new OperacionesFacturas();
		EnumMenuIntro menuIntro;
		EnumMenuCliente menuCliente = null;
		EnumMenuFacturas menuFactura = null;
		
		do {				
		System.out.println("Elige una opcion: ");
		

 //		System.out.println("1 --> Operacion Clientes");
//		System.out.println("2 --> Operacion Facturas");
//		System.out.println("3 --> Operacion Llamada");
//		System.out.println("0 --> Salir");
		System.out.println(EnumMenuIntro.getMenu());
		menuIntro = EnumMenuIntro.getOpcion(scanGeneral().nextByte());
		 
		
			
				
			switch (menuIntro) {
			
			case Operacion_Clientes:
				//clientes
				System.out.println("----- MENU OPERACION CLIENTES -----: ");
//				System.out.println("1 -->: Alta Cliente");
//				System.out.println("2 -->: Baja Cliente");
//				System.out.println("3 -->: Cambiar Tarifa Cliente");
//				System.out.println("4 -->: Ver Datos Cliente");
//				System.out.println("5 -->: Listado Clientes");
//				System.out.println("0 -->: Salir");
				
				System.out.println(menuCliente.getMenuCliente());
				menuCliente = menuCliente.getOpcion(scanGeneral().nextByte());
				 
				 
				switch (menuCliente) {
					case Alta_Cliente:
						System.out.println("--- Alta Cliente ---");
						System.out.println("---------------------------------------");
						System.out.println("1 ---> Alta Cliente: - Cliente Particular - ");
						System.out.println("2 ---> Alta Cliente: - Cliente Empresa - ");
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
					case Baja_Cliente:
						System.out.println("--- Baja Cliente ---");
						System.out.println("---------------------------------------");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = sc.nextInt();
							switch (option3) {
							case 1:
								clienteParticular.bajaCliente(crearNIFCliente());
								break;
							case 2:
								clienteEmpresa.bajaCliente(crearNIFCliente());
								break;
							default:
								break;
							}
						break;
					case Cambiar_Tarifa_Cliente:
						System.out.println("--- Cambio Tarifa ---");
						System.out.println("---------------------------------------");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = sc.nextInt();
							switch (option3) {
							case 1:
								clienteParticular.cambiarTarifa(crearNIFCliente(),crearTarifa());
								break;
							case 2:
								clienteEmpresa.cambiarTarifa(crearNIFCliente(),crearTarifa());
								break;
							default:
								break;
							}
						break;
					case Ver_Datos_Cliente:
						System.out.println(" --- Datos Cliente ---");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = sc.nextInt();
							switch (option3) {
							case 1:
								clienteParticular.getDatosCliente((crearNIFCliente()));
								break;
							case 2:
								clienteEmpresa.getDatosCliente((crearNIFCliente()));
								break;
							default:
								break;
							}
						break;
					case Listado_Clientes:
						System.out.println("--- Listado Clientes ---");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = sc.nextInt();
							switch (option3) {
							case 1:
								for (Cliente particular : clienteParticular.getListadoClientes()) {
									System.out.println(particular+"\n");
								}
								
								break;
							case 2:
								for (Cliente empresa : clienteEmpresa.getListadoClientes()) {
									System.out.println(empresa+"\n");
								}
								
								break;
							default:
								break;
							}
						break;
					 
					default:
						
						break;
					}
				 if (menuCliente != menuCliente.Salir) {
					break;
				}
			case Operacion_Facturas:
					//facturas
					System.out.println("----- MENU OPERACION FACTURAS -----: ");
//					System.out.println("1 -->: Emitir Factura");
//					System.out.println("2 -->: Recuperar Datos Factura");
//					System.out.println("3 -->: Recuperar Facturas Cliente");
//					System.out.println("0 -->: Salir");
					System.out.println(menuFactura.getMenuFactura());
					menuFactura = menuFactura.getOpcion(scanGeneral().nextByte());
					switch (menuFactura) {
						case Emitir_Factura:
							System.out.println("--- Emision Factura ---");
							if (detectarTipoCliente(clienteParticular, clienteEmpresa) == 1) {//particular
								Cliente c = crearCliente(1);
								Collection<Llamada> llamadas = clienteLlamadas.listarLlamada(c.getNIF());
								clienteFacturas.getDatosFacturas();
								//clienteFacturas.emitirFactura(c, llamadas, new PeriodoFacturacion(clienteLlamadas.);
							}else if (detectarTipoCliente(clienteParticular, clienteEmpresa) == 2) {//empresa
								
							}else{
								System.out.println("Cliente inexistente!");
							}
							break;
						case Cambiar_Tarifa_Cliente:
							
							break;
						case Recuperar_Datos_Factura:
							System.out.println("--- Recuperando Datos Factura a partir de su Codigo ---");
							clienteFacturas.getDatosFactura(crearCodigoFactura());
							break;
						case Recuperar_Facturas_Cliente:
							System.out.println("--- Recuperando Facturas Cliente ---");							 
							for ( Factura factura : clienteFacturas.getFacturasCliente(crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa)))) {
								 System.out.println(factura+"\n");
							}
							 
							break;
						default:
							  	
							break;
					}
					if (menuFactura != menuFactura.Salir) {
						break;
					}
			case Operacion_Llamada:
				//llamadas
				System.out.println("----- MENU OPERACION FACTURAS -----: ");
				System.out.println("1 -->: Alta Llamada");
				System.out.println("2 -->: Lista Llamada");
				System.out.println("0 -->: Salir");
				option2 = sc.nextInt();
				switch (option2) {
					case 1:
						System.out.println("--- Alta Llamada ---");
						clienteLlamadas.altaLlamada(crearNIFCliente(), crearLlamada());
						break;
					case 2:
						System.out.println("--- Lista Llamada ---");//devuelve linkedlist
						LinkedList<Llamada> l =  (LinkedList<Llamada>) clienteLlamadas.listarLlamada(crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa)).getNIF());
						System.out.println(l.size());
						for (Llamada llamada : l) {
							System.out.println(llamada.toString());
						}
						System.out.println(clienteLlamadas.listarLlamada(crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa)).getNIF()));
						System.out.println(crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa)).getNIF());
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
		} while (menuIntro != menuIntro.Salir);
		
		 
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
	
	private static  int detectarTipoCliente(OperacionesClienteParticular clienteParticular, OperacionesClienteEmpresa clienteEmpresa){
		int tipo = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce NIF cliente: ");		
		String dniCliente = sc.nextLine();
		if (clienteParticular.existeCliente(dniCliente)) {//significa que el dni del cliente es particular
			tipo = 1;
		}
		if (clienteEmpresa.existeCliente(dniCliente)) {
			tipo = 2;
		}
		return tipo;
		
	}
	
	private static String crearNIFCliente(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce NIF cliente: ");		
		return  sc.nextLine();
	}

	private static float crearTarifa(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tarifa: ");		
		return  sc.nextFloat();
	}
	
	private static int crearCodigoFactura(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce Codigo Factura: ");		
		return  sc.nextInt();
	}
	
	private static Llamada crearLlamada(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero telefono: ");
		int telefono = sc.nextInt();
		
        System.out.println("Introduce la duración: ");
        int duracion = sc.nextInt();
        
        LocalDateTime fecha = LocalDateTime.now();
        return new Llamada(telefono, fecha, duracion);		 
	}
	private static LocalDateTime formatoFecha(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		return null;
	}
}
