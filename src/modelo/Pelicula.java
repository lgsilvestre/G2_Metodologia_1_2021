package modelo;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pelicula {
	private String titulo;
	private ImageIcon thumbnail;
	private String genero;
	private File dir;
	public Pelicula(String t, ImageIcon th, String g, File  d) {
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
	public File getFile() {
		return dir;
	}
	public String getDirThumbnail() {
		return getThumbnail().toString();
	}

	
}
