package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.animation.FadeTransition;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modelo.Main;

/**
 * Initializable is used when you want to interact with stuff injected with
 * @FXML. During construction those variables aren't filled so you can't interact
 * with them so JavaFX will call initializable after everything is set up.
 */
public class ControladorVtnAdmin implements Initializable {

	// The main container of the application that holds everything.
	//@FXML
	/*private ArrayList<Pelicula> listaPelicula = new ArrayList<>();
	private VistaVtnPrincipal vtnPrincipal;*/
	//private int contFlecha = 0;
	//private int algo;
	int nivel=0, vuelta=0;
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
	private TextField datoCorreo;
	
	@FXML
	private TextField datoClave;
	
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
	private TableView<String> tablaContenido;
	
	@FXML
	private TableColumn columna1;
	
	@FXML
	private TableColumn columna2;	
	
	String correo;
	String clave;
	String tipo;
	
	public void IrAVistaUsuario() {
		cambiarVentana();
	}
	
	public void agregarUsuario() {
		tablaContenido.setVisible(false);
		panelFormulario.setVisible(true);	
        
	}
	
	public void agregarContenido() {
		tablaContenido.setVisible(false);
		panelFormulario.setVisible(false);
	}
	
	public void eliminarContenido() {
		tablaContenido.setVisible(false);
		panelFormulario.setVisible(false);
	}
	
	public void eliminarUsuario() {
		tablaContenido.setVisible(false);
		panelFormulario.setVisible(false);
	}
	
	public void mostrar() {
		tablaContenido.setVisible(true);
		panelFormulario.setVisible(false);
	}
	
	
	public void guardar() {

		//C:\\Users\\aaron\\eclipse-workspace\\pre\\src\\recursos\\datos.txt
		System.out.println("hola");

		
		if(datoCorreo.getText().length()>0 && datoClave.getText().length()>0){
            //FileWriter fw;
            try {
            	FileWriter fw;
                fw = new FileWriter("datos.txt",true);
                correo=datoCorreo.getText();
                clave=datoClave.getText();
                if(soyAdmin.isSelected()) {
                	tipo="true";
                }else {
                	tipo="false";
                }
                
                fw.write("\n"+ correo + "\t" + clave + "\t" + tipo);
                fw.close();
                
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("holiiiiii");
			}
           
        }else{
            System.out.println("No se han ingresado todos los datos");
        }
	}

	@Override	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		tablaContenido.setVisible(false);
		panelFormulario.setVisible(false);

	}
	
	private void cambiarVentana() {
		Stage repro = new Stage();

		try {
			Scene test = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Vistas/VistaVtnPrincipal.fxml")),
					900, 500);
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
                        nivel=contador;
                        vuelta=1;
                        return "correcto"; 
                    }
                           
                }
                if((cont==2)&&(nivel==contador)){
                    
                    if(array.equals(cadena)){

                        existe_codigo=1;
                        return "correcto";
                    }
                  
                }
                //Borrar solo sirve mas adelante
                if((cont==3)&&(nivel==contador)){
                    
                    if(array.equals("true")){

                        existe_codigo=1;
                        return "correcto";
                    }else {
                    	
                    }
                }
            }
           
            contador++;
        }
        if(existe_codigo==0){
        	reader.close();
            return "incorrecto";
        }
       reader.close();
       return "incorrecto";
    }

}
