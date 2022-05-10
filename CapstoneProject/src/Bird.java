import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bird extends Sprite{

	// FIELDS
   // private final int windowHeight = 600, windowWidth = 800;
	private int x, y;
	private int width, height;
	private Image image;
	
	// CONSTRUCTORS (since we added a sprite class, we don't need these methods/constructor 
//	public Bird(int x, int y) {
//		this("flappybird.png", x, y, 40, 50);
//	}
	
   /* public Bird() {
    	x = windowWidth/2;
    	y = windowHeight/2;
    	width = windowWidth/60;
    	height = windowHeight/80;
    }
    necessary?
    */
    
	public Bird(int x,int y) {
		this("bird.png",x,y,40,50);
		
	}
	
    public Bird(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(), x, y, w, h);

    }

	public Bird(Image img, int x, int y, int w, int h) {
		super(img,x,y,w,h);

	}
	
	public void jump() {
		setYVel(5);
		accelerate(0,0.2);
		super.act();

	}
	
	public void act() {
		accelerate(0,0.2);
		super.act();

	}
	


	// METHODS
//	public void draw(Graphics g, ImageObserver io) {
//		g.drawImage(image, x, y, width, height, io);
//	}
}
