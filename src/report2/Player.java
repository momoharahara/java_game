package report2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Player extends Object {
	//Playerクラス：自機の設定、更新、描画を行う

	public List<Report> reports = new ArrayList<>();
	//ライフとしてレポートを持つ

	Player() {
		super(Frame.width, Frame.height, 0, 0, null, 300);
		//生成時に画像が読み込まれていないので、
		//高さ300のオブジェクトとしてだけ生成しておく
	}

	public void set() {
		//プレイヤー情報(画像、位置情報、速度、ライフ)をセットするメソッド
		super.setImage(Frame.playerImage);
		x = Frame.width - ImageWidth;
		y = Frame.height - ImageHeight;
		vx = 0;
		vy = 0;
		setReport();
	}

	public void setReport() {
		//ライフを5つ持たせる
		for(int i = reports.size(); i < 5; i++) {
			reports.add(new Report(60 * i, 60));
		}
	}

	@Override
	public void update() {
		//spacekeyでジャンプ
		if(MyKeyAdapter.spacekey == true && y == Frame.height - ImageHeight) {
			//地面の位置にいるときにスペースキーが押されたら上方向への初速度をもたせる
			vy = -15;
		} else {
			//1フレームごとに下方向への加速度を加える
			vy = vy + 0.25;
		}
		y += (int) vy;//現在位置から速度の分進む

		//左右キーで移動
		if(MyKeyAdapter.right == true) {
			//右方向キーが押されていたら右方向に速度を持つ
			vx = 5;
		} else if(MyKeyAdapter.left == true) {
			//左方向キーが押されていたら左方向に速度を持つ
			vx = -5;
		} else {
			//それ以外の場合は停止するので速度0に
			vx = 0;
		}
		x += (int) vx;//現在位置から速度の分進む

		//画面範囲外の場合修正
		if(y < 0) {
			y = 0;
			vy = 0;
		} else if(y > Frame.height - ImageHeight) {
			y = Frame.height - ImageHeight;
			vy = 0;
		}
		if(x < 0) {
			x = 0;
		} else if(x > Frame.width - ImageWidth) {
			x = Frame.width - ImageWidth;
		}
	}

	@Override
	public void draw(Graphics g) {
		//人物の描画
		super.draw(g);

		//ライフのreportsの描画
		try {
			for(Report report : reports) {
				report.draw(g);
			}

		} catch (NullPointerException e) {
			System.err.println("出力画像が設定されていません。");
		}
	}
}