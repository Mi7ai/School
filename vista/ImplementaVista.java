package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 


public class ImplementaVista implements vista.MetodosControlador, vista.MetodosModelo{
	controlador.MetodosVista controlador; //interfaz del puto controlador joder. tiene que tener los metodos de esta clase en en la interfaz controlador joder
	modelo.MetodosVista modelo; //interfaz del puto modelo joder. tiene que tener los metodos de esta clase en la interfaz modelo joder
	private JFrame ventana;
	private Container contenedor; 
	private JPanel jpEntrada;
	private VistaCliente vistaCliente;
 
	 	
	private void GUI() {
		ventana = new JFrame("Empresa Corg SL");
        contenedor = ventana.getContentPane();
        jpEntrada = new JPanel();
//        JPanel jpContador = new JPanel();
         
        Escuchador escuchador = new Escuchador();
        
        JButton jopClientes = new JButton("Clientes");
        jopClientes.addActionListener(escuchador);
//        JButton jbAtras = new JButton("Atras");
//        jbAtras.addActionListener(escuchador);
//        JButton jbAdelante = new JButton("Adelante");
//        jbAdelante.addActionListener(escuchador);
         
        jpEntrada.add(jopClientes);
//        jpEntrada.add(jbAtras);
//        jpEntrada.add(jbAdelante);
//        jpContador.add(jlContador);
        contenedor.add(jpEntrada, BorderLayout.NORTH);
//        contenedor.add(jpContador, BorderLayout.SOUTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
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
	
	public void setControlador(controlador.MetodosVista controlador) {
		this.controlador = controlador;
	}

	public void setModelo(modelo.MetodosVista modelo) {
		this.modelo = modelo;
	}
	//-------------------------------------------------------------------

	public void setJpEntrada(JPanel jpEntrada) {
		this.jpEntrada = jpEntrada;
	}

	@Override
	public void setVistaCliente() {
		 vistaCliente = new VistaCliente();
		setJpEntrada(vistaCliente.GUI());	
		vistaCliente.creaGUI();
	}

	public JPanel getJpEntrada() {
		return jpEntrada;
	}
	
    //quitar del frame el panel y poner otro
 
 
 
 
	 
	
	 

}
