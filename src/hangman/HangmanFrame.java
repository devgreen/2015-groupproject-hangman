package hangman;

import java.awt.BorderLayout;
import java.awt.Component;
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
	private JButton restart;
	private Container container;
	private HangmanWorld world;

	public HangmanFrame() throws FileNotFoundException {
		this.setSize(800, 600);
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new BorderLayout());

		restart = new JButton("restart");
		restart.addActionListener(restartListener);

		letters = new JPanel();
		letters.setLayout(new GridLayout(0, 2));
		word = new JPanel();
		word.setLayout(new FlowLayout());
		word.setBorder(new EmptyBorder(10, 10, 10, 10));
		world = new HangmanWorld(letters, word);

		container.add(letters, BorderLayout.WEST);
		container.add(word, BorderLayout.SOUTH);
		container.add(world, BorderLayout.CENTER);
		container.add(restart, BorderLayout.NORTH);
	}

	ActionListener restartListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			world.resetGame(word);
		}

	};

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

	public HangmanWorld getHangmanWorld() {
		return world;
	}

}
