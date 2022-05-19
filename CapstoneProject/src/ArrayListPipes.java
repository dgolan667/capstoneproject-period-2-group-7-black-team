import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ArrayListPipes {
    private ArrayList <Pipe> pipes, movingTopPipes, movingBottomPipes;
    private int space = 500;
    private int x0 = 600;  // x-coordinate for the first pair of pipes
    private int x1 = x0 + 2500 + space/2;   // x-coordinate for the first pair of top moving pipes (starting from the 5th pair)
    private int x2 = x0 + 2500 + 3*space/2;  //  x-coordinate for the first pair of bottom moving pipes (starting from the 6th pair)
    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	movingTopPipes = new ArrayList <Pipe> ();
    	movingBottomPipes = new ArrayList <Pipe> ();
    	
    	int i = 0;
    	for (i = 0; i < 500; i++) { // modify later as the number of pipes might be changed
    		pipes.add(new Pipe(x0, 0, 50, (int)(Math.random()*420)));
    		x0 += space;
    	}
    	
		
		// accelerates the pipes by decreasing the space between pairs of pipes, (decreasing by 5 every five pairs of pipes)
		// instead of increasing the speed of the pipes itself
        if (i > 0 && i%5 == 0) {
        	space -= 5;
        }
    	
    	for (int j = 0; j < 100; j++) {
    		movingTopPipes.add(new Pipe(x1, 0, 50, (int)(Math.random()*420)));
    		x1 += (int)(10* Math.random())* space/2;
    	}
    	
    	for (int k = 0; k < 100; k++) {
    		movingBottomPipes.add(new Pipe(x2, 0, 50, (int)(Math.random()*420)));
    		x2 += (int)(10* Math.random())* space/2;
    	}
    }

    
	public void drawPipes(Graphics g) {
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);
        }
        
        for (int i = 0; i < movingTopPipes.size(); i++) {
            movingTopPipes.get(i).drawTopPipe(g);
        }

        for (int i = 0; i < movingBottomPipes.size(); i++) {
            movingBottomPipes.get(i).drawBottomPipe(g);
        }
	}
	
	public void move () {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}

		for (int i = 0; i < movingTopPipes.size(); i++) {
	    	movingTopPipes.get(i).move();
	    	if (movingTopPipes.get(i).getX() < 600) {
				movingTopPipes.get(i).moveDown();
	    	}
		}
    	
		for (int i = 0; i < movingBottomPipes.size(); i++) {
	    	movingBottomPipes.get(i).move();
	    	if (movingBottomPipes.get(i).getX() < 600) {
				movingBottomPipes.get(i).moveUp();
	    	}
        }	

 	}

	public boolean checkPipeCollision (Flappybird bird) {
		boolean b = false;
		for (Pipe pipe : pipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnBottomPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		for (Pipe pipe : movingTopPipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		for (Pipe pipe : movingBottomPipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnBottomPipeToRectangle())) {
				b = true;
			}
		}
			
		return b;
	}
}