import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ArrayListPipes {
	// FIELDS
    private ArrayList <Pipe> pipes, movingDownPipes, movingUpPipes, movingHorizontalPipes;
    private int space = 500;
    private int x0 = 600;  
    private int x1 = x0 + 2500 + space/2;   
    private int x2 = x0 + 2500 + 3*space/2;  
    private int x3 = x0 + 5000 + space/2;
    
    // CONSTRUCTORS
    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	movingDownPipes = new ArrayList <Pipe> ();
    	movingUpPipes = new ArrayList <Pipe> ();
    	movingHorizontalPipes = new ArrayList <Pipe> ();
    	
    	int i = 0;
    	for (i = 0; i < 500; i++) { // could add more pipes, but the game will be lagging
    		pipes.add(new Pipe(x0, 0, 50, (int)(Math.random()*360)));
    		x0 += space;
    	}
    	
		
		// accelerates the pipes by decreasing the space between pairs of pipes
		// instead of increasing the speed of the pipes itself
        if (i > 0 && i%5 == 0) {
        	space -= 5;
        }
        
        // More moving obstacles appear when the player passes more pipes
    	for (int j = 0; j < 500; j++) {
    		movingDownPipes.add(new Pipe(x1, 0, 50, (int)(Math.random()*100)));
    		x1 += (int)(10* Math.random())* space/2;
    	}
    	
    	for (int k = 0; k < 500; k++) {
    		movingUpPipes.add(new Pipe(x2, 0, 50, (int)(Math.random()*100)));
    		x2 += (int)(10* Math.random())* space/2;
    	}
    	
    	for (int l = 0; l < 500; l++) {
    		movingHorizontalPipes.add(new Pipe(x3, (int)(Math.random()* 600), 50, (int)(Math.random()*200)));
    		x3 += (int)(10* Math.random())* space/2;
    	}
    }

    // METHODS
	public void drawPipes(Graphics g) {
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);
        }
        
        for (int i = 0; i < movingDownPipes.size(); i++) {
            movingDownPipes.get(i).drawTopPipe(g);
        }

        for (int i = 0; i < movingUpPipes.size(); i++) {
            movingUpPipes.get(i).drawBottomPipe(g);
        }
        
        for (int i = 0; i < movingHorizontalPipes.size(); i++) {
        	movingHorizontalPipes.get(i).drawTopPipe(g);
    	}
	}
	
	public void move() {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}

		for (int i = 0; i < movingDownPipes.size(); i++) {
	    	movingDownPipes.get(i).move();
	    	if (movingDownPipes.get(i).getX() < 500) {
				movingDownPipes.get(i).moveDown();
	    	}
		}
    	
		for (int i = 0; i < movingUpPipes.size(); i++) {
	    	movingUpPipes.get(i).move();
	    	if (movingUpPipes.get(i).getX() < 500) {
				movingUpPipes.get(i).moveUp();
	    	}
        }	
		
		for (int i = 0; i < movingHorizontalPipes.size(); i++) {
			movingHorizontalPipes.get(i).move();
	    	if (movingHorizontalPipes.get(i).getX() < 500) {
	    		movingHorizontalPipes.get(i).moveLeft();
	    	}
        }

 	}

	public boolean checkPipeCollision (Jumper bird) {
		boolean b = false;
		for (Pipe pipe : pipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnBottomPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		for (Pipe pipe : movingDownPipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		for (Pipe pipe : movingUpPipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnMovingBottomPipeToRectangle())) {
				b = true;
			}
		}
		
		for (Pipe pipe : movingHorizontalPipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
			
		return b;
	}
	
	public boolean checkWin() {
		boolean b = false;
		if (pipes.get(pipes.size() - 1).getX() <= 800) {
			b = true;
		}
		return b;
	}
}