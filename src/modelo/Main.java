package modelo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.ControladorVtnPrincipal;
import logica.ControladorVtnReproductor;
import modelo.Pelicula;
import ui.VistaVtnAdministrador;
import ui.VistaVtnLogin;
import ui.VistaVtnPrincipal;


public class Main extends Application {
	//Directorio de la pelicula a reproducir
	private static Pelicula PeliRepro;
	
	// = new Pelicula("rocky1", new ImageIcon ("/recursos/rocky1.png"), "accion", new File("src/recursos/rocky1.mp4"))
	private static VistaVtnPrincipal a;
	private static Stage ventanaPrincipal;
	private static Parent root;
	public static int  algo = 1;
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {

    	
    	    
    	 root  = FXMLLoader.load(getClass().getResource("orden.fxml"));
        primaryStage.setTitle(""+PeliRepro.getTitulo());
        
        Scene primeraScena = new Scene(root, 900, 500);
        primaryStage.setScene(primeraScena);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    
  
    public static void main(String[] args) {
    	
    	//loginAceptado();
    	
    	VistaVtnAdministrador v = new VistaVtnAdministrador();

    	
    
    	
    	/*PARA HACER QUE EMPIECE A REPRODUCIR ALTIRO*/
    	//launch(args);
    
    	
    	
		/*Creamos GUI*/
    	VistaVtnLogin login1 = new VistaVtnLogin();
    	login1.setVisible(true);
    	login1.setResizable(false);
    	
    	
    	
    }
    

    public static void loginAceptado() {
    	
		VistaVtnPrincipal v1 = new VistaVtnPrincipal();
		
		/*Iniciamos controlador*/
		
		ControladorVtnPrincipal c1 = new ControladorVtnPrincipal (/*listaPelicula,*/ v1, algo);
		System.out.println(algo);
		algo++;
		
		
	}
        
    public static void reproducir(String[] args) {
		launch(args);
	}

     
    public static void setPeliRepro(Pelicula  p) {
    	PeliRepro=p;
	}
    
    public static Pelicula getPeliRepro() {
		return PeliRepro;
	}
}


