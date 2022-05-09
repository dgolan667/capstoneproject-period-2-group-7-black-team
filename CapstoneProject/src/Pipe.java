import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Pipe extends Sprite{

	private int x,y;
	private int width, height;
	private Image image;
	
	public Pipe(int x, int y) {
		this("Pipe.png",x,y,40,50);
	}

	public Pipe(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Pipe(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}	
}
