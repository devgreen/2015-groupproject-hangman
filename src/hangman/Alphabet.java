package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Alphabet {

	JButton[] letters;

	public Alphabet() {
		letters = new JButton[26];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new JButton();
		}
		int j = 0;
		for (char i = 'A'; i <= 'Z'; i++) {
			letters[j].setText(String.valueOf(i));
		//	letters[j].addActionListener(checkLetter);
			j++;
		}
	}

	public JButton[] getLetters() {
		return letters;
	}

}
