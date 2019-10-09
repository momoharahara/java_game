package report2;

import java.awt.Color;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame {
	//フレームの情報設定
	public static JFrame frame;
	public static BufferStrategy bstrategy;//描画する画面情報
	public static int width = 1280;//画面の幅
	public static int height = 720;//画面の高さ

	public static BufferedImage backImage, playerImage, enemyImage,
			reportImage, winImage, loseImage, taniImage_drop, taniImage_title;
	//画像保存用

	public static enum Scene {
		START, INTRODUCTION, GAME, WIN, LOSE, FINISH
	}
	//描画する画面をシーンとして定義

	public static Scene now = Scene.START;
	//現在描画する画面をnowとして管理、START画面から表示する

	//カウント用変数
	public static int passTime = 0;//各シーンでのフレーム数
	public static int leftTime = 30;//残り時間
	public static int deadBeat = 0;//倒した敵数

	//描画オブジェクトを生成
	public static Player player = new Player();
	public static EnemyManager enemymanager = new EnemyManager();

	Frame() {
		frame = new JFrame("単位のためにしめ切りを踏み倒せ！");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//フレーム上の×を押すとプログラム終了
		frame.setBackground(new Color(225, 255, 255));
		//フレームの背景色を指定
		frame.setResizable(false);
		//フレームのサイズ変更不可
		frame.setVisible(true);
		//フレームが見えるようにする
		Insets insets = frame.getInsets();
		//フレームのインセットを取得する
		frame.setSize(width + insets.left + insets.right,
				height + insets.top + insets.bottom);
		//インセットを加えた画面サイズを指定
		frame.setLocationRelativeTo(null);
		//フレームをWindowsの中央に表示
		frame.setIgnoreRepaint(true);
		frame.createBufferStrategy(2);
		bstrategy = frame.getBufferStrategy();

		try {
			//画像の読み込み
			backImage = ImageIO.read(getClass().getResource("moodle_down.png"));//背景画像
			playerImage = ImageIO.read(getClass().getResource("shimekiri_owareru_man3.png"));//Player画像
			enemyImage = ImageIO.read(getClass().getResource("shimekiri2.png"));//しめ切りの画像
			reportImage = ImageIO.read(getClass().getResource("document_report_taba.png"));//レポート画像
			winImage = ImageIO.read(getClass().getResource("school_tani_get_boy2.png"));//単位が取れた人の画像
			loseImage = ImageIO.read(getClass().getResource("school_tani_otosu_boy3.png"));//単位を落とした人の画像
			taniImage_drop = ImageIO.read(getClass().getResource("school_tani.png"));//落ちていく単位の画像
			taniImage_title = ImageIO.read(getClass().getResource("school_text_tani.png"));//タイトル用の単位の画像
			player.set();//生成時に画像がないのでセットする
		} catch (IOException e) {
			e.printStackTrace();
		}

		Timer t = new Timer();
		t.schedule(new MyTimerTask(), 10, 10);
		//10ms後にMyTimerTaskの「10ms固定遅延実行」を繰り返す

		frame.addKeyListener(new MyKeyAdapter());
		//キーボード操作のイベントを取得できるようにする

		frame.addWindowListener(new MyWindowAdapter());
		//終了動作が行えるようにする
	}
}