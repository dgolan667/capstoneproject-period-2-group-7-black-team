import java.awt.*;

public class Pipe {
	private int x, y1, y2, h1, h2;
	private int gap = 180;
	private int pipeVel = -2;
	private double acceleration = 1.01;
	private final int w = 50;
	
	public Pipe (int x, int y, int w, int h) {
		this.x = x;
		y1 = y;
		w = 50; 
		this.h1 = h;
		y2 = h1 + gap;
		h2 = 600 - y2;
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y1, w, h1);
		g.fillRect(x, y2, w, h2);
	}
	
	public void move () {
		x += pipeVel;
		pipeVel *= acceleration;
	}
	
	public Rectangle turnTopPipeToRectangle() {
		return new Rectangle(x, y1, w, h1);
	}
	
	public Rectangle turnBottomPipeToRectangle() {
		return new Rectangle(x, y2, w, h2);
	}
}
