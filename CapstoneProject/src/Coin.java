import java.awt.*;

public class Coin {
    // FIELDS
	private int x, y;
	private final int w = 50;
	private final int h = 50;
	private int speed = -2;
	//private boolean view;
	
	// CONSTRUCTORS
	public Coin (int x, int y) {
		this.x = x;
		this.y = y;
		//view = true;
	}
	
	// METHODS
	public void drawCoin (Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, w, h);
		g.setColor(Color.ORANGE);
		g.fillOval(x + w/10, y + h/10, 4*w/5, 4*h/5);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, w, h);
		g.drawOval(x + w/10, y + h/10, 4*w/5, 4*h/5);
	}
	
	public void move () {
		x += speed;
	}
	
	public Rectangle turnCoinToRectangle () {
		return new Rectangle(x, y, w, h);
	}
	
	public void moveDown() {
		y = 800;
	}
	
	
}
