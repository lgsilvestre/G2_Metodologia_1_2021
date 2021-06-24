package modelo;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javafx.scene.image.Image;

public class Multimedia {
	private String titulo;
	private Image thumbnail;
	private String genero;
	// Sirve para cuando hagamos con mas archivos y no los podamos meter en el jar private File dir;
	private String dir;
	public Multimedia(String t, Image th, String g, String  d) {
		this.titulo=t;
		this.genero=g;
		this.thumbnail=th;
		this.dir = d;
				
	}
	public String getTitulo() {
		return titulo;
	}
	public Image getThumbnail() {
		return thumbnail;
	}
	public String getGenero() {
		return genero;
	}
	public String getFile() {
		return dir;
	}


	
}

