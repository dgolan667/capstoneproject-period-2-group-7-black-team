import java.awt.*;
import java.util.ArrayList;

public class Pipe {
	private int x, y1, y2, h1, h2;
	private int gap = 150;
	private final int w = 50;
	private final int space = 150;
	
	private ArrayList <Pipe> pipes;

	public Pipe (int x, int y, int w, int h) {
		this.x = x;
		y1 = y;
		w = 50; 
		this.h1 = h;
		y2 = h1 + gap;
		h2 = 600 - y2;
	}
	
	public void addPipe() {
		pipes.add(new Pipe(x, y1, w, h1));
		pipes.add(new Pipe(x, y2, w, h2));
		
	    for (int i = 0; i < pipes.size(); i++) {
			Pipe pipe = pipes.get(i);
			pipe.x -= space;
		}
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.RED);
		if (true) {
			g.fillRect(x, y1, w, h1);
			g.fillRect(x, y2, w, h2);
			x -= space;
		}

	}
}















/*
public class Pipe {
	// FIELDS
	private int x, y1, y2, w;
	private double h1, h2;
	private int gap = 180;
	private ArrayList <Pipe> pipes;
	private int space = 150;
	
	// CONSTRUCTORS
	public Pipe (int x, int y, int w, double h) {
		this.x = x;
		y1 = y;
		this.w = w;
		h1 = h;
		y2 = (int)(h1 + gap);
		h2 = 600 - h1 - gap;
		pipes = new ArrayList<Pipe>();
		Pipe pipe = new Pipe()
	}
	
	// METHODS
	public void addPipe () {
		if (true) {
			pipes.add(new Pipe(x, y1, w, h1));
			pipes.add(new Pipe(x, y2, w, h2));
		}
		
		for (int i = 0; i < 10; i++) {
			pipe.x -= space;
		}
	}
	
	
	
	
	
	
	public void drawPipe (Graphics g) {
		g.setColor(Color.red);
		for (int d = 0; d < 150; d++) {
			g.fillRect(Pipe.x, Pipe.y, Pipe.w, Pipe.h);
		}
	}
}
*/
