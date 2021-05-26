package logica;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import modelo.Main;
import modelo.Pelicula;
import ui.VistaVtnPrincipal;
import ui.VistaVtnReproductor;

public class ControladorVtnPrincipal {
	private ArrayList<Pelicula> listaPelicula = new ArrayList<>();
	private VistaVtnPrincipal vtnPrincipal;
	private int contFlecha = 0;

	public ControladorVtnPrincipal(/* ArrayList<Pelicula> p, */ VistaVtnPrincipal v) {
		/* this.listaPelicula=p; */
		try {
			cargarContenido();
			this.vtnPrincipal = v;
			initVtnPrincipal();
			initControlador();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	//Cargamos contenido desde el txt
	private void cargarContenido() throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0;

		String datos[] = new String[numLineas];

		BufferedReader reader = new BufferedReader(new FileReader("multimedia.txt"));
		linea = reader.readLine();

		String titulo;
		ImageIcon thumbnail;
		String genero;
		File file;

		while (linea != null && contador < numLineas) {

			datos[contador] = linea;

			StringTokenizer st = new StringTokenizer(datos[contador]);
			System.out.println("Pelicula Nº" + (contador + 1) + "\n");

			for (int i = 0; i < st.countTokens(); i++) {

				titulo = st.nextToken().toString();
				System.out.println(titulo);
				thumbnail = new ImageIcon(st.nextToken().toString());
				System.out.println(thumbnail);
				genero = st.nextToken().toString();
				System.out.println(genero);
				file = new File(st.nextToken().toString());
				System.out.println(file);

				Pelicula peliculaCar = new Pelicula(titulo, thumbnail, genero, file);
				System.out.println("Thumbnail objeto: " +peliculaCar.getThumbnail());
				
				listaPelicula.add(peliculaCar);

			}

			System.out.println("");

			contador++;
			linea = reader.readLine();
		}

		reader.close();

	}
	

	/* SETEAR COSAS DEL VIEW CON LAS DE MODELO Y EL CONTENIDO CARGADO*/
	private void initVtnPrincipal() {

		/*Cargamos las imagenes */
		vtnPrincipal.iniciarImagenes(listaPelicula);
		vtnPrincipal.iniciarPanelFinal(0, listaPelicula);
		/*Iniciamos el sliddeshow*/
		slideShow();

	}
	/* ACTION LISTENER */
	private void initControlador() {
		

		/*
		 * Le añadimos el evento al label de la vtn principal y lo unimos al evento con
		 * las peliculas mas populares
		 */

		vtnPrincipal.getImagen1().addMouseListener(new ClickThumbnail(encontrarPelicula(vtnPrincipal.getDirIconImg1())));
		vtnPrincipal.getImagen2().addMouseListener(new ClickThumbnail(encontrarPelicula(vtnPrincipal.getDirIconImg2())));
		vtnPrincipal.getImagen3().addMouseListener(new ClickThumbnail(encontrarPelicula(vtnPrincipal.getDirIconImg3())));

		/*
		 * Añidemos eventos a las 9 pelicula  del panel de abajo, es decir las
		 * ultimas 9 agregadas, aunque solo son 3 label que cambian imagenes
		 */

		
		int nPeliculas = listaPelicula.size();
		
		
		//Creamos los eventos para los label del panel de abajo, cuando se cambien con las flechas tenemos que borrar y agregar otros.
		//Le entregamos en que estados nos encontramos (0 es el inicial)
		actualizarThumbnailUltimoPnl();
		

		vtnPrincipal.getImgFlechaDer().addMouseListener(new ClickFlecha(true));
		vtnPrincipal.getImgFlechaIzq().addMouseListener(new ClickFlecha(false));
	}

	
	private void actualizarThumbnailUltimoPnl() {
		int nPeliculas = listaPelicula.size();
		ClickThumbnail peli12 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-1).getDirThumbnail()));
		ClickThumbnail peli11 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-2).getDirThumbnail()));
		ClickThumbnail peli10 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-3).getDirThumbnail()));
		vtnPrincipal.getImgPF1().addMouseListener(peli12);
		vtnPrincipal.getImgPF2().addMouseListener(peli11);
		vtnPrincipal.getImgPF3().addMouseListener(peli10);
		
		ClickThumbnail peli9 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-4).getDirThumbnail()));
		ClickThumbnail peli8 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-5).getDirThumbnail()));
		ClickThumbnail peli7 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-6).getDirThumbnail()));
		vtnPrincipal.getImgPF4().addMouseListener(peli9);
		vtnPrincipal.getImgPF5().addMouseListener(peli8);
		vtnPrincipal.getImgPF6().addMouseListener(peli7);
		
		ClickThumbnail peli6 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-7).getDirThumbnail()));
		ClickThumbnail peli5 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-8).getDirThumbnail()));
		ClickThumbnail peli4 = new ClickThumbnail(encontrarPelicula(listaPelicula.get(nPeliculas-9).getDirThumbnail()));
		vtnPrincipal.getImgPF7().addMouseListener(peli6);
		vtnPrincipal.getImgPF8().addMouseListener(peli5);
		vtnPrincipal.getImgPF9().addMouseListener(peli4);


	}
	/*
	 * Encontramos el objeto de la pelicula dentro de la lista de peliculas que
	 */
	private Pelicula encontrarPelicula(String dirThumbnailJLabel) {
		for (int i = 0; i < listaPelicula.size(); i++) {

			if (listaPelicula.get(i).getDirThumbnail() == dirThumbnailJLabel) {
				System.out.println("Se encontró la pelicula que tiene el mismo thumbnail que el label");
				return listaPelicula.get(i);
			}
		}

		System.out.println("No se encontró la pelicula que tiene el mismo thumbnail que el label");
		return null;

	}
