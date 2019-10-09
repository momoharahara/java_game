package report2;

public class EnemyB extends Enemy {
	//EnemyB:飛び跳ねるタイプの敵
	EnemyB(int x, int ImageHeight) {
		super(x, 0, -11, ImageHeight);
	}

	@Override
	public void update() {
		//着地したら飛び跳ねるのを繰り返す
		if(y > Frame.height - ImageHeight) {
			y = Frame.height - ImageHeight;
			vy = -11;
		}
		vy += 0.25;
		y += vy;
		lifeTime++;
	}
}
