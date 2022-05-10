import java.awt.Image;

import javax.swing.ImageIcon;

public class Flappybird extends Sprite{
    private int x,y;
	private int width, height;
	private Image image;
//	
	public Flappybird(int x, int y) {
		this("bird.png",x,y,60,60);
	}

	public Flappybird(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Flappybird(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}
	
//	public void jump() {
//		int yVelocity = -9;
//		x -= 4;
//		y += yVelocity;
//		yVelocity += 2;
//	}
	
	/*
	public void fly() {
		setYVel(5);
	}
	*/
	
	public void act(Sprite Bird) {
		//accelerate(0, 0.2); 
		int y = getY();
		if (y < 600) {
			super.act();  
		}
	}
	
	
}
