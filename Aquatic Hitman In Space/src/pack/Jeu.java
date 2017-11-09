package pack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Jeu extends JFrame {

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

	private static final long serialVersionUID = 1L;

	public Jeu() {
		// creation de l'iterface
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Aquatic Hitman in Space");
		
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
		this.menuNiveau.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.imageFond = new ImageIcon("res/Chests_easy.png", "Chests easy");
		this.fond = new JLabel(this.imageFond);

		this.jouer = new JButton("Jouer");
		this.test = new JButton("Test bouton");
		this.nivPrec = new JButton("< Niveau précédent");
		this.nivSuiv = new JButton("Niveau suivant >");

		this.verrousPanel = new JPanel();
		this.verrousPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.boutonsPanel = new JPanel();
		this.boutonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Remplissage des verrous du niveau
		switch(niveauEnCours){
			
		}

		// Remplissage menuNiveau
		this.menuNiveau.add(verrousPanel);
		this.menuNiveau.add(boutonsPanel);
		this.menuNiveau.add(test);

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

		this.setVisible(true);
		this.setResizable(false);
		this.pack();

		// Associer les action listeners
		this.jouer.addActionListener(new Jouer());
		this.nivPrec.addActionListener(new PreviousLvl());
		this.nivSuiv.addActionListener(new NextLvl());
		

	}
	
	private class Jouer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("C'est parti");
			switch (niveauEnCours) {
			case 1:
				imageFond = new ImageIcon("res/Chest_easy.png", "Chest easy");
				break;
			case 2:
				imageFond = new ImageIcon("res/Chest_normal.png", "Chest normal");
				break;
			case 3:
				imageFond = new ImageIcon("res/Chest_hard.png", "Chest hard");
				break;
			case 4:
				imageFond = new ImageIcon("res/Chest_harder.png", "Chest harder");
				break;
			}
			fond.setIcon(imageFond);
			zoneDeJeu.removeAll();
			zoneDeJeu.add(menuNiveau);
			System.out.println("on y est");
			zoneDeJeu.repaint();
		}	
	}
	
	private class NextLvl implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			niveauEnCours++;
			if(niveauEnCours == 5){
				niveauEnCours=1;
			}
			System.out.println("Niveau " + niveauEnCours + " charg�");
			switch (niveauEnCours) {
			case 1:
				imageFond = new ImageIcon("res/Chests_easy.png", "Chests easy");
				break;
			case 2:
				imageFond = new ImageIcon("res/Chests_normal.png", "Chests normal");
				break;
			case 3:
				imageFond = new ImageIcon("res/Chests_hard.png", "Chests hard");
				break;
			case 4:
				imageFond = new ImageIcon("res/Chests_harder.png", "Chests harder");
				break;

			}
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
			System.out.println("Niveau " + niveauEnCours + " charg�");
			switch (niveauEnCours) {
			case 1:
				imageFond = new ImageIcon("res/Chests_easy.png", "Chests easy");
				break;
			case 2:
				imageFond = new ImageIcon("res/Chests_normal.png", "Chests normal");
				break;
			case 3:
				imageFond = new ImageIcon("res/Chests_hard.png", "Chests hard");
				break;
			case 4:
				imageFond = new ImageIcon("res/Chests_harder.png", "Chests harder");
				break;

			}
			fond.setIcon(imageFond);
		}
		
	}
}
