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
    private boolean gameOver = false;
    
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
		
		background.draw(g, this);
		bird.draw(g,this);
		pipes.drawPipes(g);
		
		if (gameOver) {
			g.setColor(Color.BLUE);
			g.getFont();
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 5.0F);
            g.setFont(newFont);
			g.drawString("GAME OVER", WIDTH/4, HEIGHT/2);
		}
		
		if (gameOver) {
			g.setColor(Color.BLACK);
			g.getFont();
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.0F);
            g.setFont(newFont);
			g.drawString("SCORE: " + elapsedTime, WIDTH/4, HEIGHT/4);
		}
		
	}
	
	public boolean isBirdInsideWindow() {
		if (bird.getY() < 0 || bird.getY() > 540) {
			return true;
		}
		
		else {
			return false;
		}
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
    	if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (started == false)
				started = true;
			bird.jump();
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
			pipes.move();
		}

		// collision check
		boolean collision = doesBirdCollidePipe();
		if (isBirdInsideWindow() == true || collision == true) {
			gameStop();
			gameOver = true;
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
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		gameEnd();

	}
	
	
	/*public void restart() {
		SimpleWindow(ScreenMain m);
	}*/
	
	public void gameEnd() {
		gameOver = true;
		elapsedTime = (endTime - startTime)/1000F;
		
		JButton restartButton = new JButton("Restart");
		restartButton.setBackground(Color.ORANGE);
		restartButton.setBounds(390,320,90,50);
		this.add(restartButton);
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Restart");

				//restart();
			}
		});
		

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);
		exitButton.setBounds(300,320,90,50);
		this.add(exitButton);		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Exit");
				System.exit(0);
			}
		});		
		
		JButton CharacterButton = new JButton("Character");
		CharacterButton.setBackground(Color.WHITE);
		CharacterButton.setBounds(480,320,90,50);
		this.add(CharacterButton);
		CharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Character");
		
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
