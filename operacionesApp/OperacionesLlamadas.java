package operacionesApp;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import facturacion.Llamada;

public class OperacionesLlamadas {
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
	
	public Collection<Llamada> listarLlamada(String NIF){
		return llamadas.get(NIF);//devuelve la lista de llamadas al corespondiente nif
	}
}
