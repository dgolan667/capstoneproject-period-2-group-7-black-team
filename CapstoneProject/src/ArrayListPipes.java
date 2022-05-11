import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListPipes {
    // FIELDS
	private ArrayList <Pipe> pipes;
	
	// CONSTRUCTORS
	public ArrayListPipes () {
		super();
		pipes = new ArrayList<Pipe>();
	}
	
	// METHODS
	public void drawPipes (Graphics g) {
		super.drawPipe(g);
	}
}
