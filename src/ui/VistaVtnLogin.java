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
	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;

import modelo.Main2;


	public class VistaVtnLogin extends JFrame {
	    
	    private JPanel panel;
	    private JTextField cajaTexto1;
	    private JTextField cajaTexto2;
	    private JButton boton1;
	    private JButton logo;
	    Color color = new Color(255,128,0);
	    String usuario="incorrecto";
	    String contraseña="incorrecto";
	    int nivel=0,vuelta=0;
	    
	    public VistaVtnLogin(){
	        
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
	        colocarListaDespegable();
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
	        
	        JLabel info = new JLabel("Inicio de Sesión");
	        info.setBounds(550,170,230,30);
	        info.setFont(new Font("Serif",Font.PLAIN, 34));
	        panel.add(info);
	        
	        JTextArea info2 = new JTextArea("Revisa todo nuestro contenido y diviértete");
	        info2.setBounds(550,205,335,30);
	        info2.setForeground(new Color(155,155,155));
	        info2.setFont(new Font("Serif",Font.PLAIN, 20));
	        panel.add(info2);
	        
	        JLabel usuario = new JLabel("Usuario");
	        usuario.setBounds(550,280,220,30);
	        usuario.setFont(new Font("Serif",Font.PLAIN, 27));
	        panel.add(usuario);
	        
	        JLabel contraseña = new JLabel("Contraseña");
	        contraseña.setBounds(550,400,220,30);
	        contraseña.setFont(new Font("Serif",Font.PLAIN, 27));
	        panel.add(contraseña);
	        
	        JLabel barra_abajo = new JLabel();
	        barra_abajo.setBounds(-10,670,1330,100);
	        barra_abajo.setVisible(true);
	        barra_abajo.setBorder(null);
	        Image Foto1 = new ImageIcon (getClass().getResource("/recursos/barra_abajo.jpg")).getImage();
	        barra_abajo.setIcon(new ImageIcon(Foto1.getScaledInstance(barra_abajo.getWidth(), barra_abajo.getHeight(),Image.SCALE_SMOOTH)));
	        panel.add(barra_abajo);  
	        
	        JLabel barra_arriba = new JLabel();
	        barra_arriba.setBounds(0,0,1300,80);
	        barra_arriba.setVisible(true);
	        barra_arriba.setBorder(null);
	        Image Foto2 = new ImageIcon (getClass().getResource("/recursos/barra_abajo.jpg")).getImage();
	        barra_arriba.setIcon(new ImageIcon(Foto2.getScaledInstance(barra_arriba.getWidth(), barra_arriba.getHeight(),Image.SCALE_SMOOTH)));
	        panel.add(barra_arriba);
	        
	        JLabel logooo = new JLabel();
	        logooo.setBounds(400,150,100,80);
	        logooo.setVisible(true);
	        logooo.setBorder(null);

	        Image Foto = new ImageIcon (getClass().getResource("/recursos/logo.png")).getImage();
	        logooo.setIcon(new ImageIcon(Foto.getScaledInstance(logooo.getWidth(), logooo.getHeight(),Image.SCALE_SMOOTH)));
	        panel.add(logooo);
	    }
	    
	    private void colocarListaDespegable(){
	        
	        
	        String [] numeroTanques = {"español"};
	        JComboBox idioma = new JComboBox(numeroTanques);
	        idioma.setBackground(color);
	        idioma.setBounds(1190,80,100,30);
	        panel.add(idioma);
	        
	        
	    }
	    
	    
	    
	    private void colocarCajasDeTexto(){
	        
	        
	        cajaTexto1 = new JTextField();
	        cajaTexto1.setBounds(550,320,350,50);
	        cajaTexto1.setFont(new Font("Serif",Font.PLAIN, 25));
	        cajaTexto1.setForeground(new Color(120,120,120));
	        panel.add(cajaTexto1);
	        
	        cajaTexto2 = new JTextField();
	        cajaTexto2.setBounds(550,440,350,50);
	        cajaTexto2.setFont(new Font("Serif",Font.PLAIN, 25));
	        cajaTexto2.setForeground(new Color(120,120,120));
	        panel.add(cajaTexto2);
	        
	        
	        ActionListener oyentedeaccion1 = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                
	                 usuario=new String(cajaTexto1.getText());
	                 
	                 try {
	                     String result = buscar(usuario);
	                     
	                     if(result=="correcto"){
	                         
	                        usuario="correcto";
	                     }
	                     else{
	                        usuario="incorrecto";
	                    }
	                     
	                 } catch (IOException ex) {
	                     Logger.getLogger(VistaVtnLogin.class.getName()).log(Level.SEVERE, null, ex);
	                 }
	                 
	                 
	                 
	            }
	         };
	         cajaTexto1.addActionListener(oyentedeaccion1);
	        
	        
	        
	        
	        
	        ActionListener oyentedeaccion2 = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                
	                 
	                 contraseña=new String(cajaTexto2.getText());
	                 try {
	                     String result = buscar(contraseña);
	                     if(result=="correcto"){
	                     
	                     contraseña="correcto";
	                    }
	                    else{
	                        contraseña="incorrecto";
	                    }
	                 } catch (IOException ex) {
	                     Logger.getLogger(VistaVtnLogin.class.getName()).log(Level.SEVERE, null, ex);
	                 }
	                 
	             
	             }
	         };
	         cajaTexto2.addActionListener(oyentedeaccion2);
	        
	        
	    }
	    
	    private void colocarBotones(){
	        
	        
	        
	        boton1 = new JButton("Ingresar");
	        boton1.setBounds(595,540,250,70);
	        boton1.setForeground(new Color(10,10,10));
	        boton1.setFont(new Font("Serif",Font.PLAIN, 34));
	        boton1.setBackground(color);
	        boton1.setEnabled(true);
	        panel.add(boton1);
	        
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
	        
	        ActionListener oyentedeaccion1 = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                
	            	 VistaVtnLogin ventana = new VistaVtnLogin();
	                 dispose();
	            }
	         };
	         logo.addActionListener(oyentedeaccion1);
	        
	        
	         
	         ActionListener oyentedeaccion2 = new ActionListener(){
	         	
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                
	                 if((usuario.equals("correcto"))&&(contraseña.equals("correcto"))){
	                     dispose();
	                     Main2.loginAceptado();
	                 }
	                 
	                 else {
	                     JTextArea error = new JTextArea("Usuario y/o contraseña incorrectos");
	                     error.setBounds(550,505,300,20);
	                     error.setVisible(true);
	                     panel.add(error);
	                 }
	            }
	         };
	         boton1.addActionListener(oyentedeaccion2);
	         
	         
	         
	         
	    }
	    
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.setColor(Color.BLACK);
	        
	        g.drawLine(350,170,1000,170);
	        g.drawLine(350,650,1000,650);
	        g.drawLine(350,170,350,650);
	        g.drawLine(1000,170,1000,650);
	        
	        g.setColor(Color.ORANGE);
	        g.drawLine(155,107,1300,107);
	        g.drawLine(155,108,1300,108);
	        g.drawLine(155,109,1300,109);
	        
	        g.drawLine(0,700,1300,700);
	        g.drawLine(0,701,1300,701);
	        g.drawLine(0,702,1300,702);
	        
	  }
	    
	    
	    public String buscar(String cadena)throws FileNotFoundException, IOException{
	            
	            String linea;
	            int numLineas=300,contador=0,existe_codigo=0;
	            
	            String datos []=new String [numLineas];

	            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
	            linea = reader.readLine();
	            while (linea != null && contador<numLineas){
	        
	                datos[contador]=linea;
	                linea = reader.readLine();

	                int cont = 0;
	                StringTokenizer st = new StringTokenizer (datos[contador]);

	                
	               while(st.hasMoreTokens()){
	                    
	                    String array=st.nextToken();
	                    cont = cont + 1;

	                    if((cont==1)&&(vuelta==0)){

	                        if(array.equals(cadena)){

	                            existe_codigo=1;
	                            System.out.println("E usuario");
	                            nivel=contador;
	                            vuelta=1;
	                            return "correcto"; 
	                        }
	                               
	                    }
	                    if((cont==2)&&(nivel==contador)){
	                        
	                        if(array.equals(cadena)){

	                            existe_codigo=1;
	                            System.out.println("E contraseña");
	                            return "correcto";
	                        }
	                    }
	                }
	               
	                contador++;
	            }
	            if(existe_codigo==0){
	                return "incorrecto";
	            }
	           reader.close();
	           return "incorrecto";
	        }

	
	    
}
