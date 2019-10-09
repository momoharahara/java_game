package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Win extends Result {
	//単位がとれた場合の結果画面を描画するタスクをまとめたクラス
	Win(Graphics g) {
		super(g);//選択肢表示

		//評定結果表示
		g.setColor(Color.BLACK);
		g.setFont(new Font("HGS行書体", Font.PLAIN, 580));
		if(Frame.deadBeat >= 15) {
			g.drawString("秀", 640, 600);
		} else if(Frame.deadBeat >= 10) {
			g.drawString("優", 640, 600);
		} else if(Frame.deadBeat >= 5) {
			g.drawString("良", 640, 600);
		} else {
			g.drawString("可", 640, 600);
		}

		//単位が取れた人を描画
		DrawImage.drawXY(g, Frame.winImage, Frame.height - 50, 50, 0);
	}
}
