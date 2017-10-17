abstract class Media {

	private int vie; // durée du média

	public Media(int t) {
		donnerVie(t); // durée de vie initiale
	}

	public final void donnerVie(int t) { // modifier la durée de vie
		if (t>0) vie = t;
		else vie = 1000; // si paramètre incorrect prendre une seconde
	}

	public int dureeDeVie() { // récupérer la durée de vie
		return vie;
	}

	public void afficher(Fenetre f) { // n'affiche rien mais attend 
		f.delai(vie);
	}

	public abstract void effacer(Fenetre f) ; // n'efface rien
	
}
