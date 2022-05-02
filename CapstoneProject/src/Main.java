import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		/*
		JFrame window = new JFrame("Banner");

		window.setBounds(300, 300, 200, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingSurface panel = new DrawingSurface();
		panel.setBackground(Color.WHITE);  // the default color is light gray
		window.add(panel);

		window.setVisible(true);
        */
		
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window panel = new Window();
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);

		panel.run();

	}

}
