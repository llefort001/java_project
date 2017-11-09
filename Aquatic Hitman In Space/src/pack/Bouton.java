package pack;

import java.awt.Container;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JButton;

public class Bouton {

	protected Vector<Verrou> listeVerrous;
	protected int coordX, coordY;
	protected boolean visible;
	protected Fenetre window;
	protected JButton bouton;
	
	public Bouton(){
		this.bouton = new JButton(".");
		this.visible=true;
	}

	public Vector<Verrou> getListeVerrous() {
		return listeVerrous;
	}

	public void setListeVerrous(Vector<Verrou> listeVerrous) {
		this.listeVerrous = listeVerrous;
	}


	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Fenetre getWindow() {
		return window;
	}

	public void setWindow(Fenetre window) {
		this.window = window;
	}

	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}
	
	public void afficher( Fenetre window){
		Graphics g=window.obtenirZoneGraphique();
			window.getContentPane().add(bouton);
			} // dessiner le verrou	ferm�


	}
	
