import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

<<<<<<< Updated upstream
public class Main extends JPanel {
	// FIELDS
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	
    private Bird bird;
    private PipeMovement Pipe;
    private Obstacle Fire; 
    
    // CONSTRUCTORS
	public Main () {
		super();
		bird = new Bird(380,0);
		Pipe = new PipeMovement("Pipe.png",200,415,100,250);
		Fire = new Obstacle("obstacles.png",400,445,200,250);
		Color LBLUE= new Color(102,178,255); 
		setBackground(LBLUE); 
		
=======
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Main extends JPanel {
	private Obstacles obstacles;
	
	
    public Main() {
    	
		super();
		Color LBLUE = new Color (51, 153, 255); 
		
		obstacles = new Obstacles("obstacles.png", 0,0,400,50);
		
		setBackground(LBLUE);
>>>>>>> Stashed changes
	}
    
    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
//
//		int width = getWidth();
//		int height = getHeight();
//
//		double ratioX = (double)width/DRAWING_WIDTH;
//		double ratioY = (double)height/DRAWING_HEIGHT;

//		((Graphics2D)g).scale(ratioX,ratioY);

		
		
		obstacles.draw(g,this);

	}
    
	
	// METHODS
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

<<<<<<< Updated upstream
		int width = getWidth();
		int height = getHeight(); 
=======
		JFrame window = new JFrame("Flappy Bird");
		window.setBounds(50, 50, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main panel = new Main();  
        window.add(panel);
		window.setResizable(true);
		window.setVisible(true);
	
>>>>>>> Stashed changes
		
		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;

		((Graphics2D)g).scale(ratioX,ratioY);
		
		
		bird.draw(g,this);
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
