import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	
	private double gravity = 15;
	private double energyLoss =  1;
	private double xFriction = .9;
	private double dt = .2;
	private int x = 400;
	private int y = 25;
	private double dx = 0;
	private double dy = 0;
	private double gameDy = -75;
	private int radius = 20;
	
	
	public Ball(int i, int j) {
		x = i;
		y = j;
	}
	

	public Ball() {
	}
	
	public double getGameDy() {
		return gameDy;
	}
	
	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}

	public void update(StartingPoint sp) {
		//System.out.println("Update");
		if(x + dx > sp.getWidth() - radius - 1) {
			x = sp.getWidth() - radius - 1; 
			dx = -dx;
		} else if (x + dx < 0 + radius) {
			
			x = 0 + radius;
			dx = -dx;
		}
		else {
			x += dx;
		}
		
		/*if(y + dy > sp.getHeight() - radius) {
			y = sp.getHeight() - radius - 1; 
			dy = - dy;
		} 
		if (y + dy < 0 + radius) {
			y = 0 + radius;
			dy = -dy;
		}else {
			y += dy;
		} */
		
		if ( y == sp.getHeight() - radius - 1) {
			dx *= xFriction;
			if ( Math.abs(dx) < .8) {
				dx = 0;
			}
		}
		
		if ( y > sp.getHeight() - radius - 1) {
			y = sp.getHeight() - radius - 1;
			dy *= energyLoss;
			dy = gameDy;
		} else {
			
			dy += gravity * dt;
			y += dy* dt+ .5*gravity*(dt*dt);	
		} 
			
	}
	
	public void moveRight() {
		System.out.print("RIGHT");
		if (dx + 1 < 20) {
			dx += 2;
		}
	}
	
	public void moveLeft() {
		if (dx-1 > -20) {
			dx -= 2;
		}
	}
	
	public void up() {
		y -= 40;
	}
	
	public void down() {
		y += 40;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}	
	
	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public int getRadius() {
		return radius;
	}
		
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y - radius, radius*2, radius* 2);
	}
}

