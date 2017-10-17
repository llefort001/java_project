abstract class Media {

	private int vie; // dur�e du m�dia

	public Media(int t) {
		donnerVie(t); // dur�e de vie initiale
	}

	public final void donnerVie(int t) { // modifier la dur�e de vie
		if (t>0) vie = t;
		else vie = 1000; // si param�tre incorrect prendre une seconde
	}

	public int dureeDeVie() { // r�cup�rer la dur�e de vie
		return vie;
	}

	public void afficher(Fenetre f) { // n'affiche rien mais attend 
		f.delai(vie);
	}

	public abstract void effacer(Fenetre f) ; // n'efface rien
	
}
