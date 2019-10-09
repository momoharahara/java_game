package report2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawImage {
	public static void drawXY(Graphics g, BufferedImage Image, int height, int x, int y) {
		//指定した大きさで指定した位置に表示
		int width = Image.getWidth() * height / Image.getHeight();
		g.drawImage(Image, x, y, width, height, Frame.frame);
	}

	public static void drawCenter(Graphics g, BufferedImage Image, int height) {
		//指定した大きさで中央に表示
		int width = Image.getWidth() * height / Image.getHeight();
		g.drawImage(Image, (Frame.width - width) / 2, (Frame.height - height) / 2, width, height, Frame.frame);
	}

	public static void drawCenter(Graphics g, BufferedImage Image, int height, int y) {
		//指定した大きさで指定した高さでに中央に表示
		int width = Image.getWidth() * height / Image.getHeight();
		g.drawImage(Image, (Frame.width - width) / 2, y, width, height, Frame.frame);
	}
}
