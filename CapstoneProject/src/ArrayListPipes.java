import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListPipes {
    private ArrayList <Pipe> pipes;
    

    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	
    	int x = 600;
    	for (int i = 0; i < 500; i++) { // modify later as the number of pipes might be changed
    		pipes.add(new Pipe(x, 0, 50, (int)(Math.random()*420)));
    		x += 300;
    	}
    }

    
	public void drawPipes(Graphics g) {
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);
        }
	}
	
	public void move () {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}
		
		pipes.get((int)Math.random()*10).moveVertically();
	}

	public boolean checkPipeCollision (Flappybird bird) {
		boolean b = false;
		for (Pipe pipe : pipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnBottomPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		return b;
	}
}