import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StartingMenu extends JPanel implements ActionListener {
	
	private ScreenMain a;
	
		public StartingMenu(ScreenMain a) {
			this.a = a;
			JPanel p = new JPanel();
			JPanel p1 = new JPanel();
			
			
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.add(Box.createVerticalStrut(300));
			
			JButton button = new JButton("Play the Game!");
			button.addActionListener(this);
			p.add(button);
			add(p);
			
			
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.add(Box.createVerticalStrut(300));
			
			JButton button1 = new JButton("Character");
			button1.addActionListener(this);
			p1.add(button1);
			add(p1);
			
		}
	
		public void actionPerformed(ActionEvent e) {
			a.changePanel("2");
		}
	

}
