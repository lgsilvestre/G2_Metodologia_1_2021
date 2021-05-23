package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppPackage.AnimationClass;

public class VistaVtnPrincipal {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton button;
	
	//Labels Slideshow 
	JLabel imagen1;
	JLabel imagen2;
	JLabel imagen3;
	
	//Labels PanelFinal
	JLabel imgPF1;
	JLabel imgPF2;
	JLabel imgPF3;
	ImageIcon iconPF1;
	ImageIcon iconPF2;	
	ImageIcon iconPF3;
	
	JLabel imgFlechaDer;
	JLabel imgFlechaIzq;

	
	JLabel imagenLogo;
	JButton botonBuscar;
	// AnimationClass para el Slideshow
	AnimationClass AC = new AnimationClass();
	JTextField cajaTexto1;
	JButton logo;
	JButton buscar;
	
	public VistaVtnPrincipal() {
		initcomponents();
		
		// COLOCA COSAS DE ARRIBA HACIA ABAJO
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(null);
		button.setText("Button");
		/*
		 * panel.add(label); panel.add(button);
		 */
		frame.add(panel);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel.add(imagen1);
		panel.add(imagen2);
		panel.add(imagen3);
		panel.add(imagenLogo);
		// Iniciamos imagenes para el slideshow
		
		
		panel.add(imgPF1);
		panel.add(imgPF2);
		panel.add(imgPF3);

		
		panel.add(imgFlechaDer);
		panel.add(imgFlechaIzq);
		iniciarImagenes();
	}

	private void initcomponents() {
		frame = new JFrame("LaWeApp");
		panel = new JPanel();
		label = new JLabel("JFrame By Example");
		button = new JButton();
		imagen1 = new JLabel();
		imagen2 = new JLabel();
		imagen3 = new JLabel();
		imagenLogo = new JLabel();
		
		
		imgPF1 = new JLabel();
		imgPF2 = new JLabel();
		imgPF3 = new JLabel();
		
		imgFlechaDer = new JLabel();
		imgFlechaIzq = new JLabel();
		iniciarImagenes();
		CajaTextos();
		botones();

	}
	
