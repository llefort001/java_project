package pack;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

class FeuTricolore { 

	// Propri�t�s du feu tricolore
	private ImageIcon support; // image dessinant le support du feu
	private Lampe rouge,vert,orange; // les trois lampes du feu
	private int dureeRouge, dureeOrange, dureeVert; // r�glages de dur�e du feu
	private Fenetre f; // la fen�tre dans laquelle ce feu s'affiche
	
	// Placement de l'image du feu dans la fen�tre cr��e
	private final int margeGauche = 50; // marges pour le dessin de l'image du feu dans la fen�tre
	private final int margeHaute = 20;
	
	// Constantes pour placement des lampes dans l'image (� modifier si on change d'image)
	private final int decalageHaut = 25; // position du centre de la premi�re lampe
	private final int espaceEntreLampes = 11; // espacement entre les lampes
	private final int diametreLampes = 35; // taille des lampes

	// Construction avec dur�es des 3 feux
	public FeuTricolore(int dr, int dor, int dv) { // dur�es : rouge, orange, vert
		support=new ImageIcon("feup.gif"); // R�cup�rer l'image servant de support
		dureeRouge = dr; dureeOrange = dor; dureeVert = dv; // conserver les dur�es des feux

		// cr�ation de la fenetre
		f = new Fenetre(support.getIconWidth()+2*margeGauche, support.getIconHeight()+2*margeHaute); 
		afficherSupport(); // on affiche de dessin du feu
		
		 // cr�ation de la lampe rouge en haut
		rouge = new Lampe(diametreLampes, Color.red);
		rouge.rendreVisible(f, margeGauche+support.getIconWidth()/2, margeHaute+decalageHaut);
		
		 // cr�ation de la lampe orange au milieu
		orange=new Lampe(diametreLampes, Color.orange);
		orange.rendreVisible(f, margeGauche+support.getIconWidth()/2, 
				margeHaute+decalageHaut+diametreLampes+espaceEntreLampes);
				
		 // cr�ation de la lampe verte en  bas
		vert=new Lampe(diametreLampes, Color.green);
		vert.rendreVisible(f, margeGauche+support.getIconWidth()/2, 
				margeHaute+decalageHaut+2*(diametreLampes+espaceEntreLampes));
				
		rouge(); // au d�part le feu tricolore est au rouge
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
	
	public void reglage(int dr, int dor, int dv) { // Modifier les dur�es des 3 feux
		dureeRouge = dr; dureeOrange = dor; dureeVert = dv;
	}
		
	public void fonctionner(int cycles) { // Faire changer le feu (fonctionnement avec dur�e) N fois
		for (int i = 0; i < cycles; i++) { 
			faireUnCycle();
		}	
	}
	
	// M�thodes priv�es � usage interne

	private void faireUnCycle() {
		for (int i = 0; i < 3; i++) { // 1 cycle = 3 changements
			if (rouge.estAllume()) { vert(); delai(dureeVert); } // rouge � vert + dur�e du vert
			else {
				if (vert.estAllume()) { orange(); delai(dureeOrange); } // vert � orange + dur�e du orange
				else { rouge(); delai(dureeRouge); } // orange � rouge + dur�e du rouge
			}
		}	
	}
	
	// delai en secondes
	private void delai(int d) { 
		f.delai(1000*d); 
	}
		
	// Dessin du feu dans sa fen�tre
	private void afficherSupport() {
		Graphics g=f.obtenirZoneGraphique();
		g.drawImage(support.getImage(),margeGauche,margeHaute,f); // dessiner le support
	}

}
