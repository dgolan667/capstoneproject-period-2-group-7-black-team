
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Instruction extends JPanel implements ActionListener {

	private ScreenMain i;
	private JButton start; 
	private String message1, message2, message3, message4;
	
	
	public Instruction(ScreenMain i) {
		super();
		this.i = i;
		JPanel p = new JPanel(); 
		
		start = new JButton(" Start ");
		start.addActionListener(this);
		start.setBackground(Color.WHITE);
		p.add(start);
		add(p);

		message1 = "Instructions ";
		message2 = "- Press the space bar to start the game";
		message3 = "- Jump: Use the space bar or the up arrow key";
		message4 = "- Collect coins to get points"; 
	}
	
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
        
		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/800.0;
		double ratioY = (double)height/600.0;
		g2.scale(ratioX, ratioY);

		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 30));
		int strWidth = g.getFontMetrics().stringWidth(message1);
		g.drawString(message1, 300, 70);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 20));
		int strWidth1 = g.getFontMetrics().stringWidth(message2);
		g.drawString(message2, 35, 130);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 20));
		int strWidth2 = g.getFontMetrics().stringWidth(message3);
		g.drawString(message3, 35, 180);
		
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 20));
		int strWidth3 = g.getFontMetrics().stringWidth(message3);
		g.drawString(message4, 35, 230);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			i.changePanel("2");
		}
		
	}



}

