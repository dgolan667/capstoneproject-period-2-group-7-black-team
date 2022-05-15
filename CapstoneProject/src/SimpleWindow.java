import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleWindow extends JPanel implements KeyListener {	
	// FIELDS
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private int time;
	private String score;
    private int coin = 0;   
	//private static ScreenMain main;

    private Flappybird bird;
    private ArrayListPipes pipes;
    //private Sprite platform; 
    //private Sprite Fire; 
    private Sprite background; 
    private ScreenMain m;
    private Thread gameThread;
    private boolean started = false;
    private boolean running = false;

    // CONSTRUCTORS
	public SimpleWindow (ScreenMain m) {
		super();
		this.m = m;
		bird = new Flappybird(100,250);
	    background = new Sprite ("background.png",0,0,800,600);
		//platform = new Sprite("Pipe.png",70,515,100,120);
		//Fire = new Sprite("obstacles.png",400,443,200,250);
		
		pipes = new ArrayListPipes ();
		started = false;
		running = false;
		
		start();		
		//Timer clock = new Timer(1000, (ActionListener) this); 
	    //clock.start();
	}

	// METHODS
	/*
	public void actionPerformed(ActionEvent e) {
		time = 0;
	    time++;
	}
	*/ 
	
	/*
	public String toString() {
		score = Integer.toString(time);
		return score;
	}
	*/
	
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
		//platform.draw(g,this);
		//Fire.draw(g,this);
		
		pipes.drawPipes(g);
		//g.drawString(score, 20, 20);
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
		Pipe pipe0 = pipes.getPipe();
		if ((bird.turnToRectangle()).intersects(pipe0.turnTopPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe0.turnBottomPipeToRectangle())) { // Check if they intersect
			return true;
		} else {
			return false;
		}
	}
	
	public boolean doesBirdCollideCoin()
	{
		Pipe pipe0 = pipes.getPipe();
		if ((bird.turnToRectangle()).intersects(pipe0.turnCoinToRectangle())) {
			return true;
		} else {
			return false;
		}
	}
	/*
    public void actionPerformed(ActionEvent e, Graphics g) {
    	pipe.drawPipe(g, pipe, true);
    }
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
		}
		
		/*
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {//down button to make game easier
			bird.down();
			System.out.print("DN");
		}
		*/

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (started == false) {
				started = true;
				System.out.print("ENTER");
			}
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
	
	public void gameStop () {
		running = false;
	}
	
	public void update (boolean started) {
		if (started == true) {
			//if (super.getY() < 530) {
				bird.act();
				pipes.move();

			//}
			
			//else {
				//gameStop();
			//}
		}
			

		//System.out.print("Updated");
		
		// collision check
		boolean collision1 = isBirdInsideWindow();
		if (collision1 == true) {
			gameStop();
		}
		
		boolean collision2 = doesBirdCollidePipe(); 
		if (collision2 == true) {
			gameStop();
		}
		
		boolean collision3 = doesBirdCollideCoin();
		if (collision3 == true) {
			coin++;
			System.out.print(coin);
		}
	}
	
	public void gameLoop() {
		System.out.print("run");
		while(running) {
			update(started);
			repaint();
			try {
				//System.out.print("Sleep");
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("game stopped");
	}
}
