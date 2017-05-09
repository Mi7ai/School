package vista;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.ImplementaVista.Escuchador;

public class VistaCliente implements vista.MetodosControlador, vista.MetodosModelo{
	
	public JPanel GUI() {
        JPanel panel = new JPanel();       
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton anadirCliente = new JButton("Añadir Cliente");
        JButton borrarCliente = new JButton("Borrar Cliente");
        JButton tarifaCliente = new JButton("Cambiar Tarifa ");         
        JButton datosCliente = new JButton("Datos Cliente");
        JButton listadoCliente = new JButton("Listado Clientes");
        JButton salir = new JButton("Salir");
        
        panel.add(anadirCliente);
        panel.add(borrarCliente);
        panel.add(tarifaCliente);
        panel.add(datosCliente);
        panel.add(listadoCliente);
        panel.add(salir);
 
        return panel;
    }
 
//	    class Escuchador implements ActionListener {
//	        public void actionPerformed(ActionEvent e) {
//	            JButton boton = (JButton)e.getSource();
//	            String texto = boton.getText();
//	            if(texto.equals("Clientes"))
//	                controlador.cambiarVistaClientes(); 
//	        }
//	    }
}
