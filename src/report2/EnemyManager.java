package report2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import report2.Frame.Scene;

public class EnemyManager {
	//EnemyManagerクラス：Enemyを管理

	List<Enemy> enemies = new ArrayList<>();//管理用リスト

	public void update() {

		generate();//敵生成

		//Enemyの情報更新
		for(Enemy enemy : enemies) {
			enemy.update();
		}

		hit();//当たり判定
	}

	public void draw(Graphics g) {
		//Enemyを描画
		for(Enemy enemy : enemies) {
			enemy.draw(g);
		}
	}

	public void generate() {
		//Enemy生成
		Random rnd = new Random();//乱数発生用
		if(rnd.nextInt(1000) < 1) {
			enemies.add(new EnemyA(rnd.nextInt(Frame.width - 200), 200));
			System.out.println("EnemyAを生成しました");
		}
		if(rnd.nextInt(1000) < 1) {
			enemies.add(new EnemyB(rnd.nextInt(Frame.width - 200), 200));
			System.out.println("EnemyBを生成しました");
		}
		if(rnd.nextInt(1000) < 1) {
			enemies.add(new EnemyC(rnd.nextInt(Frame.width - 200), 200));
			System.out.println("EnemyCを生成しました");
		}
		if(enemies.size() == 0) {
			//画面上に敵がいないとき生成
			enemies.add(new EnemyA(rnd.nextInt(Frame.width - 200), 200));
			System.out.println("EnemyAを生成しました");
		}
	}

	public void hit() {
		//Enemyとの当たり判定
		boolean flag = false;//倒したとき立つ
		for(int i = 0; i < enemies.size();) {
			if(enemies.get(i).hit() == 1) {
				//倒したときはその要素を削除
				enemies.remove(i);
				System.out.println("Enemyを倒しました。");
				Frame.deadBeat++;
				flag = true;
			} else if(enemies.get(i).hit() == -1 && enemies.get(i).lifeTime > 30) {
				//ぶつかったときはレポートを奪って敵が消える
				Frame.player.reports.remove(Frame.player.reports.size() - 1);
				enemies.remove(i);
				if(Frame.player.reports.size() == 0) {
					Frame.now = Scene.LOSE;//持ってるレポートがなくなったら負け

					Frame.passTime = 0;
				}

			} else {
				i++;
			}
		}
		if(flag == true) {
			Frame.player.vy = -11;//倒したときは跳ね返る
		}
	}
}