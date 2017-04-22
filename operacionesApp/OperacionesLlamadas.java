package operacionesApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import facturacion.Fecha;
import facturacion.Llamada;
import genericos.ListadoAPartirDeFecha;

public class OperacionesLlamadas implements ListadoAPartirDeFecha, Serializable{
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
	
	public Collection<Llamada> listarLlamada(String NIF){
		return llamadas.get(NIF);//devuelve la lista de llamadas al corespondiente nif
	}

	@Override
	public <T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();//mejorar como compara las fechas
		for (Fecha f : nuevoConjunto) {//mostrar listado clientes entre 2 fechas
			if (f.getFecha().isAfter(fechaInicio) && f.getFecha().isBefore(fechaFin) ) {
				nuevoConjunto.add(f);
			}			
		}
		return nuevoConjunto;
	}

	 
}
