import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame("Flappy Bird");
		window.setBounds(100, 100, 600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
		/*
		Window panel = new Window();
		panel.setBackground(Color.CYAN);  // the background color is cyan
		window.add(panel);
        */
		
		window.setVisible(true);

	}

}
