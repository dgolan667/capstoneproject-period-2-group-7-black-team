import java.awt.Image;

import javax.swing.ImageIcon;

public class Flappybird extends Bird{
	private int x,y;
	private int width, height;
	private Image image;
	
	public Flappybird(int x, int y) {
		this("flappybird.png",x,y,40,50);
	}

	public Flappybird(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Flappybird(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}	
}
