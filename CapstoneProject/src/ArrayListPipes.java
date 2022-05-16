import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListPipes {
    private ArrayList <Pipe> pipes;
    

    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	
    	int x = 600;
    	for (int i = 0; i < 1000; i++) { // modify later as the number of pipes might be changed
    		pipes.add(new Pipe(x, 0, 30, (int)(Math.random()*200)));
    		x += 200 + (int)(Math.random()*400);
    	}
    }

    
	public void drawPipes(Graphics g) {
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);
        	
        	/*double j = i/5.0;
        	if (j == (int)j) {
        		pipes.get((int)j*5).drawCoin(g);
        	}*/
        }
	}
	
	public void move () {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}
	}

	
	public Pipe getPipe (int i) {
		return pipes.get(1);
	}
	
	
	public int getSize () {
		return pipes.size();
	}

	public boolean checkPipe (Flappybird bird) {
		boolean b = false;
		for (Pipe pipe : pipes) {
			if ((bird.turnToRectangle()).intersects(pipe.turnBottomPipeToRectangle()) || (bird.turnToRectangle()).intersects(pipe.turnTopPipeToRectangle())) {
				b = true;
			}
		}
		
		return b;
	}

}