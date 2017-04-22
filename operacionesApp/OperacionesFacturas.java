package operacionesApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import facturacion.Factura;
import facturacion.Fecha;
import facturacion.Llamada;
import facturacion.PeriodoFacturacion;
import genericos.ListadoAPartirDeFecha;
import tipoClientes.Cliente;

public class OperacionesFacturas implements ListadoAPartirDeFecha, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2104879305172022541L;
	private HashMap<String, HashMap<Integer,Factura>> facturas; 
	private int generadorCodigoFacturas;
	
	public OperacionesFacturas() {
		 facturas = new HashMap<>();	
		generadorCodigoFacturas = 2;
	}

	public Factura emitirFactura(Cliente cliente, Collection<Llamada> llamadas, PeriodoFacturacion periodoFacturacion  ){
		//recorrer cada llamada
		float importe = 0;
		for (Iterator<Llamada> iterator =  llamadas.iterator(); iterator.hasNext();) {
			Llamada llamada = iterator.next();
			importe += llamada.getDuracion()*cliente.getTarifa().getPrecioMinuto();
		}
		
		
		Factura nuevaFactura = new Factura(generadorCodigoFacturas+2, cliente.getTarifa(), LocalDateTime.now(), periodoFacturacion, importe);
		
		if (!facturas.containsKey(cliente.getNIF())) {
			facturas.put(cliente.getNIF(), new HashMap<>());
		}
		facturas.get(cliente.getNIF()).put(generadorCodigoFacturas, nuevaFactura);
		return nuevaFactura;		
	}
	
	public Factura getDatosFactura(int codigoFactura){
		for (HashMap<Integer,Factura> valoresFacturas : facturas.values()) {
			if (valoresFacturas.containsKey(codigoFactura)) {
				return valoresFacturas.get(codigoFactura);
			}						
		}
					 
		return new Factura();		
	}
	 
	public Collection<Factura> getFacturasCliente(Cliente cliente){
		if (facturas.containsKey(cliente.getNIF())) {
			return facturas.get(cliente.getNIF()).values();
		}
		return null;		
	}
	
	public Collection<HashMap<Integer, Factura>> getDatosFacturas(){
		return facturas.values();
	}

	@Override
	public <T> Collection<? extends Fecha> listado(Collection<T> conjunto, LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		ArrayList<Fecha> nuevoConjunto =  new ArrayList<>();
		for (Fecha f : nuevoConjunto) {//mostrar listado clientes entre 2 fechas
			if (f.getFecha().isAfter(fechaInicio) && f.getFecha().isBefore(fechaFin) ) {
				nuevoConjunto.add(f);
			}			
		}
		return nuevoConjunto;
	}
}
