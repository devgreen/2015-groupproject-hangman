package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Alphabet {

	private JButton[] letters;

	public Alphabet(JPanel alph) {
		letters = new JButton[26];

		for (int i = 0; i < letters.length; i++) {
			letters[i] = new JButton();
		}
		int j = 0;
		for (char i = 'A'; i <= 'Z'; i++) {
			letters[j].setText(String.valueOf(i));
			alph.add(letters[j]);
			j++;
		}
	}

	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < letters.length; i++) {
			letters[i].addActionListener(listener);
		}
	}

	public JButton[] getLetters() {
		return letters;
	}

	public void disableButtons() {
		for (int i = 0; i < letters.length; i++) {
			letters[i].setEnabled(false);
		}
	}

}
