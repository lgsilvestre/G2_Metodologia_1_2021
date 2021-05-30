package modelo;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pelicula {
	private String titulo;
	private ImageIcon thumbnail;
	private String genero;
	// Sirve para cuando hagamos con mas archivos y no los podamos meter en el jar private File dir;
	private String dir;
	public Pelicula(String t, ImageIcon th, String g, String  d) {
		this.titulo=t;
		this.genero=g;
		this.thumbnail=th;
		this.dir = d;
				
	}
	public String getTitulo() {
		return titulo;
	}
	public ImageIcon getThumbnail() {
		return thumbnail;
	}
	public String getGenero() {
		return genero;
	}
	public String getFile() {
		return dir;
	}
	public String getDirThumbnail() {
		return getThumbnail().toString();
	}

	
}
