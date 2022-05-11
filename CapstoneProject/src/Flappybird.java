import java.awt.Image;

import javax.swing.ImageIcon;

public class Flappybird extends Sprite{
	// CONSTRUCTORS
	public Flappybird(int x, int y) {
		this("bird.png",x,y,60,60);
	}

	public Flappybird(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Flappybird(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}
	
	// METHODS
	public void jump() {
		super.jump();
	}
	
	public void act() {
		super.act();
	}
	

}
