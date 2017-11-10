package pack;

import javax.swing.*;

public class Verrou {

	protected boolean opened;
	protected ImageIcon imageOpened = new ImageIcon("res/padlockOpened.png", "Padlock opened"); // image du verrou ouvert
	protected ImageIcon imageClosed = new ImageIcon("res/padlockClosed.png", "Padlock closed"); // image du verrou fermé
	protected JLabel baseLabel;

	public Verrou() {
		this.opened = false;
		this.baseLabel = new JLabel(this.imageClosed);
	}

	public boolean isOpened() {
		return opened;
	}

	public void setEtat(boolean opened) {
		this.opened = opened;
	}
	
	public JLabel getVerrou() {
		return this.baseLabel;
	}
	
	public void reverseVerrou() {
		if (this.opened) {
			this.baseLabel.setIcon(this.imageClosed);
			this.opened = false;
		} else {
			this.baseLabel.setIcon(this.imageOpened);
			this.opened = true;
		}
	}
	
	public ImageIcon getImageOpened() {
		return imageOpened;
	}

	public void setImageOpened(ImageIcon imageOpened) {
		this.imageOpened = imageOpened;
	}

	public ImageIcon getImageClosed() {
		return imageClosed;
	}

	public void setImageClosed(ImageIcon imageClosed) {
		this.imageClosed = imageClosed;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

//	public void afficher(Fenetre window) {
//		Graphics g = window.obtenirZoneGraphique();
//		if (this.isOpened() == true) {
//			g.drawImage(getImageOpened().getImage(), getCoordX(), getCoordY(), window);
//			System.out.println("afficher verrou " + this + " ouvert en " + this.getCoordX() + " " + this.getCoordY());
//		} // dessiner le verrou ouvert
//		else if (this.isOpened() == false) {
//			g.drawImage(getImageClosed().getImage(), getCoordX(), getCoordY(), window);
//			System.out.println("afficher verrou " + this + " ferme en " + this.getCoordX() + " " + this.getCoordY());
//		} // dessiner le verrou ferm�
//
//	}
//
//	public void effacer(Fenetre window) {
//		Graphics g = window.obtenirZoneGraphique();
//		g.clearRect(this.getCoordX(), this.getCoordY(), 150, 115);
//		System.out.println("effacer verrou " + this + " en " + this.getCoordX() + " " + this.getCoordY());
//	}

}
