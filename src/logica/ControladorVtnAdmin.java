package logica;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.BufferedReader;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modelo.Main;

/**
 * Initializable is used when you want to interact with stuff injected
 * with @FXML. During construction those variables aren't filled so you can't
 * interact with them so JavaFX will call initializable after everything is set
 * up.
 */
public class ControladorVtnAdmin implements Initializable {

	int nivel = 0, vuelta = 0;
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

	@FXML
	private Pane panelFondo;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Pane panelSuperior;

	@FXML
	private Pane panelFormulario;

	@FXML
	private Button vistaUsuario;

	@FXML
	private Button guardar;

	@FXML
	private Label labelUsuario;

	@FXML
	private Label labelContraseña;

	@FXML
	private Label labelFormulario;

	@FXML
	private Label tituloUsuarioE;

	@FXML
	private Label labelTitulo;

	@FXML
	private Label labelEliContenido;

	@FXML
	private TextField tituloPel;

	@FXML
	private TextField cajaEliContenido;

	@FXML
	private TextField datoCorreo;

	@FXML
	private TextField cajaEliminar;

	@FXML
	private TextField datoClave;

	@FXML
	private TextField cajaArchivo;

	@FXML
	private TextField cajaImagen;

	@FXML
	private CheckBox soyAdmin;

	@FXML
	private Button botonAgregarUsuario;

	@FXML
	private Button botonEliminarUsuario;

	@FXML
	private Button botonMostrarTabla;

	@FXML
	private Button botonEliminarContenido;

	@FXML
	private Button botonAgregarContenido;

	@FXML
	private Button selArchivo;

	@FXML
	private Button selPortada;

	@FXML
	private TextArea listaUsuarios;

	@FXML
	private ComboBox<String> comboCategoria;

	ObservableList<String> list;

	String correo;
	String contenido;
	String clave;
	String direccion;
	String nombreImagen;
	String tipo;
	String juntar = "";
	int contadorBoton = 0;
	File selectedFile;
	File selectedImagen;
	long bytes = 0;

	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	ArrayList<String> tabla = new ArrayList<String>(300);