	private void botones(){
		
		buscar = new JButton();
        buscar.setBounds(740,10,30,30);
        buscar.setVisible(true);
        buscar.setBackground(Color.WHITE);
        Image Foto = new ImageIcon(getClass().getResource("/recursos/buscar.png")).getImage();
        Image newimg = Foto.getScaledInstance(buscar.getWidth(), buscar.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg); 
        buscar.setIcon(imageIcon);
        panel.add(buscar);
        
        logo = new JButton();
        logo.setBounds(0,0,100,70);
        logo.setVisible(true);
        logo.setBackground(Color.WHITE);
        Image Foto2 = new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage();
        Image newimg2 = Foto2.getScaledInstance(logo.getWidth(), logo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon imageIcon2 = new ImageIcon(newimg2); 
        logo.setIcon(imageIcon2);
        panel.add(logo);
        
        
       ActionListener oyentedeaccion1 = new ActionListener(){
         	
            @Override
            public void actionPerformed(ActionEvent ae) {
               
               
                
           }
        };
        buscar.addActionListener(oyentedeaccion1);
        
        
        
        ActionListener oyentedeaccion2 = new ActionListener(){
         	
            @Override
            public void actionPerformed(ActionEvent ae) {
               
               VistaVtnPrincipal ventana = new VistaVtnPrincipal();
               dispose();
                
           }
        };
        logo.addActionListener(oyentedeaccion2);
	
	}

	private void CajaTextos(){	
			
		cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(590,10,150,30);
        panel.add(cajaTexto1);
		
		
        ActionListener oyentedeaccion1 = new ActionListener(){
         	
            @Override
            public void actionPerformed(ActionEvent ae) {

                
           }
        };
        cajaTexto1.addActionListener(oyentedeaccion1);
	
	}
	

	private void iniciarImagenes() {
		
		//Slideshow
		/*imagen1.setBounds(200, 121, 400, 222);
		imagen2.setBounds(800, 121, 400, 222);
		imagen3.setBounds(800, 121, 400, 222);*/
		imagen1.setBounds(200, 60, 400, 222);
		imagen2.setBounds(800, 60, 400, 222);
		imagen3.setBounds(800, 60, 400, 222);
		
		
		
		imagenLogo.setBounds(15, 0, 50, 50);
		//ImageIcon logo = new ImageIcon(getClass().getResource("/recursos/logo.png"));
		//imagenLogo.setIcon(logo);
		 Image ilogo = new ImageIcon (getClass().getResource("/recursos/logo.png")).getImage();
		imagenLogo.setIcon(new ImageIcon(ilogo.getScaledInstance(imagenLogo.getWidth(), imagenLogo.getHeight(),Image.SCALE_SMOOTH)));
		
		
		//Panel Final
		
		imgPF1.setBounds(100, 340, 170, 200);
		iconPF1 = new ImageIcon(getClass().getResource("/recursos/1P.png"));
		imgPF1.setIcon(iconPF1);
			//Le aumentamos la posición en x por el ancho de la imagen: 240+10.... mejor 200
		imgPF2.setBounds(300, 340, 170, 200);
		iconPF2 = new ImageIcon(getClass().getResource("/recursos/2P.png"));
		imgPF2.setIcon(iconPF2);
		
		imgPF3.setBounds(500, 340, 170, 200);
		iconPF3 = new ImageIcon(getClass().getResource("/recursos/3P.png"));
		imgPF3.setIcon(iconPF3);
		
		//int x, int y, width, height
		
		imgFlechaDer.setBounds(700, 400, 50, 50);
		Image iFlechaDer = new ImageIcon (getClass().getResource("/recursos/flechader.png")).getImage();
		imgFlechaDer.setIcon(new ImageIcon(iFlechaDer.getScaledInstance(imgFlechaDer.getWidth(), imgFlechaDer.getHeight(),Image.SCALE_SMOOTH)));
		
		imgFlechaIzq.setBounds(25, 400, 50, 50);
		Image iFlechaIzq = new ImageIcon (getClass().getResource("/recursos/flechaizq.png")).getImage();
		imgFlechaIzq.setIcon(new ImageIcon(iFlechaIzq.getScaledInstance(imgFlechaIzq.getWidth(), imgFlechaIzq.getHeight(),Image.SCALE_SMOOTH)));

		
	}
	
	public void moverPnlFinal(boolean dir, int cont) {
		if (dir) {
			switch (cont) {
			case 0: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/4P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/5P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/6P.png"));
				break;
			}
			case 1: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/7P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/8P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/9P.png"));
				break;
			}
			case 2: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/1P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/2P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/3P.png"));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + cont);
			}
			
		}else {
			switch (cont) {
			case 0: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/7P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/8P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/9P.png"));
				break;
			}
			case 1: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/1P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/2P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/3P.png"));
				break;
			}
			case 2: {
				iconPF1 = new ImageIcon(getClass().getResource("/recursos/4P.png"));
				iconPF2 = new ImageIcon(getClass().getResource("/recursos/5P.png"));
				iconPF3 = new ImageIcon(getClass().getResource("/recursos/6P.png"));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + cont);
			}
		}
		imgPF1.setIcon(iconPF1);
		imgPF2.setIcon(iconPF2);
		imgPF3.setIcon(iconPF3);
	}
	

	public JLabel getImgFlechaDer() {
		return imgFlechaDer;
	}

	public void setImgFlechaDer(JLabel imgFlechaDer) {
		this.imgFlechaDer = imgFlechaDer;
	}

	public JLabel getImgFlechaIzq() {
		return imgFlechaIzq;
	}

	public void setImgFlechaIzq(JLabel imgFlechaIzq) {
		this.imgFlechaIzq = imgFlechaIzq;
	}

	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}


	public JButton getButton() {
		return button;
	}


	public void setButton(JButton button) {
		this.button = button;
	}


	public JLabel getImagen1() {
		return imagen1;
	}


	public void setImagen1(JLabel imagen1) {
		this.imagen1 = imagen1;
	}


	public JLabel getImagen2() {
		return imagen2;
	}


	public void setImagen2(JLabel imagen2) {
		this.imagen2 = imagen2;
	}


	public JLabel getImagen3() {
		return imagen3;
	}


	public void setImagen3(JLabel imagen3) {
		this.imagen3 = imagen3;
	}


	public JLabel getImagenLogo() {
		return imagenLogo;
	}


	public void setImagenLogo(JLabel imagenLogo) {
		this.imagenLogo = imagenLogo;
	}


	public JButton getBotonBuscar() {
		return botonBuscar;
	}


	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}


	public AnimationClass getAC() {
		return AC;
	}


	public void setAC(AnimationClass aC) {
		AC = aC;
	}



}