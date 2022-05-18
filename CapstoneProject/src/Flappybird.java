import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

import javax.swing.ImageIcon;

public class Flappybird extends Sprite {
	
	private float a , b , vx , vy;

	
	public Flappybird(int x, int y) {
		this("bluebird.png",x,y,60,60);
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

	public void reset() {
		// TODO Auto-generated method stub

		a = 800/2;
		b = 800/2;
		vx = vy = 0;
		
	}

}
