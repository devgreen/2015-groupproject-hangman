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
	private JPanel wordPanel;
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

		userInput = new JTextField();

		restart = new JButton("Restart");
		restart.addActionListener(restartListener);

		letters = new JPanel();
		letters.setLayout(new GridLayout(0, 2));
		wordPanel = new JPanel();
		wordPanel.setLayout(new FlowLayout());
		wordPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		world = new HangmanWorld(letters, wordPanel);

		String[] options = { "Computer", "2 Players" };
		int option = JOptionPane.showOptionDialog(this, "Choose how you would like to play", "Number of Players",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		switch (option) {
		case 0:

			container.add(letters, BorderLayout.WEST);
			container.add(wordPanel, BorderLayout.SOUTH);
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
						world = new HangmanWorld(userWord, letters, wordPanel);
						container.add(world, BorderLayout.CENTER);
						container.add(wordPanel, BorderLayout.SOUTH);
						userInput.transferFocusBackward();

					}
				}

			});

			/*
			 * restart2 = new JButton("Restart"); restart2.addActionListener(new
			 * ActionListener() {
			 * 
			 * @Override public void actionPerformed(ActionEvent e) {
			 * userInput.setText("Must be a minimum of 4 letters");
			 * world.resetGame2(wordPanel);
			 * 
			 * }
			 * 
			 * })
			 */
			;
			userInput = new JTextField("Must be a minimum of 4 letters");
			north.add(userInput);
			north.add(enter);
			north.add(restart);
			userInput.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						String userWord = userInput.getText().toUpperCase();
						if (userWord.length() < 4) {
							userInput.setText("Word too short. Enter word minimum of 4 characters");

						} else {
							userInput.setText("");
							world = new HangmanWorld(userWord, letters, wordPanel);
							container.add(world, BorderLayout.CENTER);
							container.add(wordPanel, BorderLayout.SOUTH);
							userInput.transferFocusBackward();
						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
			container.add(north, BorderLayout.NORTH);
			container.add(letters, BorderLayout.WEST);

			break;
		}

	}

	ActionListener restartListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				gameOptionRestart();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			// world.resetGame(word);
			// container.transferFocusBackward();

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

	public void gameOptionRestart() throws FileNotFoundException {
		String[] restartOptions = { "Computer", "2 Players", "Exit" };
		int restartOption = JOptionPane.showOptionDialog(this, "Choose how you would like to play", "Restart",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, restartOptions, restartOptions[0]);
		switch (restartOption) {
		case 0:
			container.removeAll();
			world = new HangmanWorld(letters, wordPanel);
			world.resetGame(wordPanel);
			container.add(world, BorderLayout.CENTER);
			container.add(letters, BorderLayout.WEST);
			container.add(wordPanel, BorderLayout.SOUTH);
			container.add(restart, BorderLayout.NORTH);
			container.revalidate();
			container.transferFocusBackward();
			break;
		case 1:
			container.removeAll();
			world.resetGame2(wordPanel);

			north = new JPanel();
			north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
			userInput = new JTextField();
			userInput.setText("must be minimum of four letters");
			north.add(userInput);
			enter = new JButton("Enter");
			enter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String userWord = userInput.getText().toUpperCase();
					if (userWord.length() < 4) {
						userInput.setText("Word too short. Enter word minimum of 4 characters");

					} else {
						userInput.setText("");
						world = new HangmanWorld(userWord, letters, wordPanel);
						container.add(world, BorderLayout.CENTER);
						container.add(wordPanel, BorderLayout.SOUTH);
						userInput.transferFocusBackward();

					}
				}

			});
			north.add(enter);
			north.add(restart);

			userInput.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						String user = userInput.getText().toUpperCase();
						if (user.length() < 4) {
							userInput.setText("Word too short. Enter word minimum of 4 characters");

						} else {
							userInput.setText("");
							world = new HangmanWorld(user, letters, wordPanel);
							container.add(world, BorderLayout.CENTER);
							container.add(wordPanel, BorderLayout.SOUTH);
							userInput.transferFocusBackward();
						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
			container.add(north, BorderLayout.NORTH);
			container.add(letters, BorderLayout.WEST);

			container.revalidate();

			break;
		case 2:
			System.exit(0);
			break;
		}
	}
}
