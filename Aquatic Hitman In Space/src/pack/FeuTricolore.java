package pack;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

class FeuTricolore { 

	// Propriétés du feu tricolore
	private ImageIcon support; // image dessinant le support du feu
	private Lampe rouge,vert,orange; // les trois lampes du feu
	private int dureeRouge, dureeOrange, dureeVert; // réglages de durée du feu
	private Fenetre f; // la fenêtre dans laquelle ce feu s'affiche
	
	// Placement de l'image du feu dans la fenêtre créée
	private final int margeGauche = 50; // marges pour le dessin de l'image du feu dans la fenêtre
	private final int margeHaute = 20;
	
	// Constantes pour placement des lampes dans l'image (à modifier si on change d'image)
	private final int decalageHaut = 25; // position du centre de la première lampe
	private final int espaceEntreLampes = 11; // espacement entre les lampes
	private final int diametreLampes = 35; // taille des lampes

	// Construction avec durées des 3 feux
	public FeuTricolore(int dr, int dor, int dv) { // durées : rouge, orange, vert
		support=new ImageIcon("feup.gif"); // Récupérer l'image servant de support
		dureeRouge = dr; dureeOrange = dor; dureeVert = dv; // conserver les durées des feux

		// création de la fenetre
		f = new Fenetre(support.getIconWidth()+2*margeGauche, support.getIconHeight()+2*margeHaute); 
		afficherSupport(); // on affiche de dessin du feu
		
		 // création de la lampe rouge en haut
		rouge = new Lampe(diametreLampes, Color.red);
		rouge.rendreVisible(f, margeGauche+support.getIconWidth()/2, margeHaute+decalageHaut);
		
		 // création de la lampe orange au milieu
		orange=new Lampe(diametreLampes, Color.orange);
		orange.rendreVisible(f, margeGauche+support.getIconWidth()/2, 
				margeHaute+decalageHaut+diametreLampes+espaceEntreLampes);
				
		 // création de la lampe verte en  bas
		vert=new Lampe(diametreLampes, Color.green);
		vert.rendreVisible(f, margeGauche+support.getIconWidth()/2, 
				margeHaute+decalageHaut+2*(diametreLampes+espaceEntreLampes));
				
		rouge(); // au départ le feu tricolore est au rouge
	}

	public void rouge() { // Mettre le feu au rouge
		rouge.allumer(); 
		vert.eteindre(); 
		orange.eteindre();
	}
	public void vert() { // Mettre le feu au vert
		vert.allumer(); 
		rouge.eteindre(); 
		orange.eteindre();
	}
	public void orange() { // Mettre le feu au orange
		orange.allumer(); 
		vert.eteindre(); 
		rouge.eteindre();
	}
	
	public void reglage(int dr, int dor, int dv) { // Modifier les durées des 3 feux
		dureeRouge = dr; dureeOrange = dor; dureeVert = dv;
	}
		
	public void fonctionner(int cycles) { // Faire changer le feu (fonctionnement avec durée) N fois
		for (int i = 0; i < cycles; i++) { 
			faireUnCycle();
		}	
	}
	
	// Méthodes privées à usage interne

	private void faireUnCycle() {
		for (int i = 0; i < 3; i++) { // 1 cycle = 3 changements
			if (rouge.estAllume()) { vert(); delai(dureeVert); } // rouge à vert + durée du vert
			else {
				if (vert.estAllume()) { orange(); delai(dureeOrange); } // vert à orange + durée du orange
				else { rouge(); delai(dureeRouge); } // orange à rouge + durée du rouge
			}
		}	
	}
	
	// delai en secondes
	private void delai(int d) { 
		f.delai(1000*d); 
	}
		
	// Dessin du feu dans sa fenêtre
	private void afficherSupport() {
		Graphics g=f.obtenirZoneGraphique();
		g.drawImage(support.getImage(),margeGauche,margeHaute,f); // dessiner le support
	}

}
