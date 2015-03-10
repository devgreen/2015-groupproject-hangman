package hangman;

import java.io.FileNotFoundException;

public class HangmanMain {

	public static void main(String[] args) {
		HangmanFrame frame;
		try {
			frame = new HangmanFrame();
			frame.setVisible(true);
			GameLoopThread t = new GameLoopThread(frame);
			t.start();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
