package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaFacturas {
	public JPanel GUI() {
        JPanel panel = new JPanel(); 
        JPanel panelBotones = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        JButton emitirFactura = new JButton("Emitir Factura");
        JButton cambiarTarifa = new JButton("Cambiar Tarifa Cliente");
        JButton recuperarFacturas = new JButton("Recuperar Facturas Cliente");
        JButton listadoFacturas2 = new JButton("Listado Facturas Cliente entre dos fechas");

        panelBotones.add(emitirFactura );
        panelBotones.add(cambiarTarifa);
        panelBotones.add(recuperarFacturas);
        panelBotones.add(listadoFacturas2);
 
        panel.add(panelBotones, BorderLayout.NORTH);
		
        return panel;
		
	}
	
}
