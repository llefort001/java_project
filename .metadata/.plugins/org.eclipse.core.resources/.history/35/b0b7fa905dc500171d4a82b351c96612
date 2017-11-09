package pack;
import java.awt.*;
import javax.swing.*;

public class Verrou {
	
protected boolean opened;
protected ImageIcon imageOpened; // image du verrou ouvert
protected ImageIcon imageClosed; // image du verrou fermé
private boolean visible; // indique si le verrou est visible
private Fenetre window; // si le verrou est visible, fenetre dans lequel il l'est
private int coordX, coordY; // si la lampe est visible position du centre de la lampe



public Verrou(int coordX, int coordY){
	this.imageOpened=createImageIcon("../padlockOpened.png",
            "Verrou ouvert");
	this.imageClosed=createImageIcon("../padlockClosed.png",
            "Verrou ferme");
	this.coordX=coordX;
	this.coordY=coordY;
	this.visible=true;
	this.opened=false;
}

public boolean isOpened() {
	return opened;
}

public void setEtat(boolean opened) {
	this.opened = opened;
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

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}

public Fenetre getWindow() {
	return window;
}

public void setWindow(Fenetre window) {
	this.window = window;
}

public int getCoordX() {
	return coordX;
}

public void setCoordX(int coordX) {
	this.coordX = coordX;
}

public int getCoordY() {
	return coordY;
}

public void setCoordY(int coordY) {
	this.coordY = coordY;
}

public void setOpened(boolean opened) {
	this.opened = opened;
}

protected ImageIcon createImageIcon(String path,
        String description) {
java.net.URL imgURL = getClass().getResource(path);
if (imgURL != null) {
return new ImageIcon(imgURL, description);
} else {
System.err.println("Couldn't find file: " + path);
return null;
}
}

public void afficher( Fenetre window){
	Graphics g=window.obtenirZoneGraphique();
	if (this.isOpened()==true){
		g.drawImage(getImageOpened().getImage(),getCoordX(),getCoordY(), window);
		System.out.println("afficher verrou "  + this + " ouvert en " + this.getCoordX() + " " + this.getCoordY());
		} // dessiner le verrou ouvert
	else if (this.isOpened()==false){
		g.drawImage(getImageClosed().getImage(),getCoordX(),getCoordY(),window);
		System.out.println("afficher verrou "  + this + " ferme en " + this.getCoordX() + " " + this.getCoordY());
		} // dessiner le verrou	fermé


}

public void effacer( Fenetre window) {
	Graphics g=window.obtenirZoneGraphique();
	g.clearRect(this.getCoordX(), this.getCoordY(), 150, 115);
	System.out.println("effacer verrou "  + this + " en " + this.getCoordX() + " " + this.getCoordY());
}



}
