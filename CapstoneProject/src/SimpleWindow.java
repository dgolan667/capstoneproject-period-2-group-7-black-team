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
import javax.swing.*;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleWindow extends JPanel implements KeyListener {	
	// FIELDS
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	//private static ScreenMain main;
    private int coin;
    private Flappybird bird;
    private ArrayListPipes pipes;
    private Sprite background; 
    private ScreenMain m;
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
		this.m = m;
		bird = new Flappybird(100,250);
	    background = new Sprite ("background.png",0,0,800,600);
		pipes = new ArrayListPipes ();
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
		
		double ratioX = (double)width/WIDTH;
		double ratioY = (double)height/HEIGHT;

		((Graphics2D)g).scale(ratioX,ratioY);
		
		/*background.draw(g, this);
		bird.draw(g,this);
		pipes.drawPipes(g);
		
		if (gameOver) {
			g.setColor(Color.BLUE);
			g.getFont();
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 5.0F);
            g.setFont(newFont);
			g.drawString("GAME OVER", WIDTH/4, HEIGHT/2);
		}*/
		
		initGUI(g);
		pipes.move();

		if ( gameover==true )
			gameOverGUI(g, width, height);
	}

	public boolean isBirdInsideWindow() {
		if (bird.getY() < 0 || bird.getY() > 540) {
			return true;
		}
		
		else {
			return false;
		}
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

	
	
	public boolean doesBirdCollidePipe() {	
		boolean b = pipes.checkPipe(bird);
		return b;
		
		
		
	}
	
	public boolean doesBirdCollideCoin()
	{
		int i = 0;
		if ((bird.turnToRectangle()).intersects(pipes.getPipe(i).turnCoinToRectangle())) {
			return true;
		} else {
			i++;
			return false;
		}
	}

	public boolean checkBird() {
		int upperY = bird.getY() - bird.getHeight()/2;
		int bottomY = bird.getY() + bird.getHeight()/2;
				boolean collision = false;
		System.out.println("getY("+bird.getY()+"), ("+bottomY+","+upperY+")");
		if ( ( upperY < -25) || (bottomY > HEIGHT-50) )
		//	bird= new Flappybird(380,0);
			collision = true;
		return collision;
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

    }
    
	public void start () { //starting the game
		running = true;
		gameThread = new Thread() {
			@Override
			public void run () {
				gameLoop();
			}
		};
		
		gameThread.start();
	}
	
	public void gameStop () {
		running = false;
	}
	
	public void update(boolean started) {
		if (started == true) {
			bird.act();		
			if ( doesRectangleSpriteCollide()==true || checkBird()==true )
				gameStop();

			//pipes.move();
		}

		// collision check
		boolean collision = doesBirdCollidePipe();
		if (isBirdInsideWindow() == true || collision == true) {
			gameStop();
			gameover = true;
		}
		
		if (doesBirdCollideCoin()) {
			coin++;
		}
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

				//restart();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
