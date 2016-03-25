package snake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class File extends Applet implements Runnable,KeyListener{
	private URL base;
	private Image body,head,image;
	private int a,b;
	private Graphics second;
	private BufferedImage img;
	private Snake snake;
	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.YELLOW);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
	    frame.setTitle("First Game");
	    addKeyListener(this);
	    
	    //frame.setBackground(Color.RED);
	    try {
			base=getDocumentBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	    body=getImage(base,"data/body.png");
	    try {
			img = ImageIO.read(getClass().getResource("/data/body.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	@Override
	public void start(){
		snake = new Snake();
		Thread thread = new Thread(this);
		thread.start();
	}
	@Override
	public void stop(){
		super.stop();
	}
	@Override
	public void destroy(){
		super.destroy();
	}
	public void paint(Graphics g){
		g.drawImage(body,snake.getPx(0),snake.getPy(0),this);
		g.drawImage(body,snake.getPx(1),snake.getPy(1),this);
		g.drawImage(body,snake.getPx(2),snake.getPy(2),this);
		g.drawImage(body,snake.getPx(3),snake.getPy(3),this);
		g.drawImage(body,snake.getPx(4),snake.getPy(4),this);
		g.drawImage(body,snake.getPx(5),snake.getPy(5),this);
		g.drawImage(body,snake.getPx(6),snake.getPy(6),this);
	}
	
	public void run(){
		while (true){
			snake.update();
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}


		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);


		g.drawImage(image, 0, 0, this);

		
	}
	@Override
    public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            snake.setDirection('u');
            break;

        case KeyEvent.VK_DOWN:
            snake.setDirection('d');
            break;

        case KeyEvent.VK_LEFT:
            snake.setDirection('l');
            break;

        case KeyEvent.VK_RIGHT:
            snake.setDirection('r');
            break;

        }

    }
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
