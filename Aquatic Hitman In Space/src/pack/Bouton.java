package pack;

import java.util.Vector;

import javax.swing.JButton;

public class Bouton {

	protected JButton bouton;
	
	public Bouton(){
		this.bouton = new JButton(".");
	}

	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}
}
