import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListPipes {
    private ArrayList <Pipe> pipes;
    
    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	
    	int x = 400;
    	for (int i = 0; i < 1000; i++) { // modify later as the number of pipes might be changed
    		pipes.add(new Pipe(x, 0, 50, (int)(Math.random()*450)));
    		x += 250;
    	}
    }
    
	public void drawPipes(Graphics g) {
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);
        	
        	double j = i/5.0;
        	if (j == (int)j) {
        		pipes.get((int)j*5).drawCoin(g);
        	}
        }
	}
	
	public void move () {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}
	}

	
	public Pipe getPipe () {
		return pipes.get(1);
	}
	
	public void remove () {
		
	}
}