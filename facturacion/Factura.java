package facturacion;

import java.time.LocalDateTime;

public class Factura implements Fecha{
	private Tarifa tarifa;
	private int codigoFactura;
	private LocalDateTime fechaEmision;
	private LocalDateTime periodoFacturacion;
	private float importe;
	
	public Factura(Tarifa tarifa, int codigoFactura, LocalDateTime fechaEmision, LocalDateTime periodoFacturacion,float importe) {
		super();
		this.tarifa = tarifa;
		this.codigoFactura = codigoFactura;
		this.fechaEmision = fechaEmision;
		this.periodoFacturacion = periodoFacturacion;
		this.importe = importe;
	}

	public LocalDateTime getPeriodoFacturacion() {
		return periodoFacturacion;
	}

	public void setPeriodoFacturacion(LocalDateTime periodoFacturacion) {
		this.periodoFacturacion = periodoFacturacion;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public int getCodigoFactura() {
		return codigoFactura;
	}

	@Override
	public LocalDateTime getFecha() {
		// TODO Auto-generated method stub
		return fechaEmision;
	}

	public float getImporte() {
		return importe;
	}

	
	
	
}
