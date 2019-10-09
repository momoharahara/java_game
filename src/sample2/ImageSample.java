package sample2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageSample {
	JFrame frame;
	BufferStrategy bstrategy;
	int x = 0;
	int y = 0;
	boolean spacekey = false;
	double vy = 0.0;
	double vx = 3.0;
	int width = 1280;
	int height = 720;
	int itemWidth = 150;
	int itemHeight = 100;

	BufferedImage itemImage, backImage;

	ImageSample() {
		frame = new JFrame("MyWindow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(225, 255, 255));
		frame.setResizable(false);
		frame.setVisible(true);
		Insets insets = frame.getInsets();
		frame.setSize(width + insets.left + insets.right,
				height + insets.top + insets.bottom);
		frame.setLocationRelativeTo(null);
		frame.setIgnoreRepaint(true);
		frame.createBufferStrategy(2);
		bstrategy = frame.getBufferStrategy();

		try {
			itemImage = ImageIO.read(getClass().getResource("shimekiri_owareru_man.png"));
			backImage = ImageIO.read(getClass().getResource("hakuba.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Timer t = new Timer();
		t.schedule(new MyTimerTask(), 10, 30);

		frame.addKeyListener(new MyKeyAdapter());
	}

	class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			Graphics g = bstrategy.getDrawGraphics();
			if(bstrategy.contentsLost() == false) {
				Insets insets = frame.getInsets();
				g.translate(insets.left, insets.top);
				if(spacekey == true) {
					vy = vy - 0.25;
				} else {
					vy = vy + 0.25;
				}
				y += (int) vy;

				if(y < 0) {
					y = 0;
					vy = 0;
				} else if(y > height - itemHeight) {
					y = height - itemHeight;
					vy = -11;
				}

				if(x < 0) {
					vx = 3;
				} else if(x > width - itemWidth) {
					vx = -3;
				}
				x += (int) vx;

				g.clearRect(0, 0, width, height);
				g.drawImage(backImage, 0, 0, frame);

				g.setColor(new Color(225, 255, 255));
				g.fillOval(x, y, itemWidth + 10, itemHeight + 10);

				g.drawImage(itemImage, x, y, frame);

				String title = "Programmed by Y.Horiuchi";
				g.setFont(new Font("SansSerif", Font.BOLD, 20));
				g.drawString(title, width - g.getFontMetrics().stringWidth(title) - 10, height - 10);

				bstrategy.show();
				g.dispose();
			}
		}
	}

	class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				spacekey = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				spacekey = false;
			}
		}
	}
}