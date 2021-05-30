package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppPackage.AnimationClass;
//import AppPackage.AnimationClass;
//import ReferencedAnimationClass;
import modelo.Main;
import modelo.Pelicula;

public class VistaVtnPrincipal extends JFrame {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton button;

	// Labels y los respectivos directorios del Slideshow
	JLabel imagen1;
	JLabel imagen2;
	JLabel imagen3;

	String dirIconImg1;
	String dirIconImg2;
	String dirIconImg3;

	// Labels, iconos y directorios del PanelFinal
	JLabel imgPF1;
	JLabel imgPF2;
	JLabel imgPF3;

	JLabel imgPF4;
	JLabel imgPF5;
	JLabel imgPF6;

	JLabel imgPF7;
	JLabel imgPF8;
	JLabel imgPF9;
	// Labels flechas
	JLabel imgFlechaDer;
	JLabel imgFlechaIzq;

	JLabel imagenLogo;
	JButton botonBuscar;
	// AnimationClass para el Slideshow
	AnimationClass AC = new AnimationClass();
	JTextField cajaTexto1;
	JButton logo;
	JButton buscar;
	String buscador="";

	// Label para indicar cosas
	JLabel loMasVisto;
	JLabel loMasNuevo;

	public VistaVtnPrincipal() {
		initcomponents();

		panel.setLayout(null);

		frame.add(panel);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);

		frame.setVisible(true);

		panel.add(imagen1);
		panel.add(imagen2);
		panel.add(imagen3);
		panel.add(imagenLogo);
		// Iniciamos imagenes para el slideshow

		panel.add(imgPF1);
		panel.add(imgPF2);
		panel.add(imgPF3);

		panel.add(imgPF4);
		panel.add(imgPF5);
		panel.add(imgPF6);
		panel.add(imgPF7);
		panel.add(imgPF8);
		panel.add(imgPF9);

		imgPF4.setVisible(false);
		imgPF5.setVisible(false);
		imgPF6.setVisible(false);
		imgPF7.setVisible(false);
		imgPF8.setVisible(false);
		imgPF9.setVisible(false);

		panel.add(imgFlechaDer);
		panel.add(imgFlechaIzq);

		panel.add(loMasNuevo);
		panel.add(loMasVisto);
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
		imgPF4 = new JLabel();
		imgPF5 = new JLabel();
		imgPF6 = new JLabel();
		imgPF7 = new JLabel();
		imgPF8 = new JLabel();
		imgPF9 = new JLabel();

		imgFlechaDer = new JLabel();
		imgFlechaIzq = new JLabel();

		loMasNuevo = new JLabel();
		loMasVisto = new JLabel();

