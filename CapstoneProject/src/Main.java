import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Component;


public class Main extends JPanel {
	
    public Main() {
		super();
		Color LBLUE = new Color (51, 153, 255); 
		setBackground(LBLUE);
	}
	
	public static void main(String[] args) {

		JFrame window = new JFrame("Flappy Bird");
		window.setBounds(50, 50, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main panel = new Main();  
        window.add(panel);
		window.setResizable(false);
		window.setVisible(true);
		
		Window gameWindow = new Window();
		//window.add(gameWindow);
	}

}
