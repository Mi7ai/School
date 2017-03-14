package genericos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import facturacion.Fecha;

public class ListadoAPartirDeFechas {

	public static Collection<? extends Fecha> listado(Collection<? extends Fecha> conjunto,LocalDateTime fechaInicio, LocalDateTime fechaFin){
		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();
		for (Fecha f : nuevoConjunto) {//mostrar listado clientes entre 2 fechas
			if (f.getFecha().compareTo(fechaInicio) > 0 && f.getFecha().compareTo(fechaFin) < 0) {
				nuevoConjunto.add(f);
			}			
		}
		return nuevoConjunto;
	}

}
