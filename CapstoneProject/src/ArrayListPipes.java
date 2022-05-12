import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListPipes {
    private ArrayList <Pipe> pipes;
    
    public ArrayListPipes() {
    	super();
    	pipes = new ArrayList <Pipe> ();
    	
    	int x = 400;
    	for (int i = 0; i < 4; i++) {
    		pipes.add(new Pipe(x, 0, 50, (int)(Math.random()*450)));
    		x += 200;
    	}
    	/*
    	pipes.add(new Pipe(400, 0, 50, (int)(Math.random()*450)));
		pipes.add(new Pipe(600, 0, 50, (int)(Math.random()* 450)));
		pipes.add(new Pipe(800, 0, 50, (int)(Math.random()* 450)));
		pipes.add(new Pipe(1000, 0, 50, (int)(Math.random()* 450)));
		*/
    }
    
	public void drawPipes(Graphics g)
	{
        for (int i = 0; i < pipes.size(); i++) {
        	pipes.get(i).draw(g);;
        }
	}
}
