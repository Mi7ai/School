package operacionesApp;

import java.util.HashMap;
import java.util.LinkedList;

import facturacion.Llamada;

public class OperacionesLlamadas {
	private HashMap<Character , LinkedList<Llamada>> llamadas;
	
	
	public OperacionesLlamadas() {
		llamadas = new HashMap<>();
		
	}

	public void altaLlamada(char NIF,Llamada llamada){
		if (!llamadas.containsKey(NIF)) {
			llamadas.put(NIF, new LinkedList<>());
			
		}
		llamadas.get(NIF).add(llamada);
		
	}
	
	public LinkedList<Llamada> listarLlamada(String NIF){
		return llamadas.get(NIF);//devuelve la lista de llamadas al corespondiente nif
	}
}
