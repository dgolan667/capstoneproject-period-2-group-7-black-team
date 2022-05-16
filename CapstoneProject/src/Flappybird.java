import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Flappybird extends Sprite {
	public Flappybird(int x, int y) {
		this("dog.png",x,y,60,60);
	}

	public Flappybird(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Flappybird(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}
	
	public void jump() {
		int y = 0; 
		y -= 5; 
		super.setYVel(y);
	}

	public void act() {
		accelerate(0,0.2);
		super.act();	
	}

	public Rectangle turnToRectangle () {
		return new Rectangle(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

}
