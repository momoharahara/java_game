package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Game {
	//ゲーム画面を描画するタスクをまとめたクラス
	Game(Graphics g) {
		//プレイヤーを描画
		Frame.player.update();
		Frame.player.draw(g);

		//エネミーを描画
		Frame.enemymanager.update();
		Frame.enemymanager.draw(g);

		//残り時間の処理
		Frame.passTime++;//フレーム数をカウント
		if(Frame.passTime % 100 == 0) {
			Frame.leftTime--;
			if(Frame.leftTime == 0) {
				Frame.now = Frame.Scene.WIN;
				Frame.passTime = 0;
			}
		}
		//10ms遅延実行しているので100フレームで1s残り時間が減る

		//倒した数と残り時間を右上に表示
		g.setColor(Color.WHITE);
		String time = "deadBeat：" + String.valueOf(Frame.deadBeat) + "  time：" + String.valueOf(Frame.leftTime);
		g.setFont(new Font("MS ゴシック", Font.BOLD, 40));
		g.drawString(time, Frame.width - g.getFontMetrics().stringWidth(time) - 10, 40);
		//文字の左下の座標を指定して描画
	}
}
