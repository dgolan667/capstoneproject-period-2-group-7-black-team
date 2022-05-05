import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Bird {

	// FIELDS
    private final int windowHeight = 600, windowWidth = 800;
	private int x, y, width, height;
	private Image image;
	
	// CONSTRUCTORS
    public Bird() {
    	x = windowWidth/2;
    	y = windowHeight/2;
    	width = windowWidth/60;
    	height = windowHeight/80;
    }
    
	public Bird(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(), x, y, w, h);
	}

	public Bird(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
	}

	// METHODS
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, x, y, width, height, io);
	}
}