	Logger LOGGER = Logger.getAnonymousLogger();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		panelFormulario.setVisible(false);
		list = FXCollections.observableArrayList("Accion", "Terror", "Documental", "Otros");
		comboCategoria.setItems(list);
		// comboCategoria.getItems().addAll("opcion1", "opcion2");
	}

	public void IrAVistaUsuario() {
		cambiarVentana();
	}

	public void agregarUsuario() {
		contadorBoton = 1;
		labelFormulario.setText("Formulario para Agregar Usuarios");
		listaUsuarios.setVisible(false);
		panelFormulario.setVisible(true);
		datoCorreo.setVisible(true);
		datoClave.setVisible(true);
		labelUsuario.setVisible(true);
		labelContraseña.setVisible(true);
		soyAdmin.setVisible(true);
		labelFormulario.setVisible(true);
		guardar.setVisible(true);

		comboCategoria.setVisible(false);
		cajaEliminar.setVisible(false);
		tituloUsuarioE.setVisible(false);
		selArchivo.setVisible(false);
		cajaArchivo.setVisible(false);
		tituloPel.setVisible(false);
		labelTitulo.setVisible(false);
		selPortada.setVisible(false);
		cajaImagen.setVisible(false);
		cajaEliContenido.setVisible(false);
		labelEliContenido.setVisible(false);
	}

	public void agregarContenido() {
		contadorBoton = 2;
		labelFormulario.setText("Formulario para Agregar Contenido");
		listaUsuarios.setVisible(false);
		panelFormulario.setVisible(true);
		selArchivo.setVisible(true);
		cajaArchivo.setVisible(true);

		datoCorreo.setVisible(false);
		datoClave.setVisible(false);
		labelUsuario.setVisible(false);
		labelContraseña.setVisible(false);
		soyAdmin.setVisible(false);
		cajaEliContenido.setVisible(false);
		labelEliContenido.setVisible(false);
		cajaEliminar.setVisible(false);
		tituloUsuarioE.setVisible(false);

		guardar.setVisible(true);
		labelFormulario.setVisible(true);
		tituloPel.setVisible(true);
		labelTitulo.setVisible(true);
		selPortada.setVisible(true);
		cajaImagen.setVisible(true);
		comboCategoria.setVisible(true);

	}

	public void eliminarContenido() {
		contadorBoton = 3;
		listaUsuarios.setVisible(false);
		panelFormulario.setVisible(true);
		labelFormulario.setText("Formulario para Eliminar Contenido");

		comboCategoria.setVisible(false);
		datoCorreo.setVisible(false);
		datoClave.setVisible(false);
		labelUsuario.setVisible(false);
		labelContraseña.setVisible(false);
		soyAdmin.setVisible(false);
		selArchivo.setVisible(false);
		cajaArchivo.setVisible(false);
		listaUsuarios.setVisible(false);
		tituloPel.setVisible(false);
		labelTitulo.setVisible(false);
		selPortada.setVisible(false);
		cajaImagen.setVisible(false);
		comboCategoria.setVisible(false);
		cajaEliminar.setVisible(false);
		tituloUsuarioE.setVisible(false);

		labelFormulario.setVisible(true);
		guardar.setVisible(true);
		cajaEliContenido.setVisible(true);
		labelEliContenido.setVisible(true);

	}

	public void eliminarUsuario() throws FileNotFoundException {
		contadorBoton = 4;
		panelFormulario.setVisible(true);
		labelFormulario.setText("Formulario para Eliminar Usuarios");

		datoCorreo.setVisible(false);
		datoClave.setVisible(false);
		labelUsuario.setVisible(false);
		labelContraseña.setVisible(false);
		soyAdmin.setVisible(false);
		selArchivo.setVisible(false);
		cajaArchivo.setVisible(false);
		listaUsuarios.setVisible(false);
		tituloPel.setVisible(false);
		labelTitulo.setVisible(false);
		selPortada.setVisible(false);
		cajaImagen.setVisible(false);
		comboCategoria.setVisible(false);
		cajaEliContenido.setVisible(false);
		labelEliContenido.setVisible(false);

		guardar.setVisible(true);
		cajaEliminar.setVisible(true);
		labelFormulario.setVisible(true);
		tituloUsuarioE.setVisible(true);
	}

	public void mostrar() {
		contadorBoton = 5;
		tabla = new ArrayList<String>(300);
		panelFormulario.setVisible(true);

		tituloPel.setVisible(false);
		datoCorreo.setVisible(false);
		datoClave.setVisible(false);
		labelUsuario.setVisible(false);
		labelContraseña.setVisible(false);
		soyAdmin.setVisible(false);
		selArchivo.setVisible(false);
		cajaArchivo.setVisible(false);
		listaUsuarios.setVisible(false);
		cajaEliminar.setVisible(false);
		labelFormulario.setVisible(false);
		tituloUsuarioE.setVisible(false);
		guardar.setVisible(false);
		labelTitulo.setVisible(false);
		tituloPel.setVisible(false);
		selPortada.setVisible(false);
		cajaImagen.setVisible(false);
		comboCategoria.setVisible(false);
		cajaEliContenido.setVisible(false);
		labelEliContenido.setVisible(false);

		try {
			mostrarTabla();
			juntar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// listaUsuarios.setText(tabla);
		System.out.println(tabla);
		// listaUsuarios.setText("Lairon");
		listaUsuarios.setVisible(true);
	}

	public void escogerArchivo() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("select your media(*.mp4)", "*.mp4"),
				new FileChooser.ExtensionFilter("select your media(*.mp3)", "*.mp3"));

		selectedFile = fc.showOpenDialog(null);
		System.out.println("Bytes:" + selectedFile.length());
		bytes = (selectedFile.length() / 1000000) / 5;
		System.out.println("segundos:" + bytes);
		if (selectedFile != null) {
			cajaArchivo.setText(selectedFile.getAbsolutePath());
		}
	}

	public void escogerImagen() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"), new FileChooser.ExtensionFilter("JPG", "*.JPG"));
		selectedImagen = fc.showOpenDialog(null);
		if (selectedImagen != null) {
			cajaImagen.setText(selectedImagen.getAbsolutePath());
		}
	}

	public void guardar(ActionEvent event) {
		// ContadorBoton agregarusuario=1, agregarcontenido=2, eliminarcontenido=3 ,
		// eliminarusuario=4, mostrar=5
		// C:\\Users\\aaron\\eclipse-workspace\\pre\\src\\recursos\\datos.txt

		if (contadorBoton == 1) {
			if (datoCorreo.getText().length() > 0 && datoClave.getText().length() > 0) {
				// FileWriter fw;
				try {
					FileWriter fw;
					fw = new FileWriter("datos.txt", true);
					correo = datoCorreo.getText();
					clave = datoClave.getText();
					Pattern esEmail = Pattern.compile("^(.+)@(.+)$");
					Matcher matcher = esEmail.matcher(correo);

					boolean valido = matcher.find();
					if (valido == false || clave.length() < 8) {

						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText(null);
						alert.setTitle("Error");
						alert.setContentText(
								"Correo o contraseña inválido (Contraseña debe poseer más de 8 caracteres)");
						alert.showAndWait();

					} else {
						if (soyAdmin.isSelected()) {
							tipo = "true";
						} else {
							tipo = "false";
						}

						fw.write("\n" + correo + " " + clave + " " + tipo);

						if (datoClave.getText().length() > 0 && datoCorreo.getText().length() > 0) {
							Alert alert = new Alert(Alert.AlertType.WARNING);
							alert.setHeaderText(null);
							alert.setTitle("Info");
							alert.setContentText("Cambios realizados");
							alert.showAndWait();
						}
					}
					fw.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else if (contadorBoton == 4) {// eliminar usuario
			// datoCorreo.getText();
			String busqueda = cajaEliminar.getText();
			// FileUtil util = new FileUtil();
			FileReader fr = null;
			try {
				fr = new FileReader("datos.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			int encontrado = 0;
			int i = 0;
			String nombre, apellido, linea;
			File intPutFile = new File("datos.txt");

			try {
				while ((linea = br.readLine()) != null) {
					StringTokenizer token = new StringTokenizer(linea);
					while (token.hasMoreTokens()) {
						if (i == 0 && busqueda.equals(token.nextToken())) {
							// Borrar aca
							System.out.println("Encontrado");
							removeLineFromFile("datos.txt", linea);
							encontrado = 1;
						}
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
				// fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File outFile = new File("datos.txt.txt");
			if (encontrado == 0) {
				outFile.delete();
			} else {
				intPutFile.delete();
				outFile.renameTo(new File("datos.txt"));
			}

			if (cajaEliminar.getText().length() > 0) {

				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Cambios realizados");
				alert.showAndWait();
			}
		} else if (contadorBoton == 2) {// agregarcontenido

			if (cajaArchivo.getText().length() > 0 && tituloPel.getText().length() > 0
					&& cajaImagen.getText().length() > 0) {
				// FileWriter fw;
				try {
					FileWriter fw;
					fw = new FileWriter("multimedia.txt", true);
					contenido = tituloPel.getText().toLowerCase().replaceAll("\\s+", "");
					direccion = selectedFile.getName().replaceAll("\\s+", "");
					nombreImagen = selectedImagen.getName().replaceAll("\\s+", "");
					System.out.println("contenido" + contenido);
					System.out.println(direccion);
					System.out.println(nombreImagen);
					// agregar opciones de genero y imagen
					fw.write("\n" + contenido + " " + "recursos/" + nombreImagen + " " + "accion" + " " + "recursos/"
							+ direccion);
					fw.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			var destinoArchivo = new File("recursos/" + direccion);
			var destinoArchivo2 = new File("recursos/" + nombreImagen);
			try {
				Path origenPath = Paths.get(selectedFile.getAbsolutePath());
				Path destinoPath = destinoArchivo.toPath();
				Path origenPath2 = Paths.get(selectedImagen.getAbsolutePath());
				Path destinoPath2 = destinoArchivo2.toPath();

				// sobreescribir el fichero de destino si existe y lo copia
				Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
				Files.copy(origenPath2, destinoPath2, StandardCopyOption.REPLACE_EXISTING);

			} catch (FileNotFoundException ex) {
				LOGGER.log(Level.SEVERE, ex.getMessage());
			} catch (IOException ex) {
				LOGGER.log(Level.SEVERE, ex.getMessage());
			}
			if (cajaArchivo.getText().length() > 0 && tituloPel.getText().length() > 0
					&& cajaImagen.getText().length() > 0) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Debe esperar " + bytes + " segundos para que se realicen los cambios");
				alert.showAndWait();
				try {
					TimeUnit.SECONDS.sleep(bytes);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else if (contadorBoton == 3) { // eliminar contenido
			// File archivo1 = new File("Multimedia2.txt");
			// archivo1.delete();

			String busqueda = cajaEliContenido.getText();
			FileReader fr = null;
			try {
				fr = new FileReader("multimedia.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			int encontrado = 0;
			int i = 0;
			String nombre, apellido, linea;
			File intPutFile = new File("multimedia.txt");
			try {
				while ((linea = br.readLine()) != null) {
					StringTokenizer token = new StringTokenizer(linea);
					while (token.hasMoreTokens()) {
						if (i == 0 && busqueda.equals(token.nextToken())) {
							// Borrar aca
							System.out.println("Encontrado");
							removeLineFromFile("multimedia.txt", linea);
							encontrado = 1;
						}
						break;

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
				// fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File outFile = new File("multimedia.txt.txt");
			if (encontrado == 0) {
				outFile.delete();
			} else {
				intPutFile.delete();
				outFile.renameTo(new File("multimedia.txt"));
			}
			if (cajaEliContenido.getText().length() > 0) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Cambios realizados");
				alert.showAndWait();
			}

		} else {

		}

		cajaEliminar.setText("");
		datoCorreo.setText("");
		datoClave.setText("");

	}

	public void elegirCategoria() {

	}

	private void cambiarVentana() {
		Stage repro = new Stage();

		try {
			Scene test = new Scene(
					FXMLLoader.load(getClass().getClassLoader().getResource("Vistas/VistaVtnPrincipal.fxml")));
			repro.setScene(test);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Scene primeraScena = new
		// Scene((FXMLLoader.load(getClass().getResource("orden.fxml")) , 900, 500);

		repro.show();
		Stage s = (Stage) botonMostrarTabla.getScene().getWindow();
		s.hide();
	}

	public String buscar(String cadena) throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0, existe_codigo = 0;

		String datos[] = new String[numLineas];

		BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
		linea = reader.readLine();
		while (linea != null && contador < numLineas) {

			datos[contador] = linea;
			linea = reader.readLine();

			int cont = 0;
			StringTokenizer st = new StringTokenizer(datos[contador]);

			while (st.hasMoreTokens()) {

				String array = st.nextToken();
				cont = cont + 1;

				if ((cont == 1) && (vuelta == 0)) {

					if (array.equals(cadena)) {

						existe_codigo = 1;
						nivel = contador;
						vuelta = 1;
						return "correcto";
					}

				}
				if ((cont == 2) && (nivel == contador)) {

					if (array.equals(cadena)) {

						existe_codigo = 1;
						return "correcto";
					}

				}
				// Borrar solo sirve mas adelante
				if ((cont == 3) && (nivel == contador)) {

					if (array.equals("true")) {

						existe_codigo = 1;
						return "correcto";
					} else {

					}
				}
			}

			contador++;
		}
		if (existe_codigo == 0) {
			reader.close();
			return "incorrecto";
		}
		reader.close();
		return "incorrecto";
	}

	public void removeLineFromFile(String file, String lineToRemove) {

		try {

			File inFile = new File(file);
			if (!inFile.isFile()) {
				System.out.println("a");
				return;
			}

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".txt");
			// File a= new File("C:\\Users\\aaron\\OneDrive\\Escritorio\\prueba.txt");
			// Path source= Paths.get("prueba.txt");
			// Files.move(source, source.resolveSibling("prueba.txt"));
			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(lineToRemove)) {

					pw.println(line);
					pw.flush();
					System.out.println("flushg");
				}
			}
			// tempFile.renameTo(a);
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("c");
		}

		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void mostrarTabla() throws FileNotFoundException, IOException {

		String linea;
		int numLineas = 300, contador = 0, existe_codigo = 0;

		String datos[] = new String[numLineas];

		BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
		linea = reader.readLine();
		while (linea != null && contador < numLineas) {

			datos[contador] = linea;
			linea = reader.readLine();
			tabla.add(linea + "\n");

			contador++;
		}
		System.out.println(tabla);

		reader.close();
	}

	public void juntar() throws FileNotFoundException, IOException {
		int contador = 0;
		String cadena = "";
		System.out.println("medida" + tabla.size());
		int contador2 = 0;

		for (int i = 0; i < tabla.size() - 1; i++) {
			contador2 = i + 1;
			StringTokenizer palabra = new StringTokenizer(tabla.get(i));
			while (palabra.hasMoreTokens()) {
				cadena = palabra.nextToken();
				contador++;
				if (cadena != null) {
					if (contador == 1) {
						juntar = juntar + contador2 + ") " + cadena + " ";

					}

					if (contador == 2) {
						juntar = juntar + " " + cadena;

					}

					if (contador == 3) {
						juntar = juntar + " " + cadena + " " + "\n";

					}
					listaUsuarios.setText(juntar);

				}
			}
			System.out.println("tabla get i:" + tabla.get(i));
			System.out.println("iiii:" + i);
			contador = 0;
		}
		juntar = "";
		cadena = "";

	}
}
