package report2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		//プログラムを終了する
		System.exit(0);
	}
}
