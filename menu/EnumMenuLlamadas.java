package menu;

public enum EnumMenuLlamadas {
	Salir("Salir"), //0
	Alta_Llamada("Alta Llamada."), //1
	Lista_Llamada("Lista Llamada."); //2
	 
	private String descripcion;

	private EnumMenuLlamadas(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static EnumMenuLlamadas getOpcion(int posicion) {
		return values()[posicion]; //devuelve la opcion en tipo EnumMenuOperaciones
	}
	public static String getMenuLlamada() {
		StringBuilder sb = new StringBuilder();
		
		for(EnumMenuLlamadas opcion: EnumMenuLlamadas.values()) {
			sb.append(opcion.ordinal());
			sb.append(" -->");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
}
