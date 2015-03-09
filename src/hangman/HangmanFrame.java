package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HangmanFrame extends JFrame implements KeyListener {

	private JPanel letters;
	private JPanel word;
	private JButton restart;
	private Container container;
	private HangmanWorld world;
	private JTextField userInput;
	private JPanel north;
	private JButton enter;
	private JButton restart2;

	public HangmanFrame() throws FileNotFoundException {
		this.setSize(800, 600);
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(this);
		this.setFocusable(true);

		container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.CYAN);

		restart = new JButton("restart");
		restart.addActionListener(restartListener);

		letters = new JPanel();
		letters.setLayout(new GridLayout(0, 2));
		word = new JPanel();
		word.setLayout(new FlowLayout());
		word.setBorder(new EmptyBorder(10, 10, 10, 10));
		world = new HangmanWorld(letters, word);

		String[] options = { "Computer", "2 Players" };
		int option = JOptionPane.showOptionDialog(this, "Choose how you would like to play", "Number of Players",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		switch (option) {
		case 0:

			container.add(letters, BorderLayout.WEST);
			container.add(word, BorderLayout.SOUTH);
			container.add(world, BorderLayout.CENTER);
			container.add(restart, BorderLayout.NORTH);

			break;
		case 1:
			north = new JPanel();
			north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
			enter = new JButton("Enter");
			enter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String userWord = userInput.getText().toUpperCase();
					if (userWord.length() < 4) {
						userInput.setText("Word too short. Enter word minimum of 4 characters");

					} else {
						userInput.setText("");
						world = new HangmanWorld(userWord, letters, word);
						container.add(world, BorderLayout.CENTER);
						container.add(word, BorderLayout.SOUTH);
						userInput.transferFocusBackward();

					}
				}

			});

			restart2 = new JButton("Restart");
			restart2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					userInput.setText("Must be a minimum of 4 letters");
					world.resetGame2(word);

				}

			});
			userInput = new JTextField("Must be a minimum of 4 letters");
			north.add(userInput);
			north.add(enter);
			north.add(restart2);
			container.add(north, BorderLayout.NORTH);
			container.add(letters, BorderLayout.WEST);

			break;
		}

	}

	ActionListener restartListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			world.resetGame(word);
			container.transferFocusBackward();

		}

	};



	public HangmanWorld getHangmanWorld() {
		return world;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		world.keyBoardInput(e.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
