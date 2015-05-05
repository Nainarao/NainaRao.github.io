import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class StartingPoint extends Applet implements Runnable, KeyListener{

/*	int x = 400;
	int y = 25;
	double dx = 20;
	double dy = 0;
	int radius = 20;*/
	private Image i;
	private Graphics doubleG; 
	Ball b, b2;
	Platform p[] = new Platform[7];

	
	public void init(){
		setSize(800, 600);
		addKeyListener(this);

	}
	
	
	@Override
	public void start() {
		System.out.print("Start");
		b = new Ball();
		b2 = new Ball(250, 250);
		for (int i = 0; i < p.length; i++) {
			Random r = new Random();
			p[i] = new Platform(getWidth() + 200 * i, getHeight() - 40 - r.nextInt(400));
		}
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		while(true) {
			b.update(this);
			b2.update(this);
			for(int i = 0; i < p.length; i ++) {
				p[i].update(this, b);
			}
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	public void update(Graphics g) {
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().width);
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		b.paint(g);
		//b2.paint(g);
		for(int i = 0; i < p.length; i++)  {
			p[i].paint(g);
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println("Test");
	    if(code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP)
	        b.up();
	    else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN)
	        b.down();
	    else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT)
	        b.moveRight();
	    else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT)
	        b.moveLeft();
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
