package report2;

import java.util.Random;

public abstract class Enemy extends Object {
	//Enemyクラス：敵の設定、更新、描画を行う

	int lifeTime = 0;//敵の生存時間

	Enemy(int x, double vx, double vy, int ImageHeight) {
		//位置xに大きさImageHeightのEnemyを生成する
		super(x, Frame.height - ImageHeight, vx, vy, Frame.enemyImage, ImageHeight);

		//playerの位置と同じ位置に発生しないようにする
		while(hit() == -1) {
			Random rnd = new Random();//乱数発生用
			this.x = rnd.nextInt(Frame.width - this.ImageWidth);
			System.out.println("位置変更しました");
		}

	}

	public int hit() {
		//当たり判定
		if((this.x + this.ImageWidth) - Frame.player.x > 50
				&& (Frame.player.x + Frame.player.ImageWidth) - this.x > 50) {

			if(Frame.player.y + Frame.player.ImageHeight - this.y > 20
					&& Frame.player.y + Frame.player.ImageHeight - this.y < 30
					&& Frame.player.vy > 0) {
				//倒すとき
				return 1;

			} else if(Frame.player.y + Frame.player.ImageHeight - this.y > 30) {
				//ぶつかるとき
				return -1;
			}
		}
		return 0;
	}
}
