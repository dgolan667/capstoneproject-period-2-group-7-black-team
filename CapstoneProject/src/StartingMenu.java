import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StartingMenu extends JPanel implements ActionListener {
	
	private ScreenMain a;
	private JButton button, instructions; 
	
		public StartingMenu(ScreenMain a) {
			
			this.a = a;
			JPanel p = new JPanel();
			
			
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.add(Box.createVerticalStrut(300));
			
			button = new JButton("Play the Game!");
			button.addActionListener(this);
			p.add(button);
			add(p);
			
			instructions = new JButton(" Instructions ");
			instructions.addActionListener(this);
			p.add(instructions);
			
		}
		

		
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				a.changePanel("2");
			} else if (e.getSource() == instructions) {
				a.changePanel("3");
			}
		}

}
