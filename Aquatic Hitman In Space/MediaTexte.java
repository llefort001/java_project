import java.awt.*;


class MediaTexte extends Media {

	protected String texte;

	public MediaTexte(String txt, int t) {
		super(t);  // création du Media avec durée de vie
		texte=txt; // récupérer le texte
	}

	public void afficher(Fenetre f) { // afficher le texte centré dans la fenêtre
		f.obtenirZoneGraphique().drawString(texte,
			(f.largeurZoneGraphique()-f.obtenirZoneGraphique().getFontMetrics().stringWidth(texte))/2,
			(f.hauteurZoneGraphique()+f.obtenirZoneGraphique().getFontMetrics().getHeight())/2);
		super.afficher(f); // laisser le délai
	}

	public void effacer(Fenetre f) { // effacer le texte
		f.obtenirZoneGraphique().clearRect(
			(f.largeurZoneGraphique()-f.obtenirZoneGraphique().getFontMetrics().stringWidth(texte))/2-2,
			(f.hauteurZoneGraphique()+f.obtenirZoneGraphique().getFontMetrics().getHeight())/2
			  -f.obtenirZoneGraphique().getFontMetrics().getHeight()-2,
			f.obtenirZoneGraphique().getFontMetrics().stringWidth(texte)+4, 
			f.obtenirZoneGraphique().getFontMetrics().getHeight()+4);
	}

}
