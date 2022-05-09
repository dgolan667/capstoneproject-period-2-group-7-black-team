import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Fire extends Sprite{

	private int x,y;
	private int width, height;
	private Image image;
	
	public Fire(int x, int y) {
		this("obstacles.png",x,y,40,50);
	}

	public Fire(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Fire(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}	
	
	
}
