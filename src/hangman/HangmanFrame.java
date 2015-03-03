package hangman;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HangmanFrame extends JFrame {

	private JPanel letters;
	private JPanel word;
	private Alphabet alph;
	private Word currentWord;
	private JLabel[] line;
	private int width;
	private int height;
	private HangmanComponent hangmanComp;
	private JButton restart;
	private Container container;
	private boolean gameOver;

	public HangmanFrame() throws FileNotFoundException {
		this.setSize(800, 600);
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameOver = false;
		restart = new JButton("restart");
		 container = getContentPane();
		container.setLayout(new BorderLayout());


		letters = new JPanel();
		letters.setLayout(new GridLayout(0, 2));

		alph = new Alphabet();
		setButtons();

		word = new JPanel();
		word.setLayout(new FlowLayout());
		word.setBorder(new EmptyBorder(10, 10, 10, 10));

		currentWord = new Word();
		setLines();

		width =this.getWidth();
		 height =  this.getHeight();
		hangmanComp = new HangmanComponent(width, height);
		container.add(letters, BorderLayout.WEST);
		container.add(word, BorderLayout.SOUTH);
		container.add(hangmanComp, BorderLayout.CENTER);

		
	}

	ActionListener checkLetter = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button.equals(restart)) {
				hangmanComp = new HangmanComponent(width, height);
				
			} else {

				ArrayList<Integer> there = contains(button);
				if (!there.isEmpty()) {
					for (int i = 0; i < there.size(); i++) {
						line[there.get(i)].setText(button.getText());
					}

				} else {
					if(hangmanComp.person.getNumOuts()<6){
						hangmanComp.person.setNumOuts();
					}
					else{
					//	gameOver = true;
						gameOver();
					}

				}
			}
		}

		private void gameOver() {
			container.add(restart, BorderLayout.CENTER);

		}

	};

	public ArrayList<Integer> contains(JButton button) {
		// boolean there = false;
		ArrayList<Integer> places = new ArrayList<Integer>();
		String word = currentWord.getCurrWord();
		String letter = button.getText();
		char character = letter.charAt(0);
		for (int i = 0; i < word.length(); i++) {

			if (character == word.charAt(i)) {
				places.add(i);
			}

		}
		return places;
	}

	public void setButtons() {
		JButton[] alphabet = alph.getLetters();

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i].addActionListener(checkLetter);
			letters.add(alphabet[i]);

		}

	}

	public void setLines() {
		line = currentWord.getLines();

		for (int j = 0; j < line.length; j++) {
			word.add(line[j]);
		}

	}

	public static void main(String[] args) {
		try {
			HangmanFrame frame;

			frame = new HangmanFrame();
			frame.setVisible(true);
			// int w = frame.getWidth();
			// int h = frame.getHeight();
			/*
			 * Thread t = new Thread() {// making an anonymous class ,a class //
			 * within a // class public void run() { while (true) {
			 * frame.repaint(); try { Thread.sleep(40);// gonna stop thread and
			 * 100 // milisecond // which is 1 second } catch
			 * (InterruptedException e) { e.printStackTrace(); } } } };
			 * 
			 * t.start();
			 */
			GameLoopThread t = new GameLoopThread(frame);

			// GameLoopThread t = new GameLoopThread(frame.getHangmanComp());
			t.start();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HangmanComponent getHangmanComp() {
		return hangmanComp;
	}
}
