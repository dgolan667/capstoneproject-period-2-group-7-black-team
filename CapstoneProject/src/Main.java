import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	// FIELDS
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	
    private Bird bird;
    private PipeMovement Pipe;
    
    // CONSTRUCTORS
	public Main () {
		super();
		bird = new Bird(380,0);
		Pipe = new PipeMovement("Pipe.png",100,200,200,25);
		setBackground(Color.CYAN);
		setBackground(Color.CYAN);
	}
	
	// METHODS
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();
		
		//double ratioX = (double)width/DRAWING_WIDTH;
		//double ratioY = (double)height/DRAWING_HEIGHT;

		//((Graphics2D)g).scale(ratioX,ratioY);
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 580, 800, 20);
		
		bird.draw(g,this);
		
		Pipe.draw(g, this);

	}
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(50, 50, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main panel = new Main();
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);
	}
}
