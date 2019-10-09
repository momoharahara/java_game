package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import report2.Frame.Scene;

public class Start {
	//Start画面を描画するタスクをまとめたクラス
	public Start(Graphics g) {
		g.clearRect(0, 0, Frame.width, Frame.height);//背景削除

		//title表示
		DrawImage.drawXY(g, Frame.taniImage_title, 300, 50, 50);
		//単位を描画
		DrawImage.drawXY(g, Frame.enemyImage, 300, 200, 350);
		//締め切りを描画
		g.setColor(Color.BLACK);
		//文字カラー指定
		g.setFont(new Font("MS ゴシック", Font.ITALIC, 100));
		//文字フォント指定
		String title1 = "のために";
		g.drawString(title1, 600, 300);
		//文字の左下の座標を指定して描画
		String title2 = "を踏み倒せ！";
		g.drawString(title2, Frame.width - g.getFontMetrics().stringWidth(title2) - 100, 600);

		//シーン遷移処理
		g.setFont(new Font("Arial", Font.PLAIN, 50));
		//文字フォント指定
		String pressKey = "-Press EnterKey-";
		g.drawString(pressKey, (Frame.width - g.getFontMetrics().stringWidth(pressKey)) / 2, Frame.height - 20);
		if(MyKeyAdapter.enter) {
			//EnterKeyを押すと説明画面に遷移
			Frame.now = Scene.INTRODUCTION;
		}
	}
}
