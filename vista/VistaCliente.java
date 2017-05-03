package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vista.ImplementaVista.Escuchador;

public class VistaCliente implements vista.MetodosControlador, vista.MetodosModelo{
	
	public JPanel GUI() {
//        JFrame ventana = new JFrame("Empresa Corg SL");
//        Container contenedor = ventana.getContentPane();
        JPanel jpEntrada = new JPanel();       
//        Escuchador escuchador = new Escuchador();
        
        JButton addCliente = new JButton("Añadir Cliente");
       // addCliente.addActionListener(escuchador);
//        JButton jbAtras = new JButton("Atras");
//        jbAtras.addActionListener(escuchador);
//        JButton jbAdelante = new JButton("Adelante");
//        jbAdelante.addActionListener(escuchador);
         
        jpEntrada.add(addCliente);
//        jpEntrada.add(jbAtras);
//        jpEntrada.add(jbAdelante);
//        jpContador.add(jlContador);
//        contenedor.add(jpEntrada, BorderLayout.NORTH);
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.pack();
//        ventana.setVisible(true);
        return jpEntrada;
    }

 

	@Override
	public void setVistaCliente() {
		// TODO Auto-generated method stub
		
	}
 
 
	
	 public void creaGUI() {
	    	SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new JFrame().getContentPane().add(GUI());
				}
			});
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
