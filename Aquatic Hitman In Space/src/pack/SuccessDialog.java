package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SuccessDialog extends JFrame {

	private Jeu jeu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SuccessDialog(Jeu jeu) {
		// La classe Jeu courante est passé en paramétre pour pouvoir changer l'affichage à partir de la classe
		// SuccessDialog
		this.jeu = jeu;
		// System.out.println(getParent().getSize());
		setBounds(0, 0, 600, 150);
		setTitle("Message");
		setAlwaysOnTop(true);
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
		JLabel success = new JLabel("Félicitations, vous avez terminé le niveau " + jeu.niveauEnCours,
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
		jeu.coffres.set(jeu.niveauEnCours - 1, 1);
		jeu.nivPrec.setEnabled(true);
		if (jeu.niveauEnCours != 4) {
			jeu.niveauEnCours++;
			if (jeu.niveauEnCours == 4) {
				jeu.nivSuiv.setEnabled(true);
				jeu.nivPrec.setEnabled(true);
			}
		}
		jeu.retourMenu();
		dispose();
	}

}
