package excepciones;

public class ExClienteSinLlamadas extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3115687911849146332L;

	public ExClienteSinLlamadas() {
		super("El cliente no tiene llamadas.");//se recupera con getMessage()
	}	
}
