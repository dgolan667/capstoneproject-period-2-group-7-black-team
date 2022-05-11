import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Sprite {
	
	private int x, y;
	private int width, height;
	private Image image;
	
	private double yVel;
	
	
	public Sprite(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Sprite(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		yVel = 5;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image,x,y,width,height,io);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean isPointInside(double x, double y) {
		if (x >= this.x && y >= this.y && x <= this.x+width && y <= this.y+height) {
			return true;
		} else {
			return false;
		}
	}
	
	public void act() {
		if (y < 540) {
			y += yVel;
		}
		
		else {
			yVel = 0;
		}
	}
	
	public void jump() {
		yVel = -5;
	}
	
	/*
	public void accelerate(double x, double y) {
		this.yVel += y;
	}
	*/
}
