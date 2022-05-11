import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pipe {
	// FIELDS
	private int x, y1, y2, w;
	private double h1, h2;
	private int gap = 180;
	private ArrayList <Pipe> pipes;
	
	// CONSTRUCTORS
	public Pipe (double height) {
		x = 400;
		y1 = 0;
		h1 = height;
		y2 = (int)(h1 + gap);
		h2 = 600 - h1 - gap;
		w = 50;
	}
	
	// METHODS
	public void drawPipe (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y1, w, (int)h1);
		g.fillRect(x, y2, w, (int)h2);
	}
	
	public void repaint (boolean on) {
		while (on) {
			x += 5;
			Pipe aPipe = new Pipe(Math.random()* 210);
			pipes.add(aPipe);	
		}
	}
}
