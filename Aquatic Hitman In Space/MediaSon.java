import java.applet.*;

class MediaSon extends Media {

	private AudioClip son; // le son

	public MediaSon(AudioClip s, int t) {
		super(t);  // cr�ation du Media avec dur�e de vie
		son=s; // r�cup�rer le son
	}

	public void afficher(Fenetre f) { // jouer le son
		son.play();
		super.afficher(f); // laisser le d�lai
		}

	public void effacer(Fenetre f) { // couper le son
		son.stop();
	}

}
