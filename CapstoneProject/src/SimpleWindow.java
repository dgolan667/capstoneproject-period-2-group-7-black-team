import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
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
    private ArrayListCoins coins;
    private Sprite background; 
    private ScreenMain m;
    private Thread gameThread;
    private boolean started = false;
    private boolean running = false;
    private boolean gameOver = false;
    private String character, backgroundName;
    // private Rectangle restart;
	// private Rectangle quit;
	private ScreenMain newStart;
	
    
    
    private long startTime = 0L;
    private long endTime = 0L;
    private float elapsedTime;


    // CONSTRUCTORS
    
    /* New characters (c) and background (b) added: 
     * amongus.png (c) - space.png (b)
     * character.png (c) - grass.png (b) 
     * mario.png (c) - background.png (b)
     * spongebob.png (c) - spongebob2.png (b) 
     * superman.png (c) - superman2.png (b) 
     */
	public SimpleWindow (ScreenMain m) {
		super();
		this.m = m;
		
		double i = Math.random();
		if (i < 0.1) {
			character = "bird.png";
			backgroundName = "sea.png";
		}
		
		else if (i >= 0.1 && i < 0.2) {
			character = "bluebird.png";
			backgroundName = "forest.png";
		}
		
		else if (i >= 0.2 && i < 0.3) {
			character = "dog.png";
			backgroundName = "city.png";
		}
		
		else if (i >= 0.3 && i < 0.4) {
			character = "ghost.png";
			backgroundName = "night.png";
		} 
		
		else if (i >= 0.4 && i < 0.5) {
			character = "character.png";
			backgroundName = "grass.png";
		} 
		
		else if (i >= 0.5 && i < 0.6) {
			character = "camel.png";
			backgroundName = "desert.png";
		} 
		
		else if (i >= 0.6 && i < 0.7) {
			character = "amongus.png";
			backgroundName = "space.png";
		} 
		
		else if (i >= 0.7 && i < 0.8) {
			character = "mario.png";
			backgroundName = "trees.png";
		} 
		
		else if (i >= 0.8 && i < 0.9) {
			character = "spongebob.png";
			backgroundName = "spongebob2.png";
		} 
		
		else if (i > 0.9) {
			character = "superman.png";
			backgroundName = "superman2.png";
		} 

		bird = new Flappybird(character, 100, 250);
	    background = new Sprite (backgroundName, 0, 0, 800, 600);
		pipes = new ArrayListPipes ();
		coins = new ArrayListCoins ();
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
		coins.drawCoins(g);
		
		g.getFont();
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 4.0F);
        g.setFont(newFont);

		String coinString1 = "Score: " + coin;
		g.setColor(Color.RED);
		g.drawString(coinString1, 10, 50);

		
		if (gameOver) {
			g.setColor(Color.BLUE);
			g.drawString("GAME OVER", WIDTH/4, 3*HEIGHT/4);
			
			g.setColor(Color.WHITE);
			g.drawString("FLYING TIME: " + elapsedTime + " s", WIDTH/4, HEIGHT/2);
			
			g.drawString("SCORE: " + coin, WIDTH/4, HEIGHT/4);
			
		}
		
		if (pipes.checkWin()) {
			g.setColor(Color.ORANGE);
			g.drawString("YOU WON!!!!!", WIDTH/4, HEIGHT/2);
            g.drawString("FLYING TIME: " + elapsedTime + " s", WIDTH/4, HEIGHT/2);
			
			g.drawString("SCORE: " + coin, WIDTH/4, HEIGHT/4);	
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
		boolean b = pipes.checkPipeCollision(bird);
		return b;
		
	}
	
	public boolean doesBirdCollideCoin()
	{
		boolean b = coins.checkCoinCollision(bird);
		return b;
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
			coins.move();
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
	
	public void DrawRect(Graphics g) {
		
		DrawRect(370,320,90,50);
		
		
	}
	
	private void DrawRect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}

	public void gameEnd() {
		gameOver = true;
		elapsedTime = (endTime - startTime)/1000F;		
		
		JButton restartButton = new JButton("Restart");
		restartButton.setBackground(Color.ORANGE);
		restartButton.setBounds(370,320,90,50);
		this.add(restartButton); 
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print("Restart");
				
				//newStart = new ScreenMain(TOOL_TIP_TEXT_KEY);
				newStart = new ScreenMain("Flappybird");
			}
		});
		
	
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);
		exitButton.setBounds(280,320,90,50);
		this.add(exitButton);	
		exitButton.setVisible(true);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//System.out.print("Exit");
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
