package logica;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import modelo.Pelicula;
import ui.VistaVtnPrincipal;
import ui.VistaVtnReproductor;

public class ControladorVtnPrincipal{
	private ArrayList<Pelicula> listaPelicula;
	private VistaVtnPrincipal vtnPrincipal;
	private Pelicula peliculaElegida;
	private int contFlecha=0;
	public ControladorVtnPrincipal(ArrayList<Pelicula> p, VistaVtnPrincipal v) {
		this.listaPelicula=p;
		this.vtnPrincipal=v;
		initVtnPrincipal();
		initControlador();
	}
	
	private void initVtnPrincipal() {
		/*SETEAR COSAS DEL VIEW CON LAS DE  MODELO*/
		slideShow();
		
		//La primera pelicula de la lista se le asigna el label 1
		listaPelicula.get(0).setLabel(vtnPrincipal.getImagen1());
	}
	private void initControlador() {
		/*ACTION LISTENER*/
		
		/*Le añadimos el evento al label de la pelicula 1*/
		listaPelicula.get(0).getLabel().addMouseListener(new ClickThumbnail(listaPelicula.get(0)));
		//vtnPrincipal.getImagen1().addMouseListener(new ClickThumbnail(listaPelicula.get(0)));
		
		vtnPrincipal.getImgFlechaDer().addMouseListener(new ClickFlecha(true));
		vtnPrincipal.getImgFlechaIzq().addMouseListener(new ClickFlecha(false));
	}
	

	
	
	
	private void slideShow() {
		new Thread() {
			int contador = 0;

			@Override
			public void run() {
				try {
					while (true) {
						switch (contador) {

						case 0: {		
							/*Podemos ir cambiando la imagen de los labes mientras sucede la animación, así solo usamos 2 label*/
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/recursos/Weon - Pecos Paul Kele - portada.png"));
							vtnPrincipal.getImagen1().setIcon(icon1);
							
							Thread.sleep(6000); // 3 segundos

							/*
							 * empieza, termina, delay, pixelincrement, jlabel a mover movemos desde el x de
							 * imagen a -400 (fuera de la pantalla), delay en minisegundos 20,
							 * pixelincrement (divides 400 (donde la dejas) por un numero cualquiera que de
							 * par) EJ: 400/5=80, entonces el delay * 80 = 1600 milisguendos en realizar la
							 * animacion
							 */

							vtnPrincipal.getAC().jLabelXLeft(200, -400, 20, 5, vtnPrincipal.getImagen1());
							vtnPrincipal.getAC().jLabelXLeft(800, 200, 20, 5, vtnPrincipal.getImagen2());

							contador = 1; // Cambiamos cuando termina la animacion
							break;
						}

						case 1: {
							
							ImageIcon icon2 = new ImageIcon(getClass().getResource("/recursos/2.png"));
							vtnPrincipal.getImagen2().setIcon(icon2);
							Thread.sleep(6000); // 6 segundos para que empiece cuando el otro termina

							/*
							 * empieza, termina, delay, pixelincrement, jlabel a mover movemos desde el x de
							 * imagen a -400 (fuera de la pantalla), delay en minisegundos 20,
							 * pixelincrement (divides 400 (donde la dejas) por un numero cualquiera que de
							 * par) EJ: 400/5=80, entonces el delay * 80 = 1600 milisguendos en realizar la
							 * animacion
							 */
							
							vtnPrincipal.getAC().jLabelXLeft(800, 200, 20, 5, vtnPrincipal.getImagen3());

							vtnPrincipal.getAC().jLabelXLeft(200, -400, 20, 5, vtnPrincipal.getImagen2());
							
							contador = 2; // Cambiamos cuando termina la animacion
							break;
						}
						case 2: {
							ImageIcon icon3 = new ImageIcon(getClass().getResource("/recursos/3.png"));
							vtnPrincipal.getImagen3().setIcon(icon3);
							
							Thread.sleep(6000); // 6 segundos para que empiece cuando el otro termina

							/*
							 * empieza, termina, delay, pixelincrement, jlabel a mover movemos desde el x de
							 * imagen a -400 (fuera de la pantalla), delay en minisegundos 20,
							 * pixelincrement (divides 400 (donde la dejas) por un numero cualquiera que de
							 * par) EJ: 400/5=80, entonces el delay * 80 = 1600 milisguendos en realizar la
							 * animacion
							 */

							vtnPrincipal.getAC().jLabelXRight(200, 800, 20, 5,vtnPrincipal.getImagen3());
							vtnPrincipal.getAC().jLabelXRight(-400, 200, 20, 5, vtnPrincipal.getImagen2());

							contador = 3; // Cambiamos cuando termina la animacion
							break;
						}						
						case 3: {
							ImageIcon icon2 = new ImageIcon(getClass().getResource("/recursos/2.png"));
							vtnPrincipal.getImagen1().setIcon(icon2);
							
							Thread.sleep(6000); // 6 segundos para que empiece cuando el otro termina

							/*
							 * empieza, termina, delay, pixelincrement, jlabel a mover movemos desde el x de
							 * imagen a -400 (fuera de la pantalla), delay en minisegundos 20,
							 * pixelincrement (divides 400 (donde la dejas) por un numero cualquiera que de
							 * par) EJ: 400/5=80, entonces el delay * 80 = 1600 milisguendos en realizar la
							 * animacion
							 */

							vtnPrincipal.getAC().jLabelXRight(-400, 200, 20, 5, vtnPrincipal.getImagen1());
							vtnPrincipal.getAC().jLabelXRight(200, 800, 20, 5, vtnPrincipal.getImagen2());

							contador = 0; // Cambiamos cuando termina la animación
							break;
						}

						default:
							throw new IllegalArgumentException("Unexpected value: " + contador);
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}.start();
	}

	
	public class ClickFlecha implements MouseListener{ 
		boolean dir;
		//true derecha, false izq
		ClickFlecha(boolean d){  
			this.dir = d;
	    }  
	    public void mouseClicked(MouseEvent e) {  
	    	vtnPrincipal.moverPnlFinal(dir, contFlecha);
	    	if (dir) {
		    	if (contFlecha==2) {
					contFlecha=0;
				}else {
					contFlecha++;
				}
		    	
		    	
			}else {
		    	if (contFlecha==0) {
					contFlecha=2;
				}else {
					contFlecha--;
				}
			}
	    	vtnPrincipal.getFrame().repaint();
			
	    }  
	    public void mouseEntered(MouseEvent e) {  
	        //l.setText("Mouse Entered");  
	    }  
	    public void mouseExited(MouseEvent e) {  
	        //l.setText("Mouse Exited");  
	    }  
	    public void mousePressed(MouseEvent e) {  
	        //l.setText("Mouse Pressed");  
	    }  
	    public void mouseReleased(MouseEvent e) {  

	    }  
	}    
	
	public class ClickThumbnail implements MouseListener{ 
		Pelicula pelicula;
		
		ClickThumbnail(Pelicula peliSelec){  
			this.pelicula = peliSelec;
	    }  
	    public void mouseClicked(MouseEvent e) {  
			System.out.println("lala");
			vtnPrincipal.getFrame().setVisible(false);
			VistaVtnReproductor vtnReproductor = new VistaVtnReproductor(pelicula); 
			vtnReproductor.getFrame().setVisible(true);
			modelo.Main2.reproducir(null);;
			
	    }  
	    public void mouseEntered(MouseEvent e) {  
	        //l.setText("Mouse Entered");  
	    }  
	    public void mouseExited(MouseEvent e) {  
	        //l.setText("Mouse Exited");  
	    }  
	    public void mousePressed(MouseEvent e) {  
	        //l.setText("Mouse Pressed");  
	    }  
	    public void mouseReleased(MouseEvent e) {  

	    }  
	}    
}


