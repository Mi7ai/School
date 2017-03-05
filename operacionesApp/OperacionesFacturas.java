package operacionesApp;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import facturacion.Factura;
import facturacion.Llamada;
import tipoClientes.Cliente;

public class OperacionesFacturas {
	private HashMap<String, HashMap<Integer,Factura>> facturas; 
	private int generadorCodigoFacturas;
	
	public OperacionesFacturas(Factura factura) {
		 facturas = new HashMap<>();	
		generadorCodigoFacturas = 2;
	}

	public Factura emitirFactura(Cliente cliente, OperacionesLlamadas llamadas, Factura factura ){
		//recorrer cada llamada
		float importe = 0;
		for (Llamada llamada : llamadas.listarLlamada(cliente.getNIF())) {
			 importe = llamada.getDuracion()*cliente.getTarifa().getPrecioMinuto();
		}
		
		Factura nuevaFactura = new Factura(generadorCodigoFacturas+2, factura.getTarifa(), factura.getFecha(), factura.getPeriodoFacturacion(), importe);
		
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
}
