package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Lose extends Result {
	//単位を落とした場合の結果画面を描画するタスクをまとめたクラス
	Lose(Graphics g) {
		super(g);//選択肢表示

		//結果表示
		g.setColor(Color.RED);
		g.setFont(new Font("HGS行書体", Font.PLAIN, 580));
		g.drawString("不 可", -20, 600);

		//グラフィック描画
		DrawImage.drawCenter(g, Frame.loseImage, 500);
		//単位を落とした人を描画
		if(Frame.passTime < Frame.height) {
			DrawImage.drawCenter(g, Frame.taniImage_drop, 500, Frame.passTime);
			//1フレームごとに単位が落ちていく
		}
	}
}
