import java.awt.*;
import javax.swing.*;

class MediaImage extends Media {

	private ImageIcon photo; // l'image

	public MediaImage(ImageIcon img, int t) {
		super(t); // cr�ation du Media avec dur�e de vie
		photo=img; // r�cup�ration de l'image
	}

	public void afficher(Fenetre f) { // afficher l'image
		f.obtenirZoneGraphique().drawImage(photo.getImage(),0,0,f);
		super.afficher(f); // laisser le d�lai
	}

	public void effacer(Fenetre f) { // effacer l'image
		f.obtenirZoneGraphique().clearRect(0,0,
				photo.getIconWidth(), photo.getIconHeight());
	}

}