		CajaTextos();
		botones();
		iniciarLetras();
	}

	private void botones() {

		buscar = new JButton();
		buscar.setBounds(740, 10, 30, 30);
		buscar.setVisible(true);
		buscar.setBackground(Color.WHITE);
		Image Foto = new ImageIcon(getClass().getResource("/recursos/buscar.png")).getImage();
		Image newimg = Foto.getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(newimg);
		buscar.setIcon(imageIcon);
		panel.add(buscar);

		logo = new JButton();
		logo.setBounds(0, 0, 80, 50);
		logo.setVisible(true);
		logo.setBackground(Color.WHITE);
		Image Foto2 = new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage();
		Image newimg2 = Foto2.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(newimg2);
		logo.setIcon(imageIcon2);
		panel.add(logo);

		ActionListener oyentedeaccion1 = new ActionListener() {

			@SuppressWarnings("null")

			public void actionPerformed(ActionEvent ae) {

				buscador = cajaTexto1.getText();
				cajaTexto1.setEnabled(false);

				if (cajaTexto1.equals("")) {
					// cajaTexto1.setEnabled(true);
				} else {

					try {

						boolean palabra = barra_busqueda(buscador);
						if (palabra == true) {

							System.out.println("ENCONTRADOOO");
							
							VistaVtnBusqueda frame2 = new VistaVtnBusqueda(buscador);
							frame.dispose();
							//frame.setVisible(false);
							
							

						}
						cajaTexto1.setEnabled(true);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};
		buscar.addActionListener(oyentedeaccion1);

		ActionListener oyentedeaccion2 = new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				Main.loginAceptado();
				frame.dispose();
				//frame.setVisible(false);

			}
		};
		logo.addActionListener(oyentedeaccion2);

	}

	private void CajaTextos() {

		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(590, 10, 150, 30);
		panel.add(cajaTexto1);

		ActionListener oyentedeaccion1 = new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

			}
		};
		cajaTexto1.addActionListener(oyentedeaccion1);

	}

	private boolean barra_busqueda(String palabra) throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0, existe_codigo = 0;

		String datos[] = new String[numLineas];
		//PARA QUE TE LOS LEA EN EL JAR
		BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/recursos/multimedia.txt")));
		linea = reader.readLine();

		palabra = palabra.toLowerCase(); // convierte palabra a letras minusculas

		while (linea != null && contador < numLineas) {

			datos[contador] = linea;
			linea = reader.readLine();

			int cont = 0;
			StringTokenizer st = new StringTokenizer(datos[contador]);

			while (st.hasMoreTokens()) {

				String array = st.nextToken();
				cont = cont + 1;

				if (cont == 1) {

					if (array.equals(palabra)) {

						existe_codigo = 1;
						return true;
					}
				}
			}

			contador++;
		}

		if (existe_codigo == 0) {
			return false;
		}
		reader.close();
		return false;

	}

	private void iniciarLetras() {
		loMasNuevo.setBounds(350, 80, 500, 500);
		loMasNuevo.setText("Lo más nuevo");
		loMasNuevo.resize(500, 500);

		loMasVisto.setBounds(350, -200, 500, 500);
		loMasVisto.setText("Lo más visto");
		loMasVisto.resize(500, 500);
	}

	public void iniciarImagenes(ArrayList<Pelicula> listaPelicula) {

		// Logo
		imagenLogo.setBounds(15, 0, 50, 50);
		Image ilogo = new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage();
		imagenLogo.setIcon(new ImageIcon(
				ilogo.getScaledInstance(imagenLogo.getWidth(), imagenLogo.getHeight(), Image.SCALE_SMOOTH)));

		// 3 Label del Slideshow, las mas populares

		imagen1.setBounds(200, 60, 400, 222);
		imagen2.setBounds(800, 60, 400, 222);
		imagen3.setBounds(800, 60, 400, 222);

		// Por ahora seran las primeras 3 que se subieron

		dirIconImg1 = listaPelicula.get(0).getDirThumbnail();
		dirIconImg2 = listaPelicula.get(1).getDirThumbnail();
		dirIconImg3 = listaPelicula.get(2).getDirThumbnail();

		imagen1.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(0).getDirThumbnail())));
		imagen2.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(1).getDirThumbnail())));
		imagen3.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(2).getDirThumbnail())));

		// Flechas

		imgFlechaDer.setBounds(700, 400, 50, 50);
		Image iFlechaDer = new ImageIcon(getClass().getResource("/recursos/flechader.png")).getImage();
		imgFlechaDer.setIcon(new ImageIcon(
				iFlechaDer.getScaledInstance(imgFlechaDer.getWidth(), imgFlechaDer.getHeight(), Image.SCALE_SMOOTH)));

		imgFlechaIzq.setBounds(25, 400, 50, 50);
		Image iFlechaIzq = new ImageIcon(getClass().getResource("/recursos/flechaizq.png")).getImage();
		imgFlechaIzq.setIcon(new ImageIcon(
				iFlechaIzq.getScaledInstance(imgFlechaIzq.getWidth(), imgFlechaIzq.getHeight(), Image.SCALE_SMOOTH)));

	}

