package menu;

import java.util.Scanner;

public enum EnumMenuIntro {
	Salir("Salir"), //0
	Operacion_Clientes("Operacion Clientes."), //1
	Operacion_Facturas("Operacion Facturas."), //2
	Operacion_Llamada("Operacion Llamada"); //3
	 
	private String descripcion;

	private EnumMenuIntro(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static EnumMenuIntro getOpcion(int posicion) {
		return values()[posicion]; //devuelve la opcion en tipo EnumMenu
	}
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		
		for(EnumMenuIntro opcion: EnumMenuIntro.values()) {
			sb.append(opcion.ordinal());
			sb.append(" -->");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		EnumMenuIntro a;
		System.out.println(EnumMenuIntro.getOpcion(1));
		do {
			System.out.println(EnumMenuIntro.getMenu());
			Scanner scanner = new Scanner(System.in);
			System.out.print("Elije una opción:");
			a = EnumMenuIntro.getOpcion(scanner.nextByte());
			
			switch (a) {
			case Operacion_Clientes:
				consultaSaldo();
				break;
			case Operacion_Facturas:
				recargarTarjeta();
				 
				break;
			default:
				break;
			}
		} while (a != a.Salir);
		
 
		
		
		
		
		
		
		
	}

	private static void recargarTarjeta() {
		// TODO Auto-generated method stub
		
	}

	private static void consultaSaldo() {
		// TODO Auto-generated method stub
		 System.out.println("Hola");
		 System.out.println(EnumMenuIntro.getMenu());
		 Scanner scanner = new Scanner(System.in);
		System.out.print("Elije una opción:");
		EnumMenuIntro a = EnumMenuIntro.getOpcion(scanner.nextByte());
			
	}
}
 


	 

