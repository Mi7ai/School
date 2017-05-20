package menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import excepciones.ExClienteNoExistente;
import excepciones.ExClienteSinLlamadas;
import facturacion.Factura;
import facturacion.Fecha;
import facturacion.Llamada;
import facturacion.PeriodoFacturacion;
import facturacion.Tarifa;
import facturacion.TarifaBasica;
import operacionesApp.OperacionesClienteEmpresa;
import operacionesApp.OperacionesClienteParticular;
import operacionesApp.OperacionesFacturas;
import operacionesApp.OperacionesLlamadas;
import tipoClientes.Cliente;
import tipoClientes.Direccion;
import tipoClientes.Empresa;
import tipoClientes.Particular;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7106489827502798379L;
	public static Scanner scanGeneral() {
		 Scanner sc = new Scanner(System.in);
		 return sc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		OperacionesClienteEmpresa clienteEmpresa = new OperacionesClienteEmpresa();
		OperacionesClienteParticular clienteParticular = new OperacionesClienteParticular();
		OperacionesLlamadas clienteLlamadas = new OperacionesLlamadas();
		OperacionesFacturas clienteFacturas = new OperacionesFacturas();
		EnumMenuIntro menuIntro;
		EnumMenuCliente menuCliente;
		EnumMenuFacturas menuFactura;
		EnumMenuLlamadas menuLlamada;
		 
		do {				
		System.out.println("Elige una opcion: ");		
//		System.out.println("1 --> Operacion Clientes");
//		System.out.println("2 --> Operacion Facturas");
//		System.out.println("3 --> Operacion Llamada");
//		System.out.println("0 --> Salir");
		System.out.println(EnumMenuIntro.getMenu());
		menuIntro = EnumMenuIntro.getOpcion(scanGeneral().nextByte());
		 
		try {
			FileInputStream fiParticulares = new FileInputStream("particulares.bin");
			FileInputStream fiEmpresas = new FileInputStream("empresas.bin");
			FileInputStream fiFacturas = new FileInputStream("facturas.bin");
			FileInputStream fiLlamadas = new FileInputStream("llamadas.bin");
			
			ObjectInputStream oiParticulares  = new ObjectInputStream(fiParticulares);
			ObjectInputStream oiEmpresas  = new ObjectInputStream(fiEmpresas);
			ObjectInputStream oiFacturas= new ObjectInputStream(fiFacturas);
			ObjectInputStream oiLlamadas  = new ObjectInputStream(fiLlamadas);
			
			clienteParticular = (OperacionesClienteParticular) oiParticulares.readObject();
			clienteEmpresa = (OperacionesClienteEmpresa) oiEmpresas.readObject();
			clienteFacturas = (OperacionesFacturas) oiFacturas.readObject();
			clienteLlamadas = (OperacionesLlamadas) oiLlamadas.readObject();
			
			oiParticulares.close();
			oiEmpresas.close();
			oiFacturas.close();
			oiLlamadas.close();
			
			System.out.println("Datos cargados correctamente...");
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
			switch (menuIntro) {
//			case Cargar_Datos:
//				
//				break;
			case Operacion_Clientes:
				//clientes
				System.out.println("----- MENU OPERACION CLIENTES -----: ");
//				System.out.println("1 -->: Alta Cliente");
//				System.out.println("2 -->: Baja Cliente");
//				System.out.println("3 -->: Cambiar Tarifa Cliente");
//				System.out.println("4 -->: Ver Datos Cliente");
//				System.out.println("5 -->: Listado Clientes");
//				System.out.println("0 -->: Salir");
				
				System.out.println(EnumMenuCliente.getMenuCliente());
				menuCliente = EnumMenuCliente.getOpcion(scanGeneral().nextByte());
				 
				 
				int option3;
				switch (menuCliente) {
					case Alta_Cliente:
						System.out.println("--- Alta Cliente ---");
						System.out.println("---------------------------------------");
						System.out.println("1 ---> Alta Cliente: - Cliente Particular - ");
						System.out.println("2 ---> Alta Cliente: - Cliente Empresa - ");
						option3 = scanGeneral().nextInt();
							switch (option3) {
							case 1:
								System.out.println(clienteParticular.altaCliente(crearCliente(1)));
								break;
							case 2:
								System.out.println(clienteEmpresa.altaCliente(crearCliente(2)));
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
						option3 = scanGeneral().nextInt();
							switch (option3) {
							case 1:
								System.out.println(clienteParticular.bajaCliente(crearNIFCliente()));
								break;
							case 2:
								System.out.println(clienteEmpresa.bajaCliente(crearNIFCliente()));
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
						option3 = scanGeneral().nextInt();
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
						option3 = scanGeneral().nextInt();
							switch (option3) {
							case 1:
								try {
									System.out.println(clienteParticular.getDatosCliente((crearNIFCliente())));

								} catch (ExClienteNoExistente e) {
									e.printStackTrace();
								} 
								 
								break;
							case 2:
								try {
									System.out.println(clienteEmpresa.getDatosCliente((crearNIFCliente())));

								} catch (ExClienteNoExistente e) {
									e.printStackTrace();
								}
								break;
							default:
								break;
							}
						break;
					case Listado_Clientes:
						System.out.println("--- Listado Clientes ---");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = scanGeneral().nextInt();
							switch (option3) {
							case 1:
								for (Cliente particular : clienteParticular.getListadoClientes()) {
									 
										System.out.println(particular);

								}
								
								break;
							case 2:
 								for (Cliente empresa : clienteEmpresa.getListadoClientes()) {									 
									System.out.println(empresa);
								}
								
								break;
							default:
								break;
							}
						break;
					case Listado_Clientes_Entre_2_Fechas:
						System.out.println("--- Listado Clientes Entre dos Fechas ---");
						System.out.println("1 --> Cliente Particular ");
						System.out.println("2 --> Cliente Empresa ");
						option3 = scanGeneral().nextInt();
							switch (option3) {
							case 1:
								imprimirLista(clienteParticular.listado(clienteParticular.getListadoClientes(), formatoFecha(), formatoFecha()));							
								break;
							case 2:
								imprimirLista(clienteEmpresa.listado(clienteEmpresa.getListadoClientes(), formatoFecha(), formatoFecha()));						
								break;
							default:
								break;
							}
						break;
					default:
						
						break;
					}
				 if (menuCliente != EnumMenuCliente.Salir) {
					break;
				}
			case Operacion_Facturas: //revisar para mejorar
					//facturas
					System.out.println("----- MENU OPERACION FACTURAS -----: ");
//					System.out.println("1 -->: Emitir Factura");
//					System.out.println("2 -->: Recuperar Datos Factura");
//					System.out.println("3 -->: Recuperar Facturas Cliente");
//					System.out.println("0 -->: Salir");
					
					System.out.println(EnumMenuFacturas.getMenuFactura());
					menuFactura = EnumMenuFacturas.getOpcion(scanGeneral().nextByte());
					 
					switch (menuFactura) {
						
						case Emitir_Factura:
							System.out.println("--- Emision Factura ---");
							 try {
								 Cliente c = crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa));
									Collection<Llamada> llamadas = clienteLlamadas.listarLlamada(c.getNIF());
									//System.out.println(clienteFacturas.getDatosFacturas());
									
									System.out.println("Factura:" +clienteFacturas.emitirFactura(c, llamadas, new PeriodoFacturacion(formatoFecha(),formatoFecha())).getCodigoFactura()+" creada");
								 
									
							} catch (ExClienteSinLlamadas e) {
								// TODO: handle exception
								e.getMessage();
							}
								
							 
							break;
						case Cambiar_Tarifa_Cliente:
							//completar 
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
						case Listado_Facturas_Entre_2_Fechas:
 							imprimirLista(clienteFacturas.listado(clienteFacturas.getDatosFacturas(), formatoFecha(),formatoFecha()));
							 
							break;
						default:
							  	
							break;
					}
					if (menuFactura != EnumMenuFacturas.Salir) {
						break;
					}
			case Operacion_Llamada:
				//llamadas
				System.out.println("----- MENU OPERACION LLAMADAS -----: ");
//				System.out.println("1 -->: Alta Llamada");
//				System.out.println("2 -->: Lista Llamada");
//				System.out.println("0 -->: Salir");
				System.out.println(EnumMenuLlamadas.getMenuLlamada());
				menuLlamada = EnumMenuLlamadas.getOpcion(scanGeneral().nextByte());
				switch (menuLlamada) {
					case Alta_Llamada:
						System.out.println("--- Alta Llamada ---");
						clienteLlamadas.altaLlamada(crearNIFCliente(), crearLlamada());
						break;
					case Lista_Llamada:
							System.out.println("--- Lista Llamada ---");//devuelve linkedlist
							LinkedList<Llamada> l;
							try {
								l = (LinkedList<Llamada>) clienteLlamadas.listarLlamada(crearCliente(detectarTipoCliente(clienteParticular, clienteEmpresa)).getNIF());
								imprimirLista(l);				 
							} catch (ExClienteSinLlamadas e) {
								// TODO Auto-generated catch block
									e.printStackTrace();
							}
						break;
					case Listado_Llamadas_Entre_2_Fechas:
							
					try {
						imprimirLista(clienteLlamadas.listado(clienteLlamadas.listarLlamada(preguntarDNI()), formatoFecha(),formatoFecha()));
					} catch (ExClienteSinLlamadas e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

						break;
					default:
						break;
				}
				if (menuLlamada == EnumMenuLlamadas.Salir) {
					break;
				}
			case Guardar_Datos:
				try {
					FileOutputStream foParticulares = new FileOutputStream("particulares.bin");
					FileOutputStream foEmpresas = new FileOutputStream("empresas.bin");
					FileOutputStream foFacturas = new FileOutputStream("facturas.bin");
					FileOutputStream foLlamadas = new FileOutputStream("llamadas.bin");
					
					ObjectOutputStream ooParticulares  = new ObjectOutputStream(foParticulares);
					ObjectOutputStream ooEmpresas  = new ObjectOutputStream(foEmpresas);
					ObjectOutputStream ooFacturas= new ObjectOutputStream(foFacturas);
					ObjectOutputStream ooLlamadas  = new ObjectOutputStream(foLlamadas);
					
					
					ooParticulares.writeObject(clienteParticular);
					ooEmpresas.writeObject(clienteEmpresa);
					ooFacturas.writeObject(clienteFacturas);
					ooLlamadas.writeObject(clienteLlamadas);
//					ooParticulares.flush();
//					ooEmpresas.flush();
//					ooFacturas.flush();
//					ooLlamadas.flush();
					 
					ooParticulares.close();
					ooEmpresas.close();
					ooFacturas.close();
					ooLlamadas.close();
					
					System.out.println("Escritura completada...!");
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}catch (IOException e) {
					System.out.println(e);
				}
				
				break;
			default:
				break;
				
			}//switch option1
		} while (menuIntro != EnumMenuIntro.Salir);
		
		 
	}
	
	private static Cliente crearCliente(int tipo){
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
	
	private static  int detectarTipoCliente(OperacionesClienteParticular clienteParticular, OperacionesClienteEmpresa clienteEmpresa){
		int tipo = 0;
 		System.out.println("Introduce NIF cliente: ");		
		String dniCliente = scanGeneral().nextLine();
		if (clienteParticular.existeCliente(dniCliente)) {//significa que el dni del cliente es particular
			tipo = 1;
		}
		if (clienteEmpresa.existeCliente(dniCliente)) {
			tipo = 2;
		}
		return tipo;
		
	}
	
	private static String crearNIFCliente(){		 
		System.out.println("Introduce NIF cliente: ");		
		return  scanGeneral().nextLine();
	}

	private static float crearTarifa(){		
		System.out.println("Introduce tarifa: ");		
		return  scanGeneral().nextFloat();
	}
	
	private static int crearCodigoFactura(){
 		System.out.println("Introduce Codigo Factura: ");		
		return  scanGeneral().nextInt();
	}
	
	private static Llamada crearLlamada(){
 		System.out.println("Introduce numero telefono: ");
		int telefono = scanGeneral().nextInt();
		
        System.out.println("Introduce la duración: ");
        int duracion = scanGeneral().nextInt();
        
        LocalDateTime fecha = LocalDateTime.now();
        return new Llamada(telefono, fecha, duracion);		 
	}
	
	private static String preguntarDNI(){
		System.out.println("Introduce DNI: ");
		String dni = scanGeneral().next();
		return dni;
	}
	private static LocalDateTime formatoFecha(){
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		String str = "02-04-2017 12:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		return dateTime;
	}
	private static void imprimirLista( Collection<?> col){
        Iterator<?> lista = col.iterator();
        StringBuilder sb = new StringBuilder();
        while(lista.hasNext()){
            sb.append(lista.next());
            sb.append("\n");
        }
        sb.toString();
    }
	
}
