import java.awt.*;

class MediaTexteAnime extends MediaTexte {

	private int vitesse; // vitesse d'apparition des caract�res

	public MediaTexteAnime(String texte, int vit, int t) {
		super(texte, t);  // cr�ation du Media avec dur�e de vie
		vitesse=vit;
	}

	public void afficher(Fenetre f) {
		String complet=texte; // r�cup�rer le texte (propri�t� protected dans MediaTexte)
		for (int i=0;i<=complet.length() ;i++ ) { // l'afficher car par car
			String partiel=complet.substring(0,i);
			f.obtenirZoneGraphique().drawString(partiel,
				(f.largeurZoneGraphique()-f.obtenirZoneGraphique().getFontMetrics().stringWidth(complet))/2,
				(f.hauteurZoneGraphique()+f.obtenirZoneGraphique().getFontMetrics().getHeight())/2);
			f.delai(vitesse); // attente entre deux cars
			}
		super.afficher(f); // affichage du texte complet et d�lai
	}
	
}
