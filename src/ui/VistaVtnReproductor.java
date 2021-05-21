package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Pelicula;

public class VistaVtnReproductor {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton button;
	JLabel imagen1;
	JLabel imagen2;
	JLabel imagen3;
	JLabel imagenLogo;
	JButton botonBuscar;
	Pelicula pelicula;
	public VistaVtnReproductor(Pelicula pelicula) {
		this.pelicula=pelicula;
		initcomponents();
		//Pelicula que reproduciremos
		
		// COLOCA COSAS DE ARRIBA HACIA ABAJO
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(null);
		button.setText("Button");
		/*
		 * panel.add(label); panel.add(button);
		 */
		frame.add(panel);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		/*panel.add(imagen1);
		panel.add(imagen2);
		panel.add(imagen3);
		panel.add(imagenLogo);*/
		// Iniciamos imagenes para el slideshow
		//iniciarImagenes();
		//slideShow();
	}
	private void initcomponents() {
		frame = new JFrame(""+pelicula.getTitulo());
		panel = new JPanel();
		label = new JLabel("JFrame By Example");
		button = new JButton();
		imagen1 = new JLabel();
		imagen2 = new JLabel();
		imagen3 = new JLabel();
		imagenLogo = new JLabel();
		//iniciarImagenes();
	}
	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}

}
