package pack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Jeu extends JFrame {

	private final int W_SIZE = 600;

	protected JMenuBar menuBar;
	protected JMenu fichier, aide;
	protected JMenuItem aPropos, save, load, exit;
	protected JPanel menuAppli;
	protected JPanel zoneDeJeu;
	protected ImageIcon imageFond;
	protected JLabel fond;
	protected JButton jouer;
	protected JButton test;
	protected JButton nivSuiv;
	protected JButton nivPrec;
	protected JPanel menuPrincipal;
	protected JPanel menuNiveau;
	protected JPanel verrousPanel;
	protected JPanel boutonsPanel;
	protected Vector<Verrou> verrous;
	protected Vector<Bouton> boutons;
	protected int niveauEnCours = 1;
	protected Vector<Integer> coffres; // 0 si coffre fermé, 1 si coffre ouvert

	private static final long serialVersionUID = 1L;

	public Jeu() {
		// Création de l'interface
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Aquatic Hitman in Space");
		this.setSize(W_SIZE, W_SIZE);

		initCoffres();
		this.menuBar = new JMenuBar();
		this.fichier = new JMenu("Fichier");
		this.aide = new JMenu("Aide");
		this.aPropos = new JMenuItem("À propos");
		this.save = new JMenuItem("Sauvegarder");
		this.load = new JMenuItem("Charger partie");
		this.exit = new JMenuItem("Quitter");

		this.aide.add(aPropos);
		this.fichier.add(save);
		this.fichier.add(load);
		this.fichier.add(exit);
		this.menuBar.add(fichier);
		this.menuBar.add(aide);

		this.zoneDeJeu = new JPanel();
		this.zoneDeJeu.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.menuPrincipal = new JPanel();
		this.menuPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.menuNiveau = new JPanel();
		this.menuNiveau.setLayout(new GridLayout(2, 1));
		// this.menuNiveau.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.imageFond = new ImageIcon("res/Menu-Etat1-0000.png", "Chests easy");
		this.fond = new JLabel(this.imageFond);

		this.jouer = new JButton("Jouer");
		this.test = new JButton(".");
		this.nivPrec = new JButton("< Niveau précédent");
		this.nivSuiv = new JButton("Niveau suivant >");

		this.verrousPanel = new JPanel();
		this.verrousPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.boutonsPanel = new JPanel();
		this.boutonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Remplissage menuNiveau
		this.menuNiveau.add(verrousPanel);
		this.menuNiveau.add(boutonsPanel);

		// Remplissage menuPrincipal
		this.menuPrincipal.add(nivPrec);
		this.menuPrincipal.add(jouer);
		this.menuPrincipal.add(nivSuiv);

		// Remplissage zoneDeJeu avec le menuPrincipal
		this.zoneDeJeu.add(menuPrincipal);

		// Replissage de la partie superieure ( image du jeu )
		this.add(fond, BorderLayout.CENTER);
		// Replissage de la partie inferieure ( zone de jeu )
		this.add(zoneDeJeu, BorderLayout.SOUTH);

		// Ajouter menuBar
		this.add(menuBar, BorderLayout.PAGE_START);

		// Associer les action listeners
		this.jouer.addActionListener(new Jouer());
		this.nivPrec.addActionListener(new PreviousLvl());
		this.nivSuiv.addActionListener(new NextLvl());

		this.setVisible(true);
	}

	// METHODES

	public void initPanelsLvl1() {
		System.out.println(verrous.size());
		JLabel bouton1 = boutons.elementAt(0).getBouton();
		JLabel bouton2 = boutons.elementAt(1).getBouton();
		JLabel bouton3 = boutons.elementAt(2).getBouton();

		bouton1.addMouseListener(new ActionLvl1Bouton1());
		bouton2.addMouseListener(new ActionLvl1Bouton2());
		bouton3.addMouseListener(new ActionLvl1Bouton3());

		boutonsPanel.add(bouton1);
		boutonsPanel.add(bouton2);
		boutonsPanel.add(bouton3);

		for (int i = 0; i < verrous.size(); i++) {
			verrousPanel.add(verrous.elementAt(i).getVerrou());
		}
		System.out.println(verrousPanel);
	}

	public void initPanelsLvl2() {
		System.out.println(verrous.size());
		JLabel bouton1 = boutons.elementAt(0).getBouton();
		JLabel bouton2 = boutons.elementAt(1).getBouton();
		JLabel bouton3 = boutons.elementAt(2).getBouton();

		bouton1.addMouseListener(new ActionLvl2Bouton1());
		bouton2.addMouseListener(new ActionLvl2Bouton2());
		bouton3.addMouseListener(new ActionLvl3Bouton3());

		boutonsPanel.add(bouton1);
		boutonsPanel.add(bouton2);
		boutonsPanel.add(bouton3);

		for (int i = 0; i < verrous.size(); i++) {
			verrousPanel.add(verrous.elementAt(i).getVerrou());
		}
		System.out.println(verrousPanel);
	}

	public void initPanelsLvl3() {
		System.out.println(verrous.size());
		JLabel bouton1 = boutons.elementAt(0).getBouton();
		JLabel bouton2 = boutons.elementAt(1).getBouton();
		JLabel bouton3 = boutons.elementAt(2).getBouton();
		JLabel bouton4 = boutons.elementAt(3).getBouton();

		bouton1.addMouseListener(new ActionLvl3Bouton1());
		bouton2.addMouseListener(new ActionLvl3Bouton2());
		bouton3.addMouseListener(new ActionLvl3Bouton3());
		bouton4.addMouseListener(new ActionLvl3Bouton4());

		boutonsPanel.add(bouton1);
		boutonsPanel.add(bouton2);
		boutonsPanel.add(bouton3);
		boutonsPanel.add(bouton4);

		for (int i = 0; i < verrous.size(); i++) {
			verrousPanel.add(verrous.elementAt(i).getVerrou());
		}
		System.out.println(verrousPanel);
	}

	public void initPanelsLvl4() {
		System.out.println(verrous.size());
		JLabel bouton1 = boutons.elementAt(0).getBouton();
		JLabel bouton2 = boutons.elementAt(1).getBouton();
		JLabel bouton3 = boutons.elementAt(2).getBouton();
		JLabel bouton4 = boutons.elementAt(3).getBouton();
		JLabel bouton5 = boutons.elementAt(4).getBouton();
		JLabel bouton6 = boutons.elementAt(5).getBouton();

		bouton1.addMouseListener(new ActionLvl4Bouton1());
		bouton2.addMouseListener(new ActionLvl4Bouton2());
		bouton3.addMouseListener(new ActionLvl4Bouton3());
		bouton4.addMouseListener(new ActionLvl4Bouton4());
		bouton5.addMouseListener(new ActionLvl4Bouton5());
		bouton6.addMouseListener(new ActionLvl4Bouton6());

		boutonsPanel.add(bouton1);
		boutonsPanel.add(bouton2);
		boutonsPanel.add(bouton3);
		boutonsPanel.add(bouton4);
		boutonsPanel.add(bouton5);
		boutonsPanel.add(bouton6);

		for (int i = 0; i < verrous.size(); i++) {
			verrousPanel.add(verrous.elementAt(i).getVerrou());
		}
		System.out.println(verrousPanel);
	}

	public void updateVerrous() {
		verrousPanel.removeAll();
		for (int i = 0; i < verrous.size(); i++) {
			verrousPanel.add(verrous.elementAt(i).getVerrou());
		}
		verrousPanel.updateUI();
	}

	public void updateBoutons() {
		boutonsPanel.removeAll();
		for (int i = 0; i < boutons.size(); i++) {
			boutonsPanel.add(boutons.elementAt(i).getBouton());
		}
		boutonsPanel.updateUI();
	}

	public void initCoffres() {
		coffres = new Vector<Integer>();
		for (int i = 0; i < 4; i++) {
			coffres.add(0);
		}
		System.out.println("Tous les coffres ont étés initialisés à l'état fermé ");
	}

	public void initLvl() {
		this.verrous = new Vector<Verrou>();
		this.boutons = new Vector<Bouton>();
		this.verrousPanel.removeAll();
		this.boutonsPanel.removeAll();
		System.out.println("Niveau en cours : " + niveauEnCours);
		switch (niveauEnCours) {
		case 1:
			for (int i = 0; i < 3; i++) {
				verrous.add(new Verrou());
				boutons.add(new Bouton());
			}

			initPanelsLvl1();

			verrousPanel.setVisible(true);
			break;
		case 2:
			for (int i = 0; i < 3; i++) {
				verrous.add(new Verrou());
				boutons.add(new Bouton());
			}

			initPanelsLvl2();

			verrousPanel.setVisible(true);
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				verrous.add(new Verrou());
				boutons.add(new Bouton());
			}

			initPanelsLvl3();

			verrousPanel.setVisible(true);
			break;
		case 4:
			for (int i = 0; i < 6; i++) {
				verrous.add(new Verrou());
				boutons.add(new Bouton());
			}

			initPanelsLvl4();

			verrousPanel.setVisible(true);
			break;
		}
	}

	// EVENT LISTENERS

	private class Jouer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("C'est parti");
			switch (niveauEnCours) {
			case 1:
				imageFond = new ImageIcon("res/Jeu-Niveau1-static.png", "Chest easy");
				break;
			case 2:
				imageFond = new ImageIcon("res/Jeu-Niveau2-static.png", "Chest normal");
				break;
			case 3:
				imageFond = new ImageIcon("res/Jeu-Niveau3-static.png", "Chest hard");
				break;
			case 4:
				imageFond = new ImageIcon("res/Jeu-Niveau4-static.png", "Chest harder");
				break;
			}
			initLvl();
			fond.setIcon(imageFond);
			zoneDeJeu.removeAll();
			zoneDeJeu.add(menuNiveau);
			System.out.println("on y est");
			zoneDeJeu.updateUI();
			new SuccessDialog();
		}
	}

	private class NextLvl implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			niveauEnCours++;
			if (niveauEnCours == 5) {
				niveauEnCours = 1;
			}
			System.out.println("Niveau " + niveauEnCours + " charg�");

			imageFond = new ImageIcon("res/Menu-Etat" + niveauEnCours + "-" + coffres.elementAt(0)
					+ coffres.elementAt(1) + coffres.elementAt(2) + coffres.elementAt(3) + ".png",
					"Chests " + niveauEnCours);
			fond.setIcon(imageFond);
		}

	}

	private class PreviousLvl implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			niveauEnCours--;
			if (niveauEnCours == 0) {
				niveauEnCours = 4;
			}
			System.out.println("Niveau " + niveauEnCours + " chargé");
			imageFond = new ImageIcon("res/Menu-Etat" + niveauEnCours + "-" + coffres.elementAt(0)
					+ coffres.elementAt(1) + coffres.elementAt(2) + coffres.elementAt(3) + ".png",
					"Chests " + niveauEnCours);
			fond.setIcon(imageFond);
		}

	}

	// LISTENERS BOUTONS LVL 1

	class ActionLvl1Bouton1 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 1 cliqué");
			verrous.elementAt(0).reverseVerrou();
			updateVerrous();

			boutons.elementAt(0).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl1Bouton2 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 1 cliqué");
			verrous.elementAt(1).reverseVerrou();
			updateVerrous();

			boutons.elementAt(1).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl1Bouton3 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 3 cliqué");
			verrous.elementAt(2).reverseVerrou();
			updateVerrous();

			boutons.elementAt(2).reverseBouton();
			updateBoutons();
		}
	}

	// LISTENERS BOUTONS LVL 2

	class ActionLvl2Bouton1 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 1 cliqué");
			verrous.elementAt(0).reverseVerrou();
			updateVerrous();

			boutons.elementAt(0).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl2Bouton2 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 2 cliqué");
			verrous.elementAt(1).reverseVerrou();
			updateVerrous();

			boutons.elementAt(1).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl2Bouton3 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 3 cliqué");
			verrous.elementAt(2).reverseVerrou();
			updateVerrous();

			boutons.elementAt(2).reverseBouton();
			updateBoutons();
		}
	}

	// LISTENERS BOUTONS LVL 3

	class ActionLvl3Bouton1 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 1 cliqué");
			verrous.elementAt(0).reverseVerrou();
			updateVerrous();

			boutons.elementAt(0).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl3Bouton2 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 2 cliqué");
			verrous.elementAt(1).reverseVerrou();
			updateVerrous();

			boutons.elementAt(1).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl3Bouton3 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 3 cliqué");
			verrous.elementAt(2).reverseVerrou();
			updateVerrous();

			boutons.elementAt(2).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl3Bouton4 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 4 cliqué");
			verrous.elementAt(3).reverseVerrou();
			updateVerrous();

			boutons.elementAt(3).reverseBouton();
			updateBoutons();
		}
	}

	// LISTENERS BOUTONS LVL 4

	class ActionLvl4Bouton1 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 1 cliqué");
			verrous.elementAt(0).reverseVerrou();
			updateVerrous();

			boutons.elementAt(0).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl4Bouton2 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 2 cliqué");
			verrous.elementAt(1).reverseVerrou();
			updateVerrous();

			boutons.elementAt(1).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl4Bouton3 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 3 cliqué");
			verrous.elementAt(2).reverseVerrou();
			updateVerrous();

			boutons.elementAt(2).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl4Bouton4 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 4 cliqué");
			verrous.elementAt(3).reverseVerrou();
			updateVerrous();

			boutons.elementAt(3).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl4Bouton5 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 5 cliqué");
			verrous.elementAt(4).reverseVerrou();
			updateVerrous();

			boutons.elementAt(4).reverseBouton();
			updateBoutons();
		}
	}

	class ActionLvl4Bouton6 extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseEvent triggered");
			System.out.println("Bouton 6 cliqué");
			verrous.elementAt(5).reverseVerrou();
			updateVerrous();

			boutons.elementAt(5).reverseBouton();
			updateBoutons();
		}
	}

	// Modal succes niveau
	public class SuccessDialog extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SuccessDialog() {
			// System.out.println(getParent().getSize());
			setBounds(0, 0, 600, 150);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent event) {
						retourMenuSuccess();
				}
			});

			setVisible(true);
			setLayout(new GridLayout(2, 1));
			JButton btn = new JButton("Revenir au menu principal");
			JLabel success = new JLabel("Félicitations, vous avez terminé le niveau " + niveauEnCours,
					SwingConstants.CENTER);
			add(success);
			add(btn);
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					retourMenuSuccess();

				}
			});
		}

		public void retourMenuSuccess() {
			coffres.set(niveauEnCours - 1, 1);
			if (niveauEnCours != 4) {
				niveauEnCours++;
			}
			imageFond = new ImageIcon("res/Menu-Etat" + niveauEnCours + "-" + coffres.elementAt(0)
					+ coffres.elementAt(1) + coffres.elementAt(2) + coffres.elementAt(3) + ".png",
					"Chests " + niveauEnCours);
			System.out.println("res/Menu-Etat" + niveauEnCours + "-" + coffres.elementAt(0) + coffres.elementAt(1)
					+ coffres.elementAt(2) + coffres.elementAt(3) + ".png");
			// génération du fichier d'image menu a afficher selon l'etat des
			// niveaux réussis.
			fond.setIcon(imageFond);
			zoneDeJeu.removeAll();
			zoneDeJeu.add(menuPrincipal);
			zoneDeJeu.updateUI();
			dispose();
		}
	}
}
