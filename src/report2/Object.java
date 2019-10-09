package report2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract class Object {
	//描画したいオブジェクトのabstractクラス
	BufferedImage Image;//描画したいオブジェクトの画像
	int ImageWidth, ImageHeight;//画像を表示したいサイズ
	int x, y;//描画したい画像の左上の位置座標
	double vx, vy;//動く速度

	Object(int x, int y, double vx, double vy, BufferedImage Image, int ImageHeight) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.ImageHeight = ImageHeight;//表示する高さ
		if(Image != null) {
			//出力画像の設定（生成時に画像が決まっている場合）
			this.Image = Image;
			this.ImageWidth = Image.getWidth() * ImageHeight / Image.getHeight();
			//表示する幅
		}
	}

	public void setImage(BufferedImage Image) {
		//出力画像の再設定（生成時に画像が決まっていない場合など）
		this.Image = Image;
		this.ImageWidth = Image.getWidth() * ImageHeight / Image.getHeight();
		//表示する幅
	}

	abstract void update();//情報更新

	public void draw(Graphics g) {
		//Objectの描画
		try {
			if(this.vx > 0.0) {
				g.drawImage(Image, x + ImageWidth, y, -ImageWidth, ImageHeight, Frame.frame);//反転して右向きに描画
			} else {
				g.drawImage(Image, x, y, ImageWidth, ImageHeight, Frame.frame);//左向きに描画
			}

		} catch (NullPointerException e) {
			System.err.println("出力画像が設定されていません。");
		}
	}
}