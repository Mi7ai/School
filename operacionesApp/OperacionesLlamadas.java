package operacionesApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import excepciones.ExClienteSinLlamadas;
import facturacion.Fecha;
import facturacion.Llamada;
import genericos.ListadoAPartirDeFecha;

public class OperacionesLlamadas implements ListadoAPartirDeFecha, Serializable,vista.MetodosModelo{
	vista.MetodosModelo vista;
	public void setVista(vista.MetodosModelo vista) {
		 this.vista = vista;		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6151037418663745172L;
	private HashMap<String , LinkedList<Llamada>> llamadas;
	
	
	public OperacionesLlamadas() {
		llamadas = new HashMap<>();	
	}

	public void altaLlamada(String NIF,Llamada llamada){
		if (!llamadas.containsKey(NIF)) {
			llamadas.put(NIF, new LinkedList<>());
			
		}
		llamadas.get(NIF).add(llamada);
		
	}
	
	public Collection<Llamada> listarLlamada(String NIF) throws ExClienteSinLlamadas{
		if (!llamadas.containsKey(NIF) || NIF =="Null") {
			throw new ExClienteSinLlamadas();
		}
		return llamadas.get(NIF);//devuelve la lista de llamadas al corespondiente nif
		
	}

	@Override
	public <T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();
 		
		for (T f : conjunto) {//mostrar listado clientes entre 2 fechas
			if (((Fecha) f).getFecha().isAfter(fechaInicio) && ((Fecha) f).getFecha().isBefore(fechaFin) ) {
				nuevoConjunto.add((Fecha) f);
			}			
		}
		return nuevoConjunto;
	}

	 
}
