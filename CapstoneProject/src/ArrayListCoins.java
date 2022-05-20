import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayListCoins {
    private ArrayList <Coin> coins;
    private boolean b;

    public ArrayListCoins() {
    	super();
    	coins = new ArrayList <Coin> ();
    	
    	int x = 750;
    	int y = (int)(600* Math.random());
    	for (int i = 0; i < 200; i++) { 
    		coins.add(new Coin(x, y));
    		x += 20 *(int)(10*Math.random());
    		y = (int)(600* Math.random());
    	}
    }

    
	public void drawCoins(Graphics g) {
        for (int i = 0; i < coins.size(); i++) {
        	
        	coins.get(i).drawCoin(g);
        }
	}
	
	public void move () {
		for (int i = 0; i < coins.size(); i++) {
			coins.get(i).move();
		}
	}

	public boolean checkCoinCollision (Jumper bird) {
		b = false;
		for (Coin coin : coins) {
			if ((bird.turnToRectangle()).intersects(coin.turnCoinToRectangle())) {
				b = true;
				coin.moveDown();
			}
		}
		
		return b;
	}
}