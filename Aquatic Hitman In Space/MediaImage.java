import java.awt.*;
import javax.swing.*;

class MediaImage extends Media {

	private ImageIcon photo; // l'image

	public MediaImage(ImageIcon img, int t) {
		super(t); // création du Media avec durée de vie
		photo=img; // récupération de l'image
	}

	public void afficher(Fenetre f) { // afficher l'image
		f.obtenirZoneGraphique().drawImage(photo.getImage(),0,0,f);
		super.afficher(f); // laisser le délai
	}

	public void effacer(Fenetre f) { // effacer l'image
		f.obtenirZoneGraphique().clearRect(0,0,
				photo.getIconWidth(), photo.getIconHeight());
	}

}
