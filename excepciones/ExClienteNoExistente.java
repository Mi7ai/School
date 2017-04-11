package exceptiones;

public class ExClienteNoExistente extends Exception {
	public ExClienteNoExistente() {
		super("El dni introducido no coresponde a ningun Cliente.");//se recupera con getMessage()
	}	
}
