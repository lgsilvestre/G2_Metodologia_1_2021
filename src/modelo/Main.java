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
import Vistas.VistaVtnLogin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.ControladorVtnReproductor;
import java.io.BufferedReader;


public class Main extends Application {
	//Directorio de la pelicula a reproducir
	private static Multimedia MultiRepro = new Multimedia("rocky1", new Image ("/recursos/rocky1.png"), "accion", new String("/recursos/rocky1.mp4"));	
	public static String n="";
	private static Stage ventanaPrincipal;
	private static Parent root;
	public static int  algo = 1;
	public static Scene prueba;
	@Override
    public void start(Stage primaryStage) throws Exception {
		System.out.println("main "+n);
		if(n.equals("true")) {
	        Scene test = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Vistas/VistaVtnAdmin.fxml")));
	        primaryStage.setScene(test);
	        primaryStage.show();
		}
		if(n.equals("false")) {
			Scene test = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Vistas/VistaVtnPrincipal.fxml")));
			primaryStage.setScene(test);
			primaryStage.show();
		}
    }  
  
    public static void main(String[] args) {
    	
		/*Creamos GUI*/
    	VistaVtnLogin login1 = new VistaVtnLogin();
    	login1.setVisible(true);
    	login1.setResizable(false);

    }
    
    public static void loginAceptado(String administrador) {
		n=administrador;
		reproducir(null);
		
	}
        
    public static void reproducir(String[] args) {
		launch(args);
	}

    public static void setMultiRepro(Multimedia  p) {
    	MultiRepro=p;
	}
    

    public static Multimedia getMultiRepro() {
		return MultiRepro;
	}
    
}


