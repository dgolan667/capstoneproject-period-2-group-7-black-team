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
        	pipes.get(i).draw(g);;
        }
	}
	
	public void move () {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).move();
		}
	}
}