/*Cambiar imagenes con las flechas*/
	
	
	
	
	public void moverPnlFinal(boolean dir, int estado) {
		int nPeliculas = listaPelicula.size();
		/*Dir derecha = true, izq = false
		 * Tenemos que mover el orden en que se muestran las 9 ultimas peliculas en los
		 * 3 label que cambian imagen con las flechas
		 * Para esto vamos desde atras de la lista para adelante 
		 */
		ImageIcon iconPF1;
		ImageIcon iconPF2;
		ImageIcon iconPF3;
	
		if (dir) {
			switch (estado) {
			case 0: {
				//vtnPrincipal.iniciarPanelFinal(1, listaPelicula);
				/*
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-4).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-5).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-6).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(1);*/
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF4().setVisible(true);
				vtnPrincipal.getImgPF5().setVisible(true);
				vtnPrincipal.getImgPF6().setVisible(true);
				break;
			}
			case 1: {
				/*vtnPrincipal.iniciarPanelFinal(2, listaPelicula);
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-7).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-8).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-9).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(2);*/
				
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF7().setVisible(true);
				vtnPrincipal.getImgPF8().setVisible(true);
				vtnPrincipal.getImgPF9().setVisible(true);
				break;
			}
			case 2: {
				/*vtnPrincipal.iniciarPanelFinal(0, listaPelicula);
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-1).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-2).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-3).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(0);*/
				
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF1().setVisible(true);
				vtnPrincipal.getImgPF2().setVisible(true);
				vtnPrincipal.getImgPF3().setVisible(true);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + estado);
			}

		} else {
			switch (estado) {
			case 0: {/*
				vtnPrincipal.iniciarPanelFinal(0, listaPelicula);
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-1).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-2).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-3).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(0);*/
				
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF1().setVisible(true);
				vtnPrincipal.getImgPF2().setVisible(true);
				vtnPrincipal.getImgPF3().setVisible(true);
				break;
			}
			case 1: {/*
				vtnPrincipal.iniciarPanelFinal(2, listaPelicula);
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-7).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-8).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-9).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(1);*/
				
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF7().setVisible(true);
				vtnPrincipal.getImgPF8().setVisible(true);
				vtnPrincipal.getImgPF9().setVisible(true);
				break;
			}
			case 2: {/*
				vtnPrincipal.iniciarPanelFinal(1, listaPelicula);
				iconPF1 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-4).getDirThumbnail()));
				iconPF2 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-5).getDirThumbnail()));
				iconPF3 = new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas-6).getDirThumbnail()));
				actualizarThumbnailUltimoPnl(2);*/
				
				vtnPrincipal.ocultarPanelFinal();
				vtnPrincipal.getImgPF4().setVisible(true);
				vtnPrincipal.getImgPF5().setVisible(true);
				vtnPrincipal.getImgPF6().setVisible(true);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + estado);
			}
		}/*
		vtnPrincipal.getImgPF1().setIcon(iconPF1);
		vtnPrincipal.getImgPF2().setIcon(iconPF2);
		vtnPrincipal.getImgPF3().setIcon(iconPF3);*/
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
							/*
							 * Podemos ir cambiando la imagen de los labes mientras sucede la animación, así
							 * solo usamos 2 label
							 */

							/* Aquí irian las peliculos mas populares */
							/*
							 * çImageIcon icon1 = new ImageIcon(getClass().getResource("/recursos/1.png"));
							 */

							/*
							 * Tomamos las thumbnail de la lista de peliculas y se le asignamos a los
							 * thumnails y iconos de los label
							 */

			
							
							//ImageIcon l = new ImageIcon(getClass().getResource(listaPelicula.get(0).getDirThumbnail()));
						
								

							//vtnPrincipal.getImagen1().setIcon(l);
							
							
							
							//vtnPrincipal.getImagen1().setDirThumbnail(listaPelicula.get(0).getDirThumbnail());
							// vtnPrincipal.getImagen1().setIcon(getClass().getResource());

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

							/*ImageIcon icon2 = new ImageIcon(getClass().getResource("/recursos/2.png"));
							vtnPrincipal.getImagen2().setIcon(icon2);*/
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
							/*ImageIcon icon3 = new ImageIcon(getClass().getResource("/recursos/3.png"));
							vtnPrincipal.getImagen3().setIcon(icon3);*/

							Thread.sleep(6000); // 6 segundos para que empiece cuando el otro termina

							/*
							 * empieza, termina, delay, pixelincrement, jlabel a mover movemos desde el x de
							 * imagen a -400 (fuera de la pantalla), delay en minisegundos 20,
							 * pixelincrement (divides 400 (donde la dejas) por un numero cualquiera que de
							 * par) EJ: 400/5=80, entonces el delay * 80 = 1600 milisguendos en realizar la
							 * animacion
							 */

							vtnPrincipal.getAC().jLabelXRight(200, 800, 20, 5, vtnPrincipal.getImagen3());
							vtnPrincipal.getAC().jLabelXRight(-400, 200, 20, 5, vtnPrincipal.getImagen2());

							contador = 3; // Cambiamos cuando termina la animacion
							break;
						}
						case 3: {
							/*ImageIcon icon2 = new ImageIcon(getClass().getResource("/recursos/2.png"));
							vtnPrincipal.getImagen1().setIcon(icon2);*/

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

	public class ClickFlecha implements MouseListener {
		boolean dir;

		// true derecha, false izq
		ClickFlecha(boolean d) {
			this.dir = d;
		}

		public void mouseClicked(MouseEvent e) {
			moverPnlFinal(dir, contFlecha);
			if (dir) {
				if (contFlecha == 2) {
					contFlecha = 0;
				} else {
					contFlecha++;
				}

			} else {
				if (contFlecha == 0) {
					contFlecha = 2;
				} else {
					contFlecha--;
				}
			}
			
			vtnPrincipal.getFrame().repaint();

		}

		public void mouseEntered(MouseEvent e) {
			// l.setText("Mouse Entered");
		}

		public void mouseExited(MouseEvent e) {
			// l.setText("Mouse Exited");
		}

		public void mousePressed(MouseEvent e) {
			// l.setText("Mouse Pressed");
		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	// Le entregamos la pelicula a reproducir
	public class ClickThumbnail implements MouseListener {
		Pelicula peliRepro;

		ClickThumbnail(Pelicula pSelec) {
			this.peliRepro = pSelec;
		}

		public void mouseClicked(MouseEvent e) {

			vtnPrincipal.getFrame().setVisible(false);
			Main.setPeliRepro(peliRepro);
			modelo.Main.reproducir(null);
			;

		}

		public void mouseEntered(MouseEvent e) {
			// l.setText("Mouse Entered");
		}

		public void mouseExited(MouseEvent e) {
			// l.setText("Mouse Exited");
		}

		public void mousePressed(MouseEvent e) {
			// l.setText("Mouse Pressed");
		}

		public void mouseReleased(MouseEvent e) {

		}
	}
}
