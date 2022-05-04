import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	
	public Main () {
		super();
		setBackground(Color.CYAN);
	}
	
	public static void main(String[] args) {
		JFrame w = new JFrame("Window");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main panel = new Main();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		
		

	}

}
