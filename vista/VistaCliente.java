package vista;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VistaCliente implements vista.MetodosControlador, vista.MetodosModelo, FocusListener{
	
	public JPanel GUI() {
        JPanel panel = new JPanel(); 
        JPanel panelDatos = new JPanel();
        JPanel panelBotones = new JPanel();
        JPanel panelBotonesClientes = new JPanel();
        JPanel panelDireccion = new JPanel();
        
        ButtonGroup tipoClientes = new ButtonGroup();
        String[] provincias = new String[] {"Castellon", "Valencia", "Patagonia", "Narnia", "Mordor"};
        
        // create a combo box with the fixed array:
        JComboBox<String> comboProvincias = new JComboBox<String>(provincias);
        
         
        
        panel.setLayout(new BorderLayout());
        panelDatos.setLayout(new GridLayout(8, 2, 50, 5));
        panelBotonesClientes.setLayout(new GridLayout(1, 2));
        
        JButton anadirCliente = new JButton("Añadir Cliente");
        JButton borrarCliente = new JButton("Borrar Cliente");
        JButton tarifaCliente = new JButton("Cambiar Tarifa ");         
        JButton datosCliente = new JButton("Datos Cliente");
        JButton listadoCliente = new JButton("Listado Clientes");
        JButton salir = new JButton("Salir");
        
        panelBotones.add(anadirCliente );
        panelBotones.add(borrarCliente);
        panelBotones.add(tarifaCliente);
        panelBotones.add(datosCliente);
        panelBotones.add(listadoCliente); 
        panelBotones.add(salir);
        panel.add(panelBotones, BorderLayout.NORTH);
        
        
        panelDatos.add(new JLabel("Nombre"),0);        
        panelDatos.add(new JTextField(10),1);
        JLabel apellido = new JLabel("Apellido");
        panelDatos.add(apellido,2); 
        JTextField jtapellido = new JTextField(10);
        panelDatos.add(jtapellido,3);
        panelDatos.add(new JLabel("Dni"),4);
        panelDatos.add(new JTextField(10),5);
        panelDatos.add(new JLabel("Email"),6);
        panelDatos.add(new JTextField(10),7);
        panelDatos.add(new JLabel("Tarifa"),8);
        //--------------------------------------
        panelDatos.add(new JTextField(10),9);
        panelDatos.add(new JLabel("Direccion"),10);
        
        panelDireccion.add(new JLabel("CP"));
        JTextField cp = new JTextField(10);
        panelDireccion.add(cp);
        panelDireccion.add(comboProvincias);
        
        panelDatos.add(panelDireccion,11);
        //-------------------------------------------
        panelDatos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); 
   
        panel.add(panelDatos, BorderLayout.WEST);
   
        
        JRadioButton particular = new JRadioButton("Particular");
        
        JRadioButton empresa = new JRadioButton("Empresa");
        empresa.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (empresa.isSelected()) {
					apellido.setEnabled(false);
					jtapellido.setEnabled(false);
				}else {
					apellido.setEnabled(true);
					jtapellido.setEnabled(true);
				}
			}
		});
        tipoClientes.add(particular);
        particular.setSelected(true);
        tipoClientes.add(empresa);
        
        panelBotonesClientes.add(particular,0);
        panelBotonesClientes.add(empresa, 1);
        
        panel.add(panelBotonesClientes, BorderLayout.EAST);
        
         return panel;
    }

	@Override
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	    class Escuchador implements ActionListener {
//	        public void actionPerformed(ActionEvent e) {
//	            JButton boton = (JButton)e.getSource();
//	            String texto = boton.getText();
//	            if(texto.equals("Clientes"))
//	                controlador.cambiarVistaClientes(); 
//	        }
//	    }
	
//  dni.addFocusListener(new FocusListener() {
//		
//		@Override
//		public void focusLost(FocusEvent e) {
//			// TODO Auto-generated method stub	 
//				dni.setText("Dni");			
//		}
//		
//		@Override
//		public void focusGained(FocusEvent e) {
//			// TODO Auto-generated method stub
//			dni.setText("");
//		}
//	});
     
}
