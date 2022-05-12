import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleWindow extends JPanel implements KeyListener {	
	// FIELDS
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

    private Flappybird bird;
    private ArrayListPipes pipes;
    private Sprite platform; 
    //private Sprite Fire; 
    private Sprite background; 
    private boolean collision;
    
    // CONSTRUCTORS
	public SimpleWindow () {
		super();
		bird = new Flappybird(100,250);
	    background = new Sprite ("background.png",0,0,800,600);
		platform = new Sprite("Pipe.png",70,515,100,120);
		//Fire = new Sprite("obstacles.png",400,443,200,250);
		
		pipes = new ArrayListPipes ();
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
		
		background.draw(g, this);
		bird.draw(g,this);
		platform.draw(g,this);
		//Fire.draw(g,this);
		
		pipes.drawPipes(g);
		pipes.move();
	}
	
	public boolean doesRectangleSpriteCollide(Pipe pipe) {
		Pipe pipe0 = pipes.getPipe();
		if ((bird.turnToRectangle()).intersects(pipe0.turnTopPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe0.turnBottomPipeToRectangle())) { // Check if they intersect
			collision = true;
		} else {
			collision = false;
		}

		return collision;
	}
	
	/*
    public void actionPerformed(ActionEvent e, Graphics g) {
    	pipe.drawPipe(g, pipe, true);
    }
    
	/*
	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
			bird = new Flappybird(100,250);
    */
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			bird.jump();	
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bird.down();	
		} 
	}
	
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(50, 50, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		panel.run(); 
	}
	
	public void run() {
		while(true) {
			bird.act(platform);
			
            //pipes.move();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
			bird= new Flappybird(380,0);
	}

	
}
