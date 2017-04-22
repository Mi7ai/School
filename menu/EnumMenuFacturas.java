package menu;

public enum EnumMenuFacturas {
	Salir("Salir"), //0
	Emitir_Factura("Emitir Factura."), //1
	Recuperar_Datos_Factura("Recuperar Datos Factura."), //2
	Cambiar_Tarifa_Cliente("Cambiar Tarifa Cliente"), //3
	Recuperar_Facturas_Cliente("Recuperar Facturas Cliente"), //4
	Listado_Facturas_Entre_2_Fechas("Listado Facturas Cliente entre dos fechas.");
	 
	
	private String descripcion;

	private EnumMenuFacturas(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static EnumMenuFacturas getOpcion(int posicion) {
		return values()[posicion]; //devuelve la opcion en tipo EnumMenuOperaciones
	}
	public static String getMenuFactura() {
		StringBuilder sb = new StringBuilder();
		
		for(EnumMenuFacturas opcion: EnumMenuFacturas.values()) {
			sb.append(opcion.ordinal());
			sb.append(" -->");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
}
