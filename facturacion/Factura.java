package facturacion;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Fecha, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7095540914452127725L;
	private Tarifa tarifa;
	private int codigoFactura;
	private LocalDateTime fechaEmision;
	private PeriodoFacturacion periodoFacturacion;
	private float importe;
	
	public Factura(){
		
	}
	public Factura(int codigoFactura,Tarifa tarifa, LocalDateTime fechaEmision, PeriodoFacturacion periodoFacturacion,float importe) {
		super();
		this.tarifa = tarifa;
		this.codigoFactura = codigoFactura;
		this.fechaEmision = fechaEmision;
		this.periodoFacturacion = periodoFacturacion;
		this.importe = importe;
	}

	public PeriodoFacturacion getPeriodoFacturacion() {
		return periodoFacturacion;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public int getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	@Override
	public LocalDateTime getFecha() {
		// TODO Auto-generated method stub
		return fechaEmision;
	}

	public float getImporte() {
		return importe;
	}
	@Override
	public String toString() {
		return "Factura [tarifa=" + tarifa.getPrecioMinuto() + ", codigoFactura=" + codigoFactura + ", fechaEmision=" + fechaEmision
				+ ", periodoFacturacion=" + periodoFacturacion.getFechaFin()+" : "+periodoFacturacion.getFechaFin() + ", importe=" + importe + "]";
	}
	
	
	
}
