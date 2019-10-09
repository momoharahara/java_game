package report2;

public class EnemyC extends Enemy {
	//EnemyC:近寄ってくるタイプの敵
	EnemyC(int x, int ImageHeight) {
		super(x, 0, 0, ImageHeight);
	}

	@Override
	public void update() {
		//playerがいる方向に進む
		if((this.x + this.ImageWidth) - Frame.player.x <= 50) {
			vx = 3.0;
		} else if((Frame.player.x + Frame.player.ImageWidth) - this.x <= 50) {
			vx = -3.0;
		}
		x += vx;
		lifeTime++;
	}
}