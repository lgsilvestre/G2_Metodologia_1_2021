package application;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logica.ControladorVtnPrincipal;
import modelo.Pelicula;
import ui.VistaVtnPrincipal;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("WittCode's Video Player");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
		/*Creamos GUI*/
		VistaVtnPrincipal v1 = new VistaVtnPrincipal();
		ArrayList<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		/*Cargamos guardadas peliculas*/
		ImageIcon icon1 = new ImageIcon(("/recursos/1.png"));
		Pelicula p1 = new Pelicula("rocky1",  icon1, "accion");
		ImageIcon icon2 = new ImageIcon(("/recursos/2.png"));
		Pelicula p2 = new Pelicula("rocky2",  icon2, "accion");
		ImageIcon icon3 = new ImageIcon(("/recursos/3.png"));
		Pelicula p3 = new Pelicula("rocky3",  icon3, "accion");		
		
		listaPelicula.add(p1);
		listaPelicula.add(p2);
		listaPelicula.add(p3);
		/*Iniciamos controlador*/
		
		ControladorVtnPrincipal c1 = new ControladorVtnPrincipal(listaPelicula, v1);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
