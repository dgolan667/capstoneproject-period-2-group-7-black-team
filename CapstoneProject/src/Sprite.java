import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Sprite {
	
	private int x, y;
	private int width, height;
	private Image image;
	
	private double xVel, yVel;
	private double friction = .9;
	
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
		
	public void jump() {
		yVel = -100;
	    this.y += yVel;
	}
		
	public void act() {
		if (y < 530) {
			this.y += yVel;
		}
	}
	
	public void undoAct() {
		this.x -= xVel;
		this.y -= yVel;
	}
	
	public void setXVel(int x) {
		this.xVel = x;
	}
	
	public void setYVel(int y) {
		this.yVel = y;
	}
	
	public void accelerate(double x, double y) {
		this.xVel += x;
		this.yVel += y;
	}
}
