import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Platform {

	int dx;
	int x, y, width, height;
	
	public Platform() {
		// TODO Auto-generated constructor stub
		dx = -5;
		x = 300;
		y = 300; 
		width = 120;
		height = 40;
	}
	
	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		width = 120;
		height = 40;
		dx = -5;
	}
	
	public void update(StartingPoint sp, Ball b) {
			x += dx;
			checkCollision(b); 
			if(x < 0 - width) {
				Random r = new Random();
				x = sp.getWidth() + r.nextInt(300);
				y = r.nextInt(800);
			}
	}
	
	private void checkCollision(Ball b) {
		int bx = b.getX();
		int by = b.getY();
		int rad = b.getRadius();
		if (by + rad > y && by + rad < y + height) {
			if (bx > x && bx < x + width){
				
				
				double newDY = b.getGameDy();
				b.setY(y - rad);
				b.setDy(newDY);
			}
		}
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
}
