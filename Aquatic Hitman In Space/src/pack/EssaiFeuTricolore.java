package pack;
class EssaiFeuTricolore {

	public static void main(String[] arg) {
		FeuTricolore ft=new FeuTricolore(4, 1, 3); // rouge 4s, orange 1s, vert 3s
		ft.fonctionner(2); // faire 2 cycles
		System.out.println("Changement de reglage du feu");
		ft.reglage(2,1,4); // rouge 2s, orange 1s, vert 4s
		ft.fonctionner(2); // refaire 2 cycles
		System.out.println("Fin du test");
	}
}