package ui;


import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import logica.ControladorVtnPrincipal;
import logica.ControladorVtnReproductor;
import modelo.Main;
import modelo.Pelicula;
import ui.VistaVtnReproductor;

public class VistaVtnBusqueda {
	JFrame frame;
	JPanel panel;
	
	JButton play;
	JButton parar;
	JButton mute;
	JButton no_mute;
	JButton reinicio;
	JButton volver;
	
	JButton multimedia;
	Pelicula pelicula;
	private final JFXPanel jfxPanel = new JFXPanel(); 
	
	MediaPlayer oracleVid;
	
	String pal_buscar="";
	
public VistaVtnBusqueda(String buscar) {
		
	
	
		pal_buscar=buscar;
		initcomponents(pal_buscar);

		panel.setLayout(null);

		frame.add(panel);
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		jfxPanel.setSize(800,600);
		panel.setLayout(new BorderLayout());
		panel.add(jfxPanel,BorderLayout.CENTER);
		
	}
	
	private void initcomponents(String pal_buscar) {
		
		frame = new JFrame("LaWeApp");
		panel = new JPanel();
		botones(pal_buscar);
		
		
	}

	private void botones(final String pal_buscar) {

		multimedia = new JButton();
		multimedia.setBounds(250, 100, 200, 200);
		multimedia.setVisible(true);
		multimedia.setBackground(Color.WHITE);
		Image Foto = new ImageIcon(getClass().getResource("/recursos/"+pal_buscar+".png")).getImage();
		Image newimg = Foto.getScaledInstance(multimedia.getWidth(), multimedia.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(newimg);
		multimedia.setIcon(imageIcon);
		panel.add(multimedia);
		
		
		play = new JButton();
		play.setBounds(700,10,50,50);
		play.setEnabled(false);
		play.setBackground(Color.WHITE);
		Image Foto2 = new ImageIcon(getClass().getResource("/recursos/play-btn.png")).getImage();
		Image newimg2 = Foto2.getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(newimg2);
		play.setIcon(imageIcon2);
		panel.add(play);
		
		parar = new JButton();
		parar.setBounds(700,80,50,50);
		parar.setEnabled(false);
		parar.setBackground(Color.WHITE);
		Image Foto3 = new ImageIcon(getClass().getResource("/recursos/stop-btn.png")).getImage();
		Image newimg3 = Foto3.getScaledInstance(parar.getWidth(), parar.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon3 = new ImageIcon(newimg3);
		parar.setIcon(imageIcon3);
		panel.add(parar);
		
		
		mute = new JButton();
		mute.setBounds(700,150,50,50);
		mute.setEnabled(false);
		mute.setBackground(Color.WHITE);
		Image Foto4 = new ImageIcon(getClass().getResource("/recursos/volume.png")).getImage();
		Image newimg4 = Foto4.getScaledInstance(mute.getWidth(), mute.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon4 = new ImageIcon(newimg4);
		mute.setIcon(imageIcon4);
		panel.add(mute);
		
		
		no_mute = new JButton();
		no_mute.setBounds(700,220,50,50);
		no_mute.setEnabled(false);
		no_mute.setBackground(Color.WHITE);
		Image Foto5 = new ImageIcon(getClass().getResource("/recursos/mute.png")).getImage();
		Image newimg5 = Foto5.getScaledInstance(no_mute.getWidth(), no_mute.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon5 = new ImageIcon(newimg5);
		no_mute.setIcon(imageIcon5);
		panel.add(no_mute);
		
		reinicio = new JButton();
		reinicio.setBounds(700,290,50,50);
		reinicio.setEnabled(false);
		reinicio.setBackground(Color.WHITE);
		Image Foto6 = new ImageIcon(getClass().getResource("/recursos/restart-btn.png")).getImage();
		Image newimg6 = Foto6.getScaledInstance(reinicio.getWidth(), reinicio.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon6 = new ImageIcon(newimg6);
		reinicio.setIcon(imageIcon6);
		panel.add(reinicio);
		
		
		volver = new JButton();
		volver.setBounds(700,360,50,50);
		volver.setEnabled(true);
		volver.setBackground(Color.WHITE);
		Image Foto7 = new ImageIcon(getClass().getResource("/recursos/flechaizq.png")).getImage();
		Image newimg7 = Foto7.getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon7 = new ImageIcon(newimg7);
		volver.setIcon(imageIcon7);
		panel.add(volver);
		
		
		ActionListener oyentedeaccion = new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				
				System.out.println(pal_buscar);
				crear(pal_buscar);
				multimedia.setVisible(false);
				play.setEnabled(true);
				parar.setEnabled(true);
				mute.setEnabled(true);
				no_mute.setEnabled(true);
				reinicio.setEnabled(true);
			}
		};
		multimedia.addActionListener(oyentedeaccion);
		

		
		ActionListener oyentedeaccion1 = new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				
				play();
			}
		};
		play.addActionListener(oyentedeaccion1);
		
		
		
		ActionListener oyentedeaccion2 = new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				
				parar();
				
			}
		};
		parar.addActionListener(oyentedeaccion2);
		
		
		ActionListener oyentedeaccion3 = new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				
				mute();
				
			}
		};
		mute.addActionListener(oyentedeaccion3);
		
		ActionListener oyentedeaccion4 = new ActionListener() {

			
			public void actionPerformed(ActionEvent ae) {
				
				no_mute();
				
			}
		};
		no_mute.addActionListener(oyentedeaccion4);
		
		
		
		ActionListener oyentedeaccion5 = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent ae) {
				
				reiniciar();
			}
		};
		reinicio.addActionListener(oyentedeaccion5);

		
		ActionListener oyentedeaccion6 = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent ae) {
				
				frame.getContentPane().remove(jfxPanel);
				frame.setVisible(false);
				//frame.dispose();
				parar();
				Main.loginAceptado();
			}
		};
		volver.addActionListener(oyentedeaccion6);

		
}
	
private void crear(final String pal_buscar){
		
		
		Platform.runLater(new Runnable(){
			
			public void run (){
				//(getClass().getResource("/recursos/fullscreen.png").toString())
				//(getClass().getResource("/recursos/fullscreen.png").toString())
				//File file = new File("src/recursos/"+pal_buscar+".mp4");
				//File file = new File("src/recursos/"+pal_buscar+".mp4");
				//getClass().getResource(Main.getPeliRepro().getFile()).toExternalForm()
				oracleVid = new MediaPlayer(new Media(getClass().getResource("/recursos/"+pal_buscar+".mp4").toExternalForm()));
				jfxPanel.setScene(new Scene(new Group (new MediaView(oracleVid))));
				play();
			}
			
		});
		
	}
	
	private void play(){
		
		
		Platform.runLater(new Runnable(){
			
			public void run (){
			
				oracleVid.setVolume(0.5);
				oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
				oracleVid.play();
			}
		});
	}
	
	private void parar(){
			
			
			Platform.runLater(new Runnable(){
				
				public void run (){
				
					oracleVid.pause();
				}
			});
		}

	
	private void mute(){
		
		Platform.runLater(new Runnable(){
			
			public void run (){
			
				oracleVid.setMute(false);
				
			}
		});
	}

	private void no_mute(){
			
			
			Platform.runLater(new Runnable(){
				
				public void run (){
				
					oracleVid.setMute(true);
					
				}
			});
		}
	
	
	
	private void reiniciar(){
		
		
		Platform.runLater(new Runnable(){
			
			public void run (){
			
				oracleVid.stop();
				crear(pal_buscar);
				
			}
		});
	}
	
	
	
	
}