package pack;
import java.awt.Color;
import java.awt.Graphics;

class Lampe { // classe pour faire des lampes

	private int diametre; // diam�tre de la lampe
	private Color couleur; // couleur de la lampe
	private boolean allume; // indique si la lampe est dans l'�tat allum�e
	private boolean visible; // indique si la lampe est visible
	private Fenetre ou; // si la lampe est visible dans quelle fen�tre
	private int coordX, coordY; // si la lampe est visible position du centre de la lampe
	
	public Lampe(int diam, Color c){ // construction
		this.diametre = diam; // diam�tre 
		this.couleur = c;  // couleur
		this.allume = false; // au d�part la lampe est �teinte
		this.visible = false; // au d�part elle n'est pas visible
	}
		
	public void allumer() { // allumer la lampe
		this.allume = true;
		if (visible) afficher(ou); // si elle est visible l'afficher
	}
	
	public void eteindre() { // �teindre la lampe
		allume = false;
		if (visible) afficher(ou); // si elle est visible l'afficher
	}
	
	public boolean estAllume() { // indique si la lampe est allum�e
		return allume;
	}
		
	public int getDiametre() { return diametre; } // r�cup�ration du diam�tre de la lampe
	
	public Color getCouleur() { return couleur; }  // r�cup�ration de la couleur de la lampe
	
	public void rendreVisible(Fenetre f, int x, int y) {
		ou = f; // conserver la fen�tre o� la lampe est visible
		// conserver la position du centre apr�s correction pour rester dans la fen�tre
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
	
	private void afficher(Fenetre f) { // dessiner la lampe dans une fen�tre selon son �tat
		if (allume) dessiner(ou, couleur); // si elle est allum�e elle se dessine de sa couleur
		else dessiner(ou, Color.black); // si elle est �teinte elle se dessine en noir
	}
	
	private void dessiner(Fenetre f, Color c) { // dessiner la lampe d'une couleur dans une fen�tre 
		Graphics g = ou.obtenirZoneGraphique();
		g.setColor(c); // couleur donn�e
		g.fillOval(coordX-diametre/2, coordY-diametre/2, diametre, diametre); // dessin de la lampe (cercle plein)
	}
}