
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Instruction extends JPanel implements ActionListener {

	private ScreenMain i;
	private JButton back, start; 
	private String message1, message2, message3;
	
	
	public Instruction(ScreenMain i) {
		super();
		this.i = i;
		JPanel p = new JPanel(); 
		setBackground(Color.WHITE);
		
		back = new JButton(" Back ");
		back.addActionListener(this);
		back.setBackground(Color.WHITE);
		p.add(back);
		add(p);
		
		
		message1 = "Instructions ";
		message2 = "- Press the space bar to start the game";
		message3 = "- Use the space bar or the up arrow key to make the character jump";
		
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
		g.drawString(message1, 250, 50);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 20));
		int strWidth1 = g.getFontMetrics().stringWidth(message2);
		g.drawString(message2, 35, 100);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced",Font.BOLD, 20));
		int strWidth2 = g.getFontMetrics().stringWidth(message3);
		g.drawString(message3, 35, 150);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			i.changePanel("1");
		}
		
	}



}

