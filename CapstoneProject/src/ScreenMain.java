import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ScreenMain extends JFrame{
	
	JPanel BirdPanel;
	
	public ScreenMain(String title) {
		super(title);
		setBounds(50, 50, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    BirdPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    BirdPanel.setLayout(cl);
	    
		StartingMenu panel1 = new StartingMenu(this);    
	    SimpleWindow panel2 = new SimpleWindow(this);
	    
	    
	
	    BirdPanel.add(panel1,"1"); 
	    BirdPanel.add(panel2,"2"); 
	    
	    add(BirdPanel);
	    addKeyListener(panel2);
	
	    setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		ScreenMain a = new ScreenMain("FlappyBird");
		//app upper name
	}
  
	public void changePanel(String name) {
		((CardLayout)BirdPanel.getLayout()).show(BirdPanel,name);
		requestFocus();
	}

}
