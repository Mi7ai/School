package facturacion;

import java.time.LocalDateTime;

public class PeriodoFacturacion {
	private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    
    public PeriodoFacturacion(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    	this.fechaInicio = fechaInicio;
    	this.fechaFin = fechaFin;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
    
    
}
