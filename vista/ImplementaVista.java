package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controlador.MetodosVista;
 


public class ImplementaVista implements vista.MetodosControlador, vista.MetodosModelo{
	private controlador.MetodosVista controlador; //interfaz del puto controlador joder. tiene que tener los metodos de esta clase en en la interfaz controlador joder
	private modelo.MetodosVista modelo; //interfaz del puto modelo joder. tiene que tener los metodos de esta clase en la interfaz modelo joder
	private JFrame ventana;
	private Container contenedor; 
 	private VistaCliente vistaCliente;
 
	 	
	private void GUI() {
		ventana = new JFrame("Empresa Corg SL");
        contenedor = ventana.getContentPane();
 
        JTabbedPane pestanas = new JTabbedPane();
        pestanas.add("Clientes", new VistaCliente().GUI());
        pestanas.add("Facturas", new JPanel());
        pestanas.add("Llamadas",new JPanel());
        contenedor.add(pestanas);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);;
        ventana.setVisible(true);
    }
	
    public void creaGUI() {
    	SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUI();
			}
		});
    }
    class Escuchador implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Clientes"))
                controlador.cambiarVistaClientes(); 
        }
    }
//------------------------------------------------------------------- 
 
	 public void setModelo(modelo.MetodosVista modelo) {
	        this.modelo = modelo;
	    }

	    public void setControlador(MetodosVista controlador) {
	        this.controlador = controlador;
	}
//------------------------------------------------------------------- 

	 
	
	 

}
