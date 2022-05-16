import javax.swing.JButton;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import java.awt.event.*;


public class Menu extends  JPanel implements ActionListener{
    // FIELDS
	private int score;
	private JButton button1, button2;
	private StartingMenu Menu;
	private String message;
	
	private SimpleWindow Window;
	
	JLabel guest = new JLabel("Guest");
	
	
	public Menu (ScreenMain S) {
		super();
		message = "Score"+ score;
		
	}
	
	
	
	static void ScreenMain(){
		ScreenMain();
	}
	
	static void Character() {
		Character();
	}
	
	
	public Menu() {
		score = 0;
		button1 = new JButton("Restart");
		button1.addActionListener(this);
		button2 = new JButton("Character");	
		button2.addActionListener(this);
		
		Container c = getRootPane();
		c.setLayout(new FlowLayout());
		c.add(button1);
		c.add(button2);
		
		
	}

	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==(button1))
		{
		ScreenMain();
		}
		else if(e.getSource()==(button2)) {
		Character();	
		}
	}
	
	
	
	// CONSTRUCTORS
	
	
	
	// METHODS
}