//Lo iniciamos y borramos para poder entregarlo los nuevos eventos
	public void iniciarPanelFinal(int estado, ArrayList<Pelicula> listaPelicula) {

		// Panel Final
		int nPeliculas = listaPelicula.size();
		System.out.println("peliculas numero: " + nPeliculas);
		imgPF1.setBounds(100, 340, 170, 200);
		// Le aumentamos la posición en x por el ancho de la imagen: 240+10.... mejor
		// 200
		imgPF2.setBounds(300, 340, 170, 200);
		imgPF3.setBounds(500, 340, 170, 200);
		imgPF4.setBounds(100, 340, 170, 200);
		imgPF5.setBounds(300, 340, 170, 200);
		imgPF6.setBounds(500, 340, 170, 200);
		imgPF7.setBounds(100, 340, 170, 200);
		imgPF8.setBounds(300, 340, 170, 200);
		imgPF9.setBounds(500, 340, 170, 200);

		imgPF1.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 1).getDirThumbnail())));

		imgPF2.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 2).getDirThumbnail())));

		imgPF3.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 3).getDirThumbnail())));

		imgPF4.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 4).getDirThumbnail())));

		imgPF5.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 5).getDirThumbnail())));

		imgPF6.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 6).getDirThumbnail())));

		imgPF7.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 7).getDirThumbnail())));

		imgPF8.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 8).getDirThumbnail())));

		imgPF9.setIcon(new ImageIcon(getClass().getResource(listaPelicula.get(nPeliculas - 9).getDirThumbnail())));
		// int x, int y, width, height

	}

	public void ocultarPanelFinal() {
		imgPF1.setVisible(false);
		imgPF2.setVisible(false);
		imgPF3.setVisible(false);
		imgPF4.setVisible(false);
		imgPF5.setVisible(false);
		imgPF6.setVisible(false);
		imgPF7.setVisible(false);
		imgPF8.setVisible(false);
		imgPF9.setVisible(false);
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

	public String getDirIconImg1() {
		return dirIconImg1;
	}

	public void setDirIconImg1(String dirIconImg1) {
		this.dirIconImg1 = dirIconImg1;
	}

	public String getDirIconImg2() {
		return dirIconImg2;
	}

	public void setDirIconImg2(String dirIconImg2) {
		this.dirIconImg2 = dirIconImg2;
	}

	public String getDirIconImg3() {
		return dirIconImg3;
	}

	public void setDirIconImg3(String dirIconImg3) {
		this.dirIconImg3 = dirIconImg3;
	}

	public JLabel getImgPF1() {
		return imgPF1;
	}

	public void setImgPF1(JLabel imgPF1) {
		this.imgPF1 = imgPF1;
	}

	public JLabel getImgPF2() {
		return imgPF2;
	}

	public void setImgPF2(JLabel imgPF2) {
		this.imgPF2 = imgPF2;
	}

	public JLabel getImgPF3() {
		return imgPF3;
	}

	public void setImgPF3(JLabel imgPF3) {
		this.imgPF3 = imgPF3;
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

	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}

	public void setCajaTexto1(JTextField cajaTexto1) {
		this.cajaTexto1 = cajaTexto1;
	}

	public JButton getLogo() {
		return logo;
	}

	public void setLogo(JButton logo) {
		this.logo = logo;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JLabel getImgPF4() {
		return imgPF4;
	}

	public void setImgPF4(JLabel imgPF4) {
		this.imgPF4 = imgPF4;
	}

	public JLabel getImgPF5() {
		return imgPF5;
	}

	public void setImgPF5(JLabel imgPF5) {
		this.imgPF5 = imgPF5;
	}

	public JLabel getImgPF6() {
		return imgPF6;
	}

	public void setImgPF6(JLabel imgPF6) {
		this.imgPF6 = imgPF6;
	}

	public JLabel getImgPF7() {
		return imgPF7;
	}

	public void setImgPF7(JLabel imgPF7) {
		this.imgPF7 = imgPF7;
	}

	public JLabel getImgPF8() {
		return imgPF8;
	}

	public void setImgPF8(JLabel imgPF8) {
		this.imgPF8 = imgPF8;
	}

	public JLabel getImgPF9() {
		return imgPF9;
	}

	public void setImgPF9(JLabel imgPF9) {
		this.imgPF9 = imgPF9;
	}

	public JLabel getLoMasVisto() {
		return loMasVisto;
	}

	public void setLoMasVisto(JLabel loMasVisto) {
		this.loMasVisto = loMasVisto;
	}

	public JLabel getLoMasNuevo() {
		return loMasNuevo;
	}

	public void setLoMasNuevo(JLabel loMasNuevo) {
		this.loMasNuevo = loMasNuevo;
	}

}