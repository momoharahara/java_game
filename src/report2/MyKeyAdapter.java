package report2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
	//Keybord入力が押されているか押されていないかの判定を行っている

	public static boolean spacekey = false,
			right = false,
			left = false,
			enter = false;

	@Override
	public void keyPressed(KeyEvent e) {
		//押された場合押したKeyをtrueに
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacekey = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//離された場合に離したKeyをfalseに
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacekey = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
	}
}