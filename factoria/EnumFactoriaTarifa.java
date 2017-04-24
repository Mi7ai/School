package factoria;

public enum EnumFactoriaTarifa {
	Tardes("Tardes"), //0
	Domingos("Domingos"); //1
	
	private String descripcion;

	private EnumFactoriaTarifa(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static EnumFactoriaTarifa getOpcion(int posicion) {
		return values()[posicion]; //devuelve la opcion en tipo EnumMenuOperaciones
	}
	public static String opciones() {
		StringBuilder sb = new StringBuilder();
		
		for(EnumFactoriaTarifa opcion: EnumFactoriaTarifa.values()) {
			sb.append(opcion.ordinal());
			sb.append(" -->");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
}
