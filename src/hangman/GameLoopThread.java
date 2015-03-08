package hangman;

public class GameLoopThread extends Thread {

	private HangmanFrame frame;

	public GameLoopThread(HangmanFrame frame) {
		this.frame = frame;
	}

	public void run() {
		while (true) {
			frame.getHangmanWorld().repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
