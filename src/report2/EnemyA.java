package report2;

public class EnemyA extends Enemy {
	//EnemyA:左右に歩き回るタイプの敵
	EnemyA(int x, int imageHeight) {
		super(x, 5, 0, imageHeight);
	}

	@Override
	public void update() {
		if(x < 0) {
			//左端に到達したら、左端から右方向に進むように設定
			x = 0;
			vx = 5;
		} else if(x > Frame.width - this.ImageWidth) {
			//右端に到達したら、右端から左方向に進むように設定
			x = Frame.width - this.ImageWidth;
			vx = -5;
		}
		//x方向に進む
		x += vx;
		lifeTime++;//生存時間経過
	}
}