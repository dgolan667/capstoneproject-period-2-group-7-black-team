import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Obstacles {
	private int x, y;
	private int width, height;
	private Image image;
	
	public Obstacles(int x, int y) {
		this("obstacles.png", x, y, 40, 50);
	}

	public Obstacles(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(), x, y, w, h);
	}

	public Obstacles(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, x, y, width, height, io);
	}

}
