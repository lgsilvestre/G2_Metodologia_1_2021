package modelo;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pelicula {
	private String titulo;
	private ImageIcon thumbnail;
	private String genero;
	private JLabel label;
	//private URL L;
	public Pelicula(String t, ImageIcon th, String g) {
		this.titulo=t;
		this.genero=g;
		this.thumbnail=th;
				
	}
	
	public String getGenero() {
		return genero;
	}
	public ImageIcon getThumbnail() {
		return thumbnail;
	}
	public String getTitulo() {
		return titulo;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setThumbnail(ImageIcon thumbnail) {
		this.thumbnail = thumbnail;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
