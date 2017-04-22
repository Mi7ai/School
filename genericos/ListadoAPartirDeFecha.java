package genericos;

import java.time.LocalDateTime;
import java.util.Collection;

import facturacion.Fecha;

public interface ListadoAPartirDeFecha {
 
	 public <T> Collection<? extends Fecha>listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin);
}
