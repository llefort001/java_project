package pack;
import java.awt.Color;

class EssaiLampe {

	public static void main(String[] arg) {
//		Lampe l = new Lampe(60, new Color(250,0,0)); // Lampe rouge de diametre 60
		Verrou v = new Verrou(300,300);
		Verrou v2 = new Verrou (500,300 );
		Bouton b1 = new Bouton(0, 0);
		Fenetre window =new Fenetre(1280,720); // creer une fenetre de test
//		int centreX = fenetre.largeurZoneGraphique()/2; // placement au centre de la fenêtre
//		int centreY = fenetre.hauteurZoneGraphique()/2;
		v.afficher(window);
		v2.setOpened(true);
		v2.afficher(window);
		b1.afficher(window);
		while(true){
		window.delai(300);
		v2.effacer(window);
		if (v2.isOpened()==true){
		v2.setOpened(false);}
		else {
			v2.setOpened(true);
		}
		v2.afficher(window);}
/*		l.rendreVisible(fenetre, centreX, centreY);
		for (int i=0; i<3; i++) { // faire 3 clignotements
			l.eteindre(); // l'éteindre
			fenetre.delai(500); // attendre 0,5 seconde
			l.allumer(); // l'allumer
			fenetre.delai(500); // attendre 0,5 seconde
		}
		// Test des méthodes
		// Diamètre et couleur
		System.out.println("La lampe a un diametre de "+l.getDiametre()+" et es t : "+l.getCouleur());
		// Etat
		if (l.estAllume()) System.out.println("Elle est allumee");
		else System.out.println("Elle est eteinte");
		// Test de l'état après modification
		fenetre.delai(1000);
		l.eteindre(); // l'éteindre
		if (l.estAllume()) System.out.println("Elle est allumee");
		else System.out.println("Elle est eteinte");
		fenetre.delai(1000);
		l.rendreInvisible();
		System.out.println("Elle a disparu");
*/	}
}