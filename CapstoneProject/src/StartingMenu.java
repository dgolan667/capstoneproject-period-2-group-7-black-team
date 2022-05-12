import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StartingMenu extends JPanel implements ActionListener {
	
	private ScreenMain a;
	
		public StartingMenu(ScreenMain a) {
			this.a = a;
			JPanel p = new JPanel();
			
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.add(Box.createVerticalStrut(300));
			
			JButton button = new JButton("Play the Game!");
			button.addActionListener(this);
			p.add(button);
			add(p);
			
		}
	
		public void actionPerformed(ActionEvent e) {
			a.changePanel("2");
		}
	

}
