package report2;

import java.awt.Graphics;
import java.awt.Insets;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	//TimerTaskを継承して毎フレーム実行させたいタスクを加えている

	@Override
	public void run() {
		Graphics g = Frame.bstrategy.getDrawGraphics();

		if(Frame.bstrategy.contentsLost() == false) {

			Insets insets = Frame.frame.getInsets();//フレームのインセットを取得
			g.translate(insets.left, insets.top);//インセットの分だけ描画位置を平行移動

			g.drawImage(Frame.backImage, 0, 0, Frame.width, Frame.height, Frame.frame);//背景描画

			//描画開始
			switch (Frame.now) {
			//nowによってシーン判別
			case START:
				//スタート画面描画
				Start start = new Start(g);
				break;
			case INTRODUCTION:
				//説明画面描画
				Introduction introduction = new Introduction(g);
				break;
			case GAME:
				//ゲーム画面描画
				Game game = new Game(g);
				break;
			case WIN:
				//単位が取れた場合の結果画面描画
				Win win = new Win(g);
				break;
			case LOSE:
				//単位を落とした場合の結果画面描画
				Lose lose = new Lose(g);
				break;
			case FINISH:
				//プログラムを終了
				MyWindowAdapter close = new MyWindowAdapter();
				close.windowClosing(null);
			default:
				break;
			}
			Frame.bstrategy.show();
			g.dispose();
		}
	}
}