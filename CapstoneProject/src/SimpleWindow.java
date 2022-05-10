import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleWindow extends JPanel implements KeyListener{
	// FIELDS
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	
    private Flappybird bird;
    private Sprite Pipe;
    private Sprite Fire; 
    
    // CONSTRUCTORS
	public SimpleWindow () {
		super();
		bird = new Flappybird(100,250);
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
	
		
		bird.draw(g,this);
		Pipe.draw(g, this);
		Fire.draw(g,this);
		
		
	}
	
//	public void run() {
//		while(true) {
//			// MAKE A CHANGE
//			bird.act();
//
//			// SHOW THE CHANGE
//			repaint();
//
//			// WAIT
//			try {
//				Thread.sleep(17);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(50, 50, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		//panel.run(); 
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			bird.fly();	
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			bird.act();
			
			repaint();
		}
			
	}
	
	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
			bird = new Flappybird(100,250);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
