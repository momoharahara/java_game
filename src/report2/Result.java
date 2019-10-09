package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Result {
	//結果画面でのシーン遷移処理をまとめたクラス
	Result(Graphics g) {
		//結果表示の際にリトライするか終了するかを
		//選択する部分について実装しているタスク

		//選択肢表示
		g.setColor(Color.WHITE);
		g.setFont(new Font("MS ゴシック", Font.PLAIN, 50));
		g.drawString("Retry：Press SpaceKey", 50, 700);
		g.drawString("Quit：Press EnterKey", 690, 700);

		//キーボード入力によって選択、遷移
		if(MyKeyAdapter.spacekey && Frame.passTime > 50) {
			//結果画面に遷移してから0.5s経過し、
			//スペースキーが押されている場合ゲーム画面に遷移
			Frame.now = Frame.Scene.GAME;
			Frame.passTime = 0;//経過時間リセット

			//各変数をリセット
			Frame.leftTime = 30;
			Frame.deadBeat = 0;
			Frame.player.set();
			//プレイヤーの位置やライフをリセット
			Frame.enemymanager.enemies.clear();
			//敵情報をリセット
		} else if(MyKeyAdapter.enter) {
			Frame.now = Frame.Scene.FINISH;
		}
		Frame.passTime++;//フレーム数カウント
	}
}