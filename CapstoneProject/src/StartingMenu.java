import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StartingMenu extends JPanel implements ActionListener {
	
	private ScreenMain a;
	private JButton play, instructions; 
	
		public StartingMenu(ScreenMain a) {		
			this.a = a;
			JPanel p = new JPanel();
					
			//p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.add(Box.createVerticalStrut(200));

			play = new JButton("Play the Game!");
			play.addActionListener(this);
			p.add(play);
			
			instructions = new JButton(" Instructions ");
			instructions.addActionListener(this);
			p.add(instructions);
			
			add(p);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == play) {
				a.changePanel("2");
			} else if (e.getSource() == instructions) {
				a.changePanel("3");
			}
		}
}
