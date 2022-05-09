import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	// FIELDS
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	
    private Bird Flappybird;
    private Sprite Pipe;
    private Sprite Fire; 
    
    // CONSTRUCTORS
	public Main () {
		super();
		Flappybird = new Bird(380,0);
		Pipe = new Sprite("Pipe.png",200,415,100,250);
		Fire = new Sprite("obstacles.png",400,443,200,250);
		Color LBLUE= new Color(102,178,255); 
		setBackground(LBLUE); 
		
	}
	
	// METHODS
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight(); 
		
		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;

		((Graphics2D)g).scale(ratioX,ratioY);
	
		
		Flappybird.draw(g,this);
		Pipe.draw(g, this);
		Fire.draw(g,this);
		

	}
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(50, 50, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main panel = new Main();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}
}
