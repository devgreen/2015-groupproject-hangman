package hangman;

public class GameLoopThread extends Thread {

	//private HangmanComponent hangman;
	private HangmanFrame frame;
	/*public GameLoopThread(HangmanComponent hangman){
		this.hangman = hangman;
	}
	*/
	public GameLoopThread(HangmanFrame frame){
	//	this.hangman = hangman;
		this.frame = frame;
	}
	
	public void run() {
		while (true) {
			frame.getHangmanComp().repaint();
			//hangman.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
