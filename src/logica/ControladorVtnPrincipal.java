package logica;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modelo.Main;
import modelo.Multimedia;


import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


/**
 * Initializable is used when you want to interact with stuff injected
 * with @FXML. During construction those variables aren't filled so you can't
 * interact with them so JavaFX will call initializable after everything is set
 * up.
 */
public class ControladorVtnPrincipal implements Initializable {

	// The main container of the application that holds everything.
	@FXML
	private ArrayList<Multimedia> listaMultimedia = new ArrayList<>();
	/*private ArrayList<Pelicula> listaPelicula = new ArrayList<>();
	private VistaVtnPrincipal vtnPrincipal;*/
	private int contFlecha = 0;
	private int algo;

	@FXML
	private ImageView imagen1;
	@FXML
	private ImageView imagen2;
	@FXML
	private ImageView imagen3;
	@FXML
	private ImageView logo;

	@FXML
	private ImageView viewN1;
	@FXML
	private ImageView viewN2;
	@FXML
	private ImageView viewN3;

	@FXML
	private ImageView fizq;
	@FXML
	private ImageView fder;
	@FXML
	private ImageView lupa;

	@FXML
	private Pane panel3;

	@FXML
	private Pane panel;

	@FXML
	private TextField busqueda;

	private Multimedia multimediaSeleccionada;


	@Override

