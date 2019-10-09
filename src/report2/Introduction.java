package report2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Introduction {
	//説明画面を描画するタスクをまとめたクラス
	public Introduction(Graphics g) {
		//説明文表示
		g.setColor(Color.WHITE);
		g.setFont(new Font("MS ゴシック", Font.PLAIN, 50));
		g.drawString("←ライフ", 300, 50);
		g.drawString("操作方法", 700, 250);
		g.drawString("ジャンプ：スペースキー", 700, 350);
		g.drawString("移動：左右キー", 700, 450);

		//プレイヤーを描画
		Frame.player.update();
		Frame.player.draw(g);

		//シーン遷移処理
		g.setFont(new Font("Arial", Font.PLAIN, 50));
		//文字フォント指定
		String pressKey2 = "-Press EnterKey-";
		g.drawString(pressKey2, (Frame.width - g.getFontMetrics().stringWidth(pressKey2)) / 2, Frame.height - 20);
		Frame.passTime++;//このシーンでの経過時間をカウント
		if(Frame.passTime > 50) {
			//0.5s経過していたらシーン遷移処理を開始
			if(MyKeyAdapter.enter) {
				//EnterKeyを押すとゲーム画面へ遷移
				Frame.passTime = 0;//経過時間を初期化
				Frame.player.set();//プレイヤー情報をリセット
				Frame.now = Frame.Scene.GAME;//ゲームシーンへ遷移
			}
		}
	}
}
