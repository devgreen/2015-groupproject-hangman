package hangman;

public class GameLoopThread extends Thread {

	private HangmanComponent hangman;
	
	public GameLoopThread(HangmanComponent hangman){
		this.hangman = hangman;
	}
	
	public void run() {
		while (true) {
			hangman.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
