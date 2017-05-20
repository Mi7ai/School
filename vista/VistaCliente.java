package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import excepciones.ExClienteNoExistente;
import tipoClientes.Particular;

public class VistaCliente implements vista.MetodosControlador, vista.MetodosModelo, FocusListener{
	private controlador.MetodosVista controlador; //interfaz del puto controlador joder. tiene que tener los metodos de esta clase en en la interfaz controlador joder
	private modelo.MetodosVista modelo; //interfaz del puto modelo joder. tiene que tener los metodos de esta clase en la interfaz modelo joder
	private JLabel nombre,apellido,dni,email,tarifa,direccion,cp;
	private JTextField jtNombre,jtApellido,jtDni,jtEmail,jtTarifa,jtCP;
	private JComboBox<String> comboProvincias;
 	JRadioButton particular;
 	JButton anadirCliente;
	private JTextArea jtArea;
	public JPanel GUI() {
        JPanel panel = new JPanel(); 
        JPanel panelDatos = new JPanel();
        JPanel panelBotones = new JPanel();
        JPanel panelBotonesClientes = new JPanel();
        JPanel panelDireccion = new JPanel();
        JPanel panelArea = new JPanel();

        ButtonGroup tipoClientes = new ButtonGroup();
        String[] provincias = new String[] {"Castellon", "Valencia", "Patagonia", "Narnia", "Mordor"};
        
        // create a combo box with the fixed array:
        comboProvincias = new JComboBox<String>(provincias);
        
         
        
        panel.setLayout(new BorderLayout());
        panelDatos.setLayout(new GridLayout(8, 2, 5, 5));
        panelBotonesClientes.setLayout(new GridLayout(1, 2));
        
         anadirCliente = new JButton("Añadir Cliente");
        //anadirCliente.addActionListener(new anadirClienteAC());
        anadirCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 controlador.anadirCliente();

			}
		});
        
        JButton borrarCliente = new JButton("Borrar Cliente");
        JButton tarifaCliente = new JButton("Cambiar Tarifa ");
        tarifaCliente.addActionListener(new tarifaClienteAC());

        JButton datosCliente = new JButton("Datos Cliente");
        datosCliente.addActionListener(new datosClienteAC());

        JButton listadoCliente = new JButton("Listado Clientes");
        JButton salir = new JButton("Salir");
        
        panelBotones.add(anadirCliente );
        panelBotones.add(borrarCliente);
        panelBotones.add(tarifaCliente);
        panelBotones.add(datosCliente);
        panelBotones.add(listadoCliente); 
        panelBotones.add(salir);
        panel.add(panelBotones, BorderLayout.NORTH);
        
        nombre = new JLabel("Nombre");
        panelDatos.add(nombre,0);
        jtNombre = new JTextField(10);
        panelDatos.add(jtNombre,1);
        apellido = new JLabel("Apellido");
        panelDatos.add(apellido,2); 
        jtApellido = new JTextField(10);
        panelDatos.add(jtApellido,3);
        dni = new JLabel("Dni");
        panelDatos.add(dni,4);
        jtDni = new JTextField(10);
        panelDatos.add(jtDni,5);
        email = new JLabel("Email");
        panelDatos.add(email,6);
        jtEmail = new JTextField(10);
        panelDatos.add(jtEmail,7);
        tarifa = new JLabel("Tarifa");
        panelDatos.add(tarifa,8);
        jtTarifa = new JTextField(10);
        panelDatos.add(jtTarifa,9); 
        //--------------------------------------             
        direccion = new JLabel("Direccion");
        panelDatos.add(direccion,10);
        	cp = new JLabel("CP");
        	panelDireccion.add(cp);
        	jtCP = new JTextField(10);
        	panelDireccion.add(jtCP);
        	panelDireccion.add(comboProvincias);
       
        panelDatos.add(panelDireccion,11);
        //-------------------------------------------
        panelDatos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); 
   
        panel.add(panelDatos, BorderLayout.WEST);
   
        
        particular = new JRadioButton("Particular");
        
        JRadioButton empresa = new JRadioButton("Empresa");
        empresa.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (empresa.isSelected()) {
					apellido.setEnabled(false);
					jtApellido.setEnabled(false);
				}else {
					apellido.setEnabled(true);
					jtApellido.setEnabled(true);
				}
			}
		});
        tipoClientes.add(particular);
        particular.setSelected(true);//por defecto particular
        tipoClientes.add(empresa);
        
        panelBotonesClientes.add(particular,0);//añado botones a un panel
        panelBotonesClientes.add(empresa, 1);//añado botones a un panel
        
        panel.add(panelBotonesClientes, BorderLayout.EAST);
        //---JTextArea
        jtArea = new JTextArea(20,75);
        jtArea.setBorder(BorderFactory.createLineBorder(Color.black));
        panelArea.add(jtArea);
        panel.add(panelArea, BorderLayout.SOUTH);
        //---JTextArea
        return panel;
    }


  private class anadirClienteAC implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// coger los datos de los campos
		 controlador.anadirCliente();

	}
	  
  }
	private class tarifaClienteAC implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//recoger dni antes
			JDialog borrarClienteDialog = new JDialog();
			//anadirClienteDialog.setLocationRelativeTo( );
			JPanel panelTarifa = new JPanel();
			
			JLabel jlTarifa = new JLabel("Nueva tarifa:");
			JTextField jtTarifa = new JTextField(10);
			panelTarifa.add(jlTarifa);
			panelTarifa.add(jtTarifa);
			borrarClienteDialog.add(panelTarifa);
			borrarClienteDialog.pack();
			borrarClienteDialog.setVisible(true);
			borrarClienteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
 
	}
	
	private class  datosClienteAC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
 			try {
				jtArea.setText(modelo.getDatosCliente(getDni()).toString());
			} catch (ExClienteNoExistente e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return 	jtNombre.getText();

	}

	@Override
	public String getApellido() {
		return 	jtApellido.getText();
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDni() {
		// TODO Auto-generated method stub
		return 	jtDni.getText();

	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return 	jtEmail.getText();
	
	}

	@Override
	public String getTarifa() {
		return jtTarifa.getText();
		// TODO Auto-generated method stub
		
	}

	 

	@Override
	public String getCp() {
		// TODO Auto-generated method stub
		return 	jtCP.getText();

	}
	
	@Override
	public Object getProvincia() {
		// TODO Auto-generated method stub
		return comboProvincias.getSelectedItem();
	}
	
	@Override
	public Object getPoblacion() {
		// TODO Auto-generated method stub
		return comboProvincias.getSelectedItem();
	}

	 
	//------------------------------------------------------------------- 
	 
		 public void setModelo(modelo.MetodosVista modelo) {
		        this.modelo = modelo;
		    }

		    public void setControlador(controlador.MetodosVista controlador) {
		        this.controlador = controlador;
		}
	//------------------------------------------------------------------- 

			@Override
			public boolean jbParticular() {
				// TODO Auto-generated method stub
				return particular.isSelected();//true si esta sleccionado 
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
