import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pipe {
    /*
	public Pipe(int x, int y) {
		this("Pipe.png",x,y,40,50);
	}

	public Pipe(String filename, int x, int y, int w, int h) {
		
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}

	public Pipe(Image img, int x, int y, int w, int h) {
		
		super(img, x, y, w, h);
	}	
	*/
	
	// FIELDS
	private int x, y1, y2, w, h1, h2;
	private int gap = 180;
	private Pipe pipe;
	private ArrayList <Pipe> pipes;
	
	// CONSTRUCTORS
	public Pipe (int height) {
		x = 400;
		y1 = 0;
		h1 = height;
		y2 = h1 + gap;
		h2 = 600 - h1 - gap;
		w = 50;
	}
	
	// METHODS
	public void drawPipe (Graphics g, Pipe pipe) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y1, w, h1);
		g.fillRect(x, y2, w, h2);
	}
	
	public void repaint (boolean on) {
		while (on) {
			x += 200;
			pipe.drawPipe(null, pipe);
		}
		
	}
}