	// fx:controller="logica.ControladorVtnTest1"
	public void initialize(URL url, ResourceBundle resourceBundle) {

		try {
			// cargarContenido();
			cargarContenido2();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		int tamañoLista = listaMultimedia.size();
		System.out.println(tamañoLista);

		// System.out.println(listaMultimedia.get(0).getDirThumbnail());
		// Imagenes desde la 3ra a la 1ra, ya que las imagenview estan unas sobre otras
		// la 3ra es la primera que se ve.
		Image img = new Image(listaMultimedia.get(2).getThumbnail().getUrl(), imagen1.getFitWidth(),
				imagen1.getFitHeight(), false, false);

		Image img2 = new Image(listaMultimedia.get(1).getThumbnail().getUrl(), imagen2.getFitWidth(),
				imagen2.getFitHeight(), false, false);
		Image img3 = new Image(listaMultimedia.get(0).getThumbnail().getUrl(), imagen3.getFitWidth(),
				imagen3.getFitHeight(), false, false);
		Image imgLogo = new Image(getClass().getResource("/recursos/logo.png").toString(), logo.getFitWidth(),
				logo.getFitHeight(), false, false);

		Image imgN = new Image(listaMultimedia.get(tamañoLista - 1).getThumbnail().getUrl(), viewN1.getFitWidth(),
				viewN1.getFitHeight(), false, false);
		Image imgN2 = new Image(listaMultimedia.get(tamañoLista - 2).getThumbnail().getUrl(), viewN2.getFitWidth(),
				viewN2.getFitHeight(), false, false);
		Image imgN3 = new Image(listaMultimedia.get(tamañoLista - 3).getThumbnail().getUrl(), viewN3.getFitWidth(),
				viewN3.getFitHeight(), false, false);

		Image imgfizq = new Image(getClass().getResource("/recursos/flechaizq.png").toString(), fizq.getFitWidth(),
				fizq.getFitHeight(), false, false);
		Image imgfder = new Image(getClass().getResource("/recursos/flechader.png").toString(), fder.getFitWidth(),
				fder.getFitHeight(), false, false);

		Image imglupa = new Image(getClass().getResource("/recursos/buscar.png").toString(), lupa.getFitWidth(),
				lupa.getFitHeight(), false, false);

		imagen1.setImage(img);

		imagen1.fitWidthProperty().bind(panel3.widthProperty());
		imagen1.fitHeightProperty().bind(panel3.heightProperty());

		imagen3.setImage(img3);
		imagen3.fitWidthProperty().bind(panel3.widthProperty());
		imagen3.fitHeightProperty().bind(panel3.heightProperty());

		imagen2.setImage(img2);
		imagen2.fitWidthProperty().bind(panel3.widthProperty());
		imagen2.fitHeightProperty().bind(panel3.heightProperty());

		fizq.setImage(imgfizq);
		fder.setImage(imgfder);

		viewN1.setImage(imgN);
		viewN2.setImage(imgN2);
		viewN3.setImage(imgN3);

		logo.setImage(imgLogo);
		lupa.setImage(imglupa);

		panel3.setOnMouseClicked(new iniciarReproduccion2(0));

		fder.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				movImgFinal(true, contFlecha);

			}
		});

		fizq.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				movImgFinal(false, contFlecha);

			}
		});

		lupa.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.println(busqueda.getText());
				String buscador = busqueda.getText();

				// Enabled
				busqueda.setMouseTransparent(true);

				if (buscador.equals("")) {
					// cajaTexto1.setEnabled(true);
				} else {

					try {

						boolean existe = barra_busqueda(buscador);
						if (existe) {

							System.out.println("ENCONTRADOOO");
							Main.setMultiRepro(encontrarMultiTitulo(buscador));

							// Usamos el metodo del evento iniciarReproduccion que nos camia la ventana
							new iniciarReproduccion2(0).cambiarVentana();

							// Como funcionaba antes
							// VistaVtnBusqueda frame2 = new VistaVtnBusqueda(buscador);

							// frame.dispose();
							// frame.setVisible(false);

						} else {
							// Mensaje de error
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setTitle("Aviso");
							alert.setContentText("No se encontraron resultados");
							alert.showAndWait();
						}
						busqueda.setMouseTransparent(false);

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		// System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA "+viewN1.getImage().getUrl()+
		// " EEEEEEEEEEEEEEEEEEEEEEE "+ listaMultimedia.get(0).getThumbnail().getUrl());
		viewN1.setOnMouseClicked(new iniciarReproduccion2(viewN1.getImage(), 1));
		viewN2.setOnMouseClicked(new iniciarReproduccion2(viewN2.getImage(), 1));
		viewN3.setOnMouseClicked(new iniciarReproduccion2(viewN3.getImage(), 1));
		animacion();

	}

	private void animacion() {
		/*
		 * panel1.setVisible(true); panel2.setVisible(true); panel3.setVisible(true);
		 */
		/*
		 * panel1.setMouseTransparent(false); panel1.set
		 * panel2.setMouseTransparent(false); panel3.setMouseTransparent(false);
		 */
		multimediaSeleccionada = listaMultimedia.get(0);
		FadeTransition e;

		e = new FadeTransition(Duration.seconds(3), imagen3);
		e.setFromValue(1);
		e.setToValue(0);
		e.play();

		e.setOnFinished(event1 -> {
			System.out.println("lala");
			multimediaSeleccionada = listaMultimedia.get(1);
			// panel.set
			// panel3.setVisible(false);
			// panel3.setMouseTransparent(true);
			FadeTransition e1 = new FadeTransition(Duration.seconds(3), imagen2);
			e1.setFromValue(1);
			e1.setToValue(0);
			e1.play();

			e1.setOnFinished(event2 -> {
				System.out.println("lele");
				multimediaSeleccionada = listaMultimedia.get(2);
				// panel2.setVisible(false);
				// panel2.setMouseTransparent(true);
				FadeTransition e2 = new FadeTransition(Duration.seconds(3), imagen1);
				e2.setFromValue(1);
				e2.setToValue(0);
				e2.play();

				e2.setOnFinished(event3 -> {
					System.out.println("lili");
					// panel1.setVisible(false);
					// panel1.setMouseTransparent(true);

					animacion();

				});

			});

		});
	}

	private void movImgFinal(boolean dir, int estado) {

		/*
		 * Dir derecha = true, izq = false Tenemos que mover el orden en que se muestran
		 * las 9 ultimas peliculas en los 3 label que cambian imagen con las flechas
		 * Para esto vamos desde atras de la lista para adelante
		 */

		if (dir) {
			switch (estado) {
			case 0: {
				/*
				 * viewN1.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 4).getDirThumbnail()).toString(), viewN1.getFitWidth(),
				 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 5).getDirThumbnail()).toString(), viewN2.getFitWidth(),
				 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 6).getDirThumbnail()).toString(), viewN3.getFitWidth(),
				 * viewN3.getFitHeight(), false, false));
				 */

				setViewN(4);
				contFlecha++;

				break;
			}
			case 1: {
				/*
				 * viewN1.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 7).getDirThumbnail()).toString(), viewN1.getFitWidth(),
				 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 8).getDirThumbnail()).toString(), viewN2.getFitWidth(),
				 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 9).getDirThumbnail()).toString(), viewN3.getFitWidth(),
				 * viewN3.getFitHeight(), false, false));
				 */
				setViewN(7);
				contFlecha++;
				break;
			}
			case 2: {
				/*
				 * viewN1.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 1).getDirThumbnail()).toString(), viewN1.getFitWidth(),
				 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 2).getDirThumbnail()).toString(), viewN2.getFitWidth(),
				 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 3).getDirThumbnail()).toString(), viewN3.getFitWidth(),
				 * viewN3.getFitHeight(), false, false));
				 */

				setViewN(1);
				contFlecha = 0;

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + estado);
			}

		} else {
			switch (estado) {
			case 0: {/*
						 * viewN1.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 7).getDirThumbnail()).toString(), viewN1.getFitWidth(),
						 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 8).getDirThumbnail()).toString(), viewN2.getFitWidth(),
						 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 9).getDirThumbnail()).toString(), viewN3.getFitWidth(),
						 * viewN3.getFitHeight(), false, false));
						 */
				setViewN(7);
				contFlecha++;

				break;
			}
			case 1: {
				/*
				 * viewN1.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 4).getDirThumbnail()).toString(), viewN1.getFitWidth(),
				 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 5).getDirThumbnail()).toString(), viewN2.getFitWidth(),
				 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
				 * getClass().getResource(listaPelicula.get(nPeliculas -
				 * 6).getDirThumbnail()).toString(), viewN3.getFitWidth(),
				 * viewN3.getFitHeight(), false, false));
				 */
				setViewN(4);

				contFlecha++;

				break;
			}
			case 2: {/*
						 * 
						 * viewN1.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 1).getDirThumbnail()).toString(), viewN1.getFitWidth(),
						 * viewN1.getFitHeight(), false, false)); viewN2.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 2).getDirThumbnail()).toString(), viewN2.getFitWidth(),
						 * viewN2.getFitHeight(), false, false)); viewN3.setImage(new Image(
						 * getClass().getResource(listaPelicula.get(nPeliculas -
						 * 3).getDirThumbnail()).toString(), viewN3.getFitWidth(),
						 * viewN3.getFitHeight(), false, false));
						 */
				setViewN(1);
				contFlecha = 0;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + estado);
			}
		}
		viewN1.setOnMouseClicked(new iniciarReproduccion2(viewN1.getImage(), 1));
		viewN2.setOnMouseClicked(new iniciarReproduccion2(viewN2.getImage(), 1));
		viewN3.setOnMouseClicked(new iniciarReproduccion2(viewN3.getImage(), 1));

	}
	// Cambiamos las imagenes que muestra el panel de abajo, entramos un numero para
	// saber a que forma las cambiamos, mas que nada para ahorra codigo

	private void setViewN(int num) {

		viewN1.setImage(
				new Image(listaMultimedia.get(listaMultimedia.size() - (num)).getThumbnail().getUrl().toString(),
						viewN1.getFitWidth(), viewN1.getFitHeight(), false, false));
		viewN2.setImage(
				new Image(listaMultimedia.get(listaMultimedia.size() - (num + 1)).getThumbnail().getUrl().toString(),
						viewN2.getFitWidth(), viewN2.getFitHeight(), false, false));
		viewN3.setImage(
				new Image(listaMultimedia.get(listaMultimedia.size() - (num + 2)).getThumbnail().getUrl().toString(),
						viewN3.getFitWidth(), viewN3.getFitHeight(), false, false));

	}

	private void cargarContenido2() throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0;

		String datos[] = new String[numLineas];
		
		BufferedReader reader = new BufferedReader(new FileReader("multimedia.txt"));
        linea = reader.readLine();

		/*BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/recursos/multimedia.txt")));
		linea = reader.readLine();*/

		String titulo;
		Image thumbnail;
		String genero;
		String file;

		while (linea != null && contador < numLineas) {

			datos[contador] = linea;

			StringTokenizer st = new StringTokenizer(datos[contador]);
			System.out.println("Pelicula Nº" + (contador + 1) + "\n");

			for (int i = 0; i < st.countTokens(); i++) {

				titulo = st.nextToken().toString();
				System.out.println(titulo);
				thumbnail = new Image(st.nextToken().toString());
				System.out.println(thumbnail);
				genero = st.nextToken().toString();
				System.out.println(genero);
				file = new String(st.nextToken().toString());
				System.out.println(file);

				Multimedia multiCargada = new Multimedia(titulo, thumbnail, genero, file);
				System.out.println("Thumbnail objeto: " + multiCargada.getThumbnail());

				listaMultimedia.add(multiCargada);

			}

			System.out.println("");

			contador++;
			linea = reader.readLine();
		}

		reader.close();

	}

	/*
	 * // Cargamos contenido desde el txt private void cargarContenido() throws
	 * FileNotFoundException, IOException {
	 * 
	 * String linea; int numLineas = 300, contador = 0;
	 * 
	 * String datos[] = new String[numLineas];
	 * 
	 * BufferedReader reader = new BufferedReader( new
	 * InputStreamReader(getClass().getResourceAsStream("/recursos/multimedia.txt"))
	 * ); linea = reader.readLine();
	 * 
	 * String titulo; ImageIcon thumbnail; String genero; String file;
	 * 
	 * while (linea != null && contador < numLineas) {
	 * 
	 * datos[contador] = linea;
	 * 
	 * StringTokenizer st = new StringTokenizer(datos[contador]);
	 * System.out.println("Pelicula Nº" + (contador + 1) + "\n");
	 * 
	 * for (int i = 0; i < st.countTokens(); i++) {
	 * 
	 * titulo = st.nextToken().toString(); System.out.println(titulo); thumbnail =
	 * new ImageIcon(st.nextToken().toString()); System.out.println(thumbnail);
	 * genero = st.nextToken().toString(); System.out.println(genero); file = new
	 * String(st.nextToken().toString()); System.out.println(file);
	 * 
	 * Pelicula peliculaCar = new Pelicula(titulo, thumbnail, genero, file);
	 * System.out.println("Thumbnail objeto: " + peliculaCar.getThumbnail());
	 * 
	 * listaPelicula.add(peliculaCar);
	 * 
	 * }
	 * 
	 * System.out.println("");
	 * 
	 * contador++; linea = reader.readLine(); }
	 * 
	 * reader.close();
	 * 
	 * }
	 */

	// Buscar con lo que se escribio en la barra
	private boolean barra_busqueda(String palabra) throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0, existe_codigo = 0;

		String datos[] = new String[numLineas];
		// PARA QUE TE LOS LEA EN EL JAR
		BufferedReader reader = new BufferedReader(new FileReader("multimedia.txt"));
        linea = reader.readLine();
		
		/*BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/recursos/multimedia.txt")));
		linea = reader.readLine();*/

        palabra=palabra.toLowerCase();// convierte palabra a letras minusculas

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

	/*
	 * Encontramos el objeto de la pelicula dentro de la lista de peliculas que:
	 * Tiene el mismo titulo
	 */
	private Multimedia encontrarMultiTitulo(String tituloBuscado) {
		tituloBuscado=tituloBuscado.toLowerCase();
		for (int i = 0; i < listaMultimedia.size(); i++) {

			if (listaMultimedia.get(i).getTitulo().equals(tituloBuscado)) {
				System.out.println("Se encontró la pelicula que tiene el mismo tituloBuscado que el buscado");
				return listaMultimedia.get(i);
			}
		}

		System.out.println("No se encontró la pelicula que tiene el mismo tituloBuscado que el buscado");
		return null;

	}

	/*
	 * Encontramos el objeto de la pelicula dentro de la lista de peliculas que
	 */
	private Multimedia encontrarMultimediaThumbnail(Image thumbnailAEncontrar) {
		for (int i = 0; i < listaMultimedia.size(); i++) {

			if (listaMultimedia.get(i).getThumbnail().getUrl().equals(thumbnailAEncontrar.getUrl())) {
				System.out.println("Se encontró la pelicula que tiene el mismo thumbnail que el imageView");
				return listaMultimedia.get(i);
			}
		}

		System.out.println("No se encontró la pelicula que tiene el mismo thumbnail que el imageView");
		return null;

	}
	/*
	 * private class iniciarReproduccion implements EventHandler<Event> {
	 * 
	 * @Override public void handle(Event arg0) {
	 * Main.setPeliRepro(peliculaSeleccionada); cambiarVentana();
	 * 
	 * }
	 * 
	 * private void cambiarVentana() { Stage repro = new Stage();
	 * 
	 * try { Scene test = new
	 * Scene(FXMLLoader.load(getClass().getClassLoader().getResource(
	 * "modelo/orden.fxml")), 900, 500); repro.setScene(test); } catch (IOException
	 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } // Scene
	 * primeraScena = new //
	 * Scene((FXMLLoader.load(getClass().getResource("orden.fxml")) , 900, 500);
	 * 
	 * repro.show(); Stage s = (Stage) imagen1.getScene().getWindow(); s.hide(); }
	 * 
	 * }
	 */

	// Reproduccion al pinchar una thumbnail de abajo
	private class iniciarReproduccion2 implements EventHandler<Event> {
		Image thumbnail;
		int version;

		// version = 0 panel unico que cambia las imagenes que desaparecen y lupa (no
		// tienen thumnail), 1 los de abajo y que sirven en general para todos.
		public iniciarReproduccion2(Image thumbnail, int version) {
			this.thumbnail = thumbnail;
			this.version = version;
		}

		public iniciarReproduccion2(int version) {
			this.version = version;
		}

		@Override
		public void handle(Event arg0) {
			if (version == 0) {
				Main.setMultiRepro(multimediaSeleccionada);
				cambiarVentana();
			} else {
				Main.setMultiRepro(encontrarMultimediaThumbnail(thumbnail));
				System.out.println("SE ENCONTRO A " + encontrarMultimediaThumbnail(thumbnail));
				cambiarVentana();
			}

		}

		private void cambiarVentana() {
			Stage repro = new Stage();

			try {
				Scene test = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Vistas/VistaVtnReproductor.fxml")),
						900, 500);
				repro.setScene(test);
				repro.initStyle(StageStyle.UNDECORATED);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Scene primeraScena = new
			// Scene((FXMLLoader.load(getClass().getResource("orden.fxml")) , 900, 500);

			repro.show();
			Stage s = (Stage) imagen1.getScene().getWindow();
			s.hide();
		}
	}
}
