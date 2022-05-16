import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;


public class SimpleWindow extends JPanel implements KeyListener {	
	// FIELDS
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private static ScreenMain main;

    private Flappybird bird;
    private ArrayListPipes pipes;
    //private Sprite platform; 
    //private Sprite Fire; 
    private Sprite background; 
    private  ScreenMain m;
    //private boolean collision = false;
    private boolean collision;
    
    
    private Thread gameThread;
    private boolean started = false;
    private boolean running = false;
    private boolean gameover = false;

    private long startTime = 0L;
    private long endTime = 0L;
    private float elapsedTime;

    
    
    
    // CONSTRUCTORS
    
    
	
	public SimpleWindow (ScreenMain m) {
		super();
		this.m= m;
		bird = new Flappybird(100,250);
	    background = new Sprite ("background.png",0,0,800,600);
		//platform = new Sprite("Pipe.png",70,515,100,120);
		//Fire = new Sprite("obstacles.png",400,443,200,250);
		
		pipes = new ArrayListPipes ();
		
		collision = false;
		started = false;
		running = false;
		gameover = false;
		
		start();
	
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
		
		/*background.draw(g, this);
		bird.draw(g,this);
		pipes.drawPipes(g);
		pipes.move();*/
		
		initGUI(g);
		pipes.move();

		if ( gameover==true )
			gameOverGUI(g, width, height);


	}
	

	public void initGUI(Graphics g) {
		background.draw(g, this);
		bird.draw(g,this);
		//platform.draw(g,this);
		//fire.draw(g,this);
		
		pipes.drawPipes(g);
	}

	
	public void gameOverGUI(Graphics g, int width, int height) {
		System.out.print("paintComponent : game over");
		Font gameOverFont = new Font("GAME OVER", Font.BOLD, 100);
		String message = "GAME OVER";
		int messageWidth;
		g.setColor(Color.black);
		g.setFont(gameOverFont);
		FontMetrics metric = g.getFontMetrics(gameOverFont);
		messageWidth = metric.stringWidth(message);
		g.drawString(message, width/2-messageWidth/2, height/4);
		
		Font gameScoreFont = new Font("ttt", Font.BOLD, 50);
		String message2 = "YOUR SCORE is " + elapsedTime +" seconds.";
		g.setColor(Color.blue);
		g.setFont(gameScoreFont);
		FontMetrics metric2 = g.getFontMetrics(gameScoreFont);
		messageWidth = metric2.stringWidth(message2);
		g.drawString(message2, width/2-messageWidth/2, height/2);
	}

	public boolean doesRectangleSpriteCollide() {
		
		Pipe pipeI;
		int pipe_size = pipes.getSize();
		
		boolean collision = false;
		for ( int i=0 ; i < pipe_size ; ++i )
		{
			pipeI = pipes.getPipe(i);
			if ((bird.turnToRectangle()).intersects(pipeI.turnTopPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipeI.turnBottomPipeToRectangle())) { // Check if they intersect
				collision = true;
				break;
			}

		}

		return collision;
	}
	
	
	


	
	
	
	public boolean checkBird() {
		int upperY = bird.getY() - bird.getHeight()/2;
		int bottomY = bird.getY() + bird.getHeight()/2;
				boolean collision = false;
		System.out.println("getY("+bird.getY()+"), ("+bottomY+","+upperY+")");
		if ( ( upperY < -25) || (bottomY > DRAWING_HEIGHT-50) )
		//	bird= new Flappybird(380,0);
			collision = true;
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
			if ( started==false )
				started = true;
			bird.jump();
			System.out.print("UP");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if ( started==false )
				started = true;
			bird.down();
			System.out.print("DN");
		}
	

		
//		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			bird.move();	
//		} 
	}
	
/*	
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(50, 50, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleWindow panel = new SimpleWindow();//main
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		panel.run(); 
	}
	*/
	/*public void run() {
		System.out.print("run");
		int i = 0;
//		while(true) {
		while ( collision==false )
		{
			bird.act();
			
            //pipes.move();
			repaint();
			try {
				System.out.print("sleep");
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i++);			
		}

	}*/
	
	public void start () {//starting the game
		running = true;
		gameThread = new Thread() {
			@Override
			public void run () {
				gameLoop();
			}
		};
		gameThread.start();
	}
	
	public void restart () 	{

	}

	
	public void gameStop () {
		running = false;
	}
	
	public void update (boolean started) {
		if ( started==true )
			bird.act();
		//System.out.print("Updated");
		
		// collision check
		if ( doesRectangleSpriteCollide()==true || checkBird()==true )
			gameStop();

	}
	
	public void gameLoop() {
		System.out.print("run");
		startTime = System.currentTimeMillis();
		while( running ) {
			update(started);
			repaint();
			try {
				//System.out.print("Sleep");
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.print("game stopped");
		gameEnd();
	}
	
	
	public void gameEnd() {
		gameover = true;
		elapsedTime = (endTime - startTime)/1000F;
		
		JButton restartButton = new JButton("Restart");
		restartButton.setBackground(Color.ORANGE);
		restartButton.setBounds(200,400,90,50);
		this.add(restartButton);
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Restart");

				restart();
			}
		});
		

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);
		exitButton.setBounds(250,450,90,50);
		this.add(exitButton);		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Exit");
				System.exit(0);
			}
		});		
		repaint();
	}

	
	
	
	/*public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
			bird= new Flappybird(380,0);
	}*/

    
}
