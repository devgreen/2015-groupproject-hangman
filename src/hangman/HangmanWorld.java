package hangman;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangmanWorld extends JComponent {

	private Hangman hangmanComp;
	private Alphabet alphabet;
	private Word word;

	public HangmanWorld(JPanel alph, JPanel wordLines)
			throws FileNotFoundException {
		hangmanComp = new Hangman(800, 600);
		alphabet = new Alphabet(alph);
		alphabet.addActionListener(checkLetter);
		word = new Word(wordLines);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		hangmanComp.draw(g);

	}

	ActionListener checkLetter = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			check(button);
		}

	};

	public void check(JButton button) {
		Person person = hangmanComp.getPerson();
		button.setEnabled(false);
		ArrayList<Integer> there = word.contains(button.getText());
		if (!there.isEmpty()) {
			for (int i = 0; i < there.size(); i++) {
				word.getLines().get(there.get(i)).setText(button.getText());
			}

		} else {
			if (person.getNumOuts() < 5) {
				person.setNumOuts();
			} else {
				person.setNumOuts();
				gameOver();
			}

		}

	}

	public void resetGame(JPanel wordLines) {
		JButton[] alph = alphabet.getLetters();
		for (int i = 0; i < alph.length; i++) {
			alph[i].setEnabled(true);
		}

		word.getLines().clear();
		wordLines.removeAll();
		word.setLines(wordLines);
		wordLines.revalidate();
		hangmanComp.getPerson().resetOuts();
	}

	private void gameOver() {
		String getWord = word.getCurrWord();
		ArrayList<JLabel> line = word.getLines();
		for (int i = 0; i < line.size(); i++) {
			line.get(i).setText(String.valueOf(getWord.charAt(i)));

		}
		alphabet.disableButtons();
	}

	public void keyBoardInput(int keypressed) {
		JButton[] letter = alphabet.getLetters();
		switch (keypressed) {
		case KeyEvent.VK_A:
			check(letter[0]);
			break;
		case KeyEvent.VK_B:
			check(letter[1]);
			break;
		case KeyEvent.VK_C:
			check(letter[2]);
			break;
		case KeyEvent.VK_D:
			check(letter[3]);
			break;
		case KeyEvent.VK_E:
			check(letter[4]);
			break;
		case KeyEvent.VK_F:
			check(letter[5]);
			break;
		case KeyEvent.VK_G:
			check(letter[6]);
			break;
		case KeyEvent.VK_H:
			check(letter[7]);
			break;
		case KeyEvent.VK_I:
			check(letter[8]);
			break;
		case KeyEvent.VK_J:
			check(letter[9]);
			break;
		case KeyEvent.VK_K:
			check(letter[10]);
			break;
		case KeyEvent.VK_L:
			check(letter[11]);
			break;
		case KeyEvent.VK_M:
			check(letter[12]);
			break;
		case KeyEvent.VK_N:
			check(letter[13]);
			break;
		case KeyEvent.VK_O:
			check(letter[14]);
			break;
		case KeyEvent.VK_P:
			check(letter[15]);
			break;
		case KeyEvent.VK_Q:
			check(letter[16]);
			break;
		case KeyEvent.VK_R:
			check(letter[17]);
			break;
		case KeyEvent.VK_S:
			check(letter[18]);
			break;
		case KeyEvent.VK_T:
			check(letter[19]);
			break;
		case KeyEvent.VK_U:
			check(letter[20]);
			break;
		case KeyEvent.VK_V:
			check(letter[21]);
			break;
		case KeyEvent.VK_W:
			check(letter[22]);
			break;
		case KeyEvent.VK_X:
			check(letter[23]);
			break;
		case KeyEvent.VK_Y:
			check(letter[24]);
			break;
		case KeyEvent.VK_Z:
			check(letter[25]);
			break;
		}
	}

	public void resetButtons() {
		JButton[] alph = alphabet.getLetters();
		for (int i = 0; i < alph.length; i++) {
			alph[i].setEnabled(true);
		}
	}

	public void setLines(JPanel lines) {
		ArrayList<JLabel> line = word.getLines();
		for (int j = 0; j < line.size(); j++) {
			lines.add(line.get(j));
		}

	}

}
