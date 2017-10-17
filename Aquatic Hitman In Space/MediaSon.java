import java.applet.*;

class MediaSon extends Media {

	private AudioClip son; // le son

	public MediaSon(AudioClip s, int t) {
		super(t);  // création du Media avec durée de vie
		son=s; // récupérer le son
	}

	public void afficher(Fenetre f) { // jouer le son
		son.play();
		super.afficher(f); // laisser le délai
		}

	public void effacer(Fenetre f) { // couper le son
		son.stop();
	}

}
