package ui;


import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.StringTokenizer;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.swing.BorderFactory;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;

import modelo.Main;


	public class VistaVtnAdministrador extends JFrame {
	    
	    private JPanel panel;
	    private JButton logo;
	    Color color = new Color(255,128,0);
	    private JLabel lUsuario;
	    private JLabel lContraseña;
	    private JLabel lFormularioUsuario;
	    int nivel=0,vuelta=0;
	        
	    private JButton bAgregarUsuario;
	    private JButton bAgregarContenido;
	    private JButton bEliminarUsuario;
	    private JButton bEliminarContenido;
	    private JButton bIrVistaUsuario;
	    private JButton bGuardar;
	        
	    private JTextField tNuevoNombreUsuario;
	    private JTextField tNuevaContraseñaUsuario;
	    private JTextField tNombreNuevoContenido;
	    private JTextField tNombre;
	    private JTextField tNombreNuevoUsuario;
	    
	    public VistaVtnAdministrador(){
	        
	    	setSize(1300,770);
	        setVisible(true);
	        setTitle("LaWeApp");
	        setResizable(false);
	        setLocationRelativeTo(null);
	        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        iniciarComponentes();
      
	    }
	    
	    private void iniciarComponentes(){
	         
	        colocarLaminas();
	        colocarBotones();
	        colocarCajasDeTexto();
	        colocarEtiquetas();
	               
	    }
	    
	    private void colocarLaminas(){
	    
	         panel=new JPanel();
	    	 panel.setBackground(Color.WHITE);
	         panel.setLayout(null);
	         this.getContentPane().add(panel);
	    }
	    
	    private void colocarEtiquetas(){
	    	
	        lUsuario = new JLabel("Nuevo Usuario:");
	        lUsuario.setBounds(550,280,220,30);
	        lUsuario.setFont(new Font("Serif",Font.PLAIN, 27));
	        lUsuario.setVisible(false);
	        panel.add(lUsuario);
	    	
	        lContraseña = new JLabel("Contraseña:");
	        lContraseña.setBounds(550,400,220,30);
	        lContraseña.setFont(new Font("Serif",Font.PLAIN, 27));
	        lContraseña.setVisible(false);
	        panel.add(lContraseña);
	        
	        lFormularioUsuario = new JLabel("Formulario para un nuevo usuario");
	        lFormularioUsuario.setBounds(550,200,460,35);
	        lFormularioUsuario.setFont(new Font("Serif",Font.PLAIN, 30));
	        lFormularioUsuario.setVisible(false);
	        panel.add(lFormularioUsuario);
	        
	        JLabel barra_arriba_negra = new JLabel();
	        barra_arriba_negra.setBounds(0,0,1300,100);
	        barra_arriba_negra.setVisible(true);
	        barra_arriba_negra.setBorder(null);
	        Image Foto2 = new ImageIcon (getClass().getResource("/recursos/barra_arriba_negra.png")).getImage();
	        barra_arriba_negra.setIcon(new ImageIcon(Foto2.getScaledInstance(barra_arriba_negra.getWidth(), barra_arriba_negra.getHeight(),Image.SCALE_SMOOTH)));
	        panel.add(barra_arriba_negra);
	        
	    }
	   
	    
	    private void colocarCajasDeTexto(){
	        
	        tNuevoNombreUsuario = new JTextField();
	        tNuevoNombreUsuario.setBounds(550,320,350,50);
	        tNuevoNombreUsuario.setFont(new Font("Serif",Font.PLAIN, 20));
	        tNuevoNombreUsuario.setForeground(new Color(120,120,120));
	        tNuevoNombreUsuario.setVisible(false);
	        panel.add(tNuevoNombreUsuario);
	        
	        tNuevaContraseñaUsuario = new JTextField();
	        tNuevaContraseñaUsuario.setBounds(550,440,350,50);
	        tNuevaContraseñaUsuario.setFont(new Font("Serif",Font.PLAIN, 20));
	        tNuevaContraseñaUsuario.setForeground(new Color(120,120,120));
	        tNuevaContraseñaUsuario	.setVisible(false);
	        panel.add(tNuevaContraseñaUsuario);
	        
	    }
	    
	    private void colocarBotones(){
      
	        bAgregarUsuario = new JButton("Agregar Usuario");
	        bAgregarUsuario.setBounds(100,200,320,70);
	        bAgregarUsuario.setForeground(new Color(10,10,10));
	        bAgregarUsuario.setFont(new Font("Serif",Font.PLAIN, 34));
	        bAgregarUsuario.setBackground(color);
	        bAgregarUsuario.setEnabled(true);
	        panel.add(bAgregarUsuario);
	        
	        bAgregarContenido = new JButton("Agregar Contenido");
	        bAgregarContenido.setBounds(100,300,320,70);
	        bAgregarContenido.setForeground(new Color(10,10,10));
	        bAgregarContenido.setFont(new Font("Serif",Font.PLAIN, 34));
	        bAgregarContenido.setBackground(color);
	        bAgregarContenido.setEnabled(true);
	        panel.add(bAgregarContenido);
	        
	        bEliminarUsuario = new JButton("Eliminar Usuario");
	        bEliminarUsuario.setBounds(100,400,320,70);
	        bEliminarUsuario.setForeground(new Color(10,10,10));
	        bEliminarUsuario.setFont(new Font("Serif",Font.PLAIN, 34));
	        bEliminarUsuario.setBackground(color);
	        bEliminarUsuario.setEnabled(true);
	        panel.add(bEliminarUsuario);
	        
	        bEliminarContenido = new JButton("Eliminar Usuario");
	        bEliminarContenido.setBounds(100,500,320,70);
	        bEliminarContenido.setForeground(new Color(10,10,10));
	        bEliminarContenido.setFont(new Font("Serif",Font.PLAIN, 34));
	        bEliminarContenido.setBackground(color);
	        bEliminarContenido.setEnabled(true);
	        panel.add(bEliminarContenido); 
	        
	        bIrVistaUsuario = new JButton("Ir vista usuario");
	        bIrVistaUsuario.setBounds(1000,15,260,70);
	        bIrVistaUsuario.setForeground(new Color(10,10,10));
	        bIrVistaUsuario.setFont(new Font("Serif",Font.PLAIN, 34));
	        bIrVistaUsuario.setBackground(color);
	        bIrVistaUsuario.setEnabled(true);
	        panel.add(bIrVistaUsuario); 
	        
	        bGuardar = new JButton("Guardar");
	        bGuardar.setBounds(600,550,250,70);
	        bGuardar.setForeground(new Color(10,10,10));
	        bGuardar.setFont(new Font("Serif",Font.PLAIN, 34));
	        bGuardar.setBackground(color);
	        bGuardar.setEnabled(true);
	        bGuardar.setVisible(false);
	        panel.add(bGuardar); 
	        
	        logo = new JButton();
	        logo.setBounds(0,0,150,110);
	        logo.setVisible(true);
	        logo.setBackground(Color.WHITE);
	        logo.setBorder(null);
	        //Image Foto2 = new ImageIcon (("recursos/logo.png")).getImage();
	        Image Foto2 = new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage();
	        logo.setIcon(new ImageIcon(Foto2.getScaledInstance(logo.getWidth(), logo.getHeight(),Image.SCALE_SMOOTH)));
	        //logo.setIcon(Foto2.get);
	        panel.add(logo);
	        
	        ActionListener oyenteLogo = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                
	            	 VistaVtnAdministrador ventana = new VistaVtnAdministrador();
	                 dispose();
	            }
	         };
	         logo.addActionListener(oyenteLogo);
	        
	         //Agregar Usuario
	         ActionListener oyenteAgregarUsuario = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	            	 bGuardar.setVisible(true);
	            	 tNuevaContraseñaUsuario.setVisible(true);
	            	 tNuevoNombreUsuario.setVisible(true);
	            	 lUsuario.setVisible(true);
	            	 lContraseña.setVisible(true);
	            	 lFormularioUsuario.setVisible(true);
	             }
	         };
	         bAgregarUsuario.addActionListener(oyenteAgregarUsuario);
	         
	         //eliminar usuario
	         ActionListener oyenteEliminarUsuario = new ActionListener(){
		         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {			        
	
	             }
	         };
	         bEliminarUsuario.addActionListener(oyenteEliminarUsuario);
	         
	         //eliminar contenido
	         ActionListener oyenteEliminarContenido = new ActionListener(){
		         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {			        
	
	             }
	         };
	         bEliminarContenido.addActionListener(oyenteEliminarContenido);
	         
	         //agregar contenido
	         ActionListener oyenteAgregarContenido = new ActionListener(){
		         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {			        
	
	             }
	         };
	         bAgregarContenido.addActionListener(oyenteAgregarContenido);
	         
	         //ir a vista usuario
	         ActionListener oyenteIrAVistaUsuario = new ActionListener(){
		         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {			        
		    			dispose();
		    			Main.loginAceptado();
	             }
	         };
	         bIrVistaUsuario.addActionListener(oyenteIrAVistaUsuario);
	    }
	    
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        
	        g.setColor(Color.ORANGE);
	        g.drawLine(155,130,1300,130);
	        g.drawLine(155,131,1300,131);
	        g.drawLine(155,132,1300,132);	        
	        
	  }
	    

}
