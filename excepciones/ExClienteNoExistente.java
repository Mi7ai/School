package excepciones;

public class ExClienteNoExistente extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2826665004120024272L;

	public ExClienteNoExistente() {
		super("El dni introducido no coresponde a ningun Cliente.");//se recupera con getMessage()
	}	
	
	
}
