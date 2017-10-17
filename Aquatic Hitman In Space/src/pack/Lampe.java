package pack;
import java.awt.Color;
import java.awt.Graphics;

class Lampe { // classe pour faire des lampes

	private int diametre; // diamètre de la lampe
	private Color couleur; // couleur de la lampe
	private boolean allume; // indique si la lampe est dans l'état allumée
	private boolean visible; // indique si la lampe est visible
	private Fenetre ou; // si la lampe est visible dans quelle fenêtre
	private int coordX, coordY; // si la lampe est visible position du centre de la lampe
	
	public Lampe(int diam, Color c){ // construction
		this.diametre = diam; // diamètre 
		this.couleur = c;  // couleur
		this.allume = false; // au départ la lampe est éteinte
		this.visible = false; // au départ elle n'est pas visible
	}
		
	public void allumer() { // allumer la lampe
		this.allume = true;
		if (visible) afficher(ou); // si elle est visible l'afficher
	}
	
	public void eteindre() { // éteindre la lampe
		allume = false;
		if (visible) afficher(ou); // si elle est visible l'afficher
	}
	
	public boolean estAllume() { // indique si la lampe est allumée
		return allume;
	}
		
	public int getDiametre() { return diametre; } // récupération du diamètre de la lampe
	
	public Color getCouleur() { return couleur; }  // récupération de la couleur de la lampe
	
	public void rendreVisible(Fenetre f, int x, int y) {
		ou = f; // conserver la fenêtre où la lampe est visible
		// conserver la position du centre après correction pour rester dans la fenêtre
		if (x < diametre/2) coordX = diametre/2;
		else {
			if (x > ou.largeurZoneGraphique() - diametre/2) 
				coordX = ou.largeurZoneGraphique() - diametre/2;
			else coordX = x;
		}
		if (y < diametre/2) coordY = diametre/2;
		else {
			if (y > ou.hauteurZoneGraphique() - diametre/2) 
				coordY = ou.hauteurZoneGraphique() - diametre/2;
			else coordY = y;
		}
		visible = true; // Elle est visible
		afficher(ou); // l'afficher
	}
	
	public void rendreInvisible() {
		dessiner(ou, ou.obtenirCouleurFond()); // pour effacer
		visible = false; // Elle n'est plus visible
	}
	
	private void afficher(Fenetre f) { // dessiner la lampe dans une fenêtre selon son état
		if (allume) dessiner(ou, couleur); // si elle est allumée elle se dessine de sa couleur
		else dessiner(ou, Color.black); // si elle est éteinte elle se dessine en noir
	}
	
	private void dessiner(Fenetre f, Color c) { // dessiner la lampe d'une couleur dans une fenêtre 
		Graphics g = ou.obtenirZoneGraphique();
		g.setColor(c); // couleur donnée
		g.fillOval(coordX-diametre/2, coordY-diametre/2, diametre, diametre); // dessin de la lampe (cercle plein)
	}
}