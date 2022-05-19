import java.awt.*;

public class Pipe {
	private int x, y1, y2, h1, h2;
	private int gap = 240;
	private int pipeVel = -2;
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

	public void drawTopPipe (Graphics g) {
		g.fillRect(x, y1, w, h1);
	}
	
	public void drawBottomPipe (Graphics g) {
		g.fillRect(x, y2, w, h2);
	}
	
	public void move () {
		x += pipeVel;
	}
	
	public void moveUp () {
		y2 -= 1;
	}
	
	public void moveDown () {
		y1 += 1;
	}
	
	public void moveLeft () {
		x -= 1;
	}
	
	public int getX () {
		return x;
	}
	
	public Rectangle turnTopPipeToRectangle() {
		return new Rectangle(x, y1, w, h1);
	}
	
	public Rectangle turnBottomPipeToRectangle() {
		return new Rectangle(x, y2, w, h2);
	}
}
