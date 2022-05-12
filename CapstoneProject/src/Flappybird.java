import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Flappybird extends Sprite {
	public Flappybird(int x, int y) {
		this("bird.png",x,y,60,60);
	}

	public Flappybird(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Flappybird(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}
	
	public void jump() {
		int y = 0; 
		y-=5; 
		super.setYVel(y);
	}
	
	
	
	public void move () {
		int x = 0; 
		x+=10; 
		super.setXVel(x);
	}
	
	public void down () {
		
		int y = 0; 
		y-=5; 
		super.setYVel(y);
		
//			setYVel(0);
//		}
	}
		
	public void act(Sprite platform) {
		accelerate(0,0.2);  // gravity
		super.act();  // move mario based on his velocities
		
		if (platform.isPointInside(getX(), getY()+getHeight())) {  // did mario hit the platform?
			setY(platform.getY()-getHeight());  // put mario on top of the platform
			setYVel(0);  // stop him from falling
		}	
	}
	
	public Rectangle turnToRectangle () {
		return new Rectangle(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
}
