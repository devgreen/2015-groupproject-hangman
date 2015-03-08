package hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Word {

	public final static Random random = new Random();
	private ArrayList<JLabel> line;
	private Dictionary dict;
	private String currWord;

	public Word(JPanel wordLines) throws FileNotFoundException {
		dict = new Dictionary();
		line = new ArrayList<JLabel>();
		setLines(wordLines);
	}

	public Word(JPanel wordLines, String word) {
		currWord = word;
		line = new ArrayList<JLabel>();
		setLinesUser(wordLines);
	}

	public String getCurrWord() {
		return currWord;
	}

	public void setLines(JPanel wordLines) {
		currWord = getWord();
		for (int i = 0; i < currWord.length(); i++) {
			line.add(new JLabel("_____"));
			wordLines.add(line.get(i));
		}

	}

	public void setLinesUser(JPanel wordLines) {
		line.clear();
		// wordLines.removeAll();
		for (int j = 0; j < currWord.length(); j++) {
			line.add(new JLabel("_____"));
			wordLines.add(line.get(j));
		}
		// wordLines.revalidate();

	}

	public void setCurrWord(String userWord) {
		currWord = userWord;
	}

	public ArrayList<Integer> contains(String letter) {
		ArrayList<Integer> places = new ArrayList<Integer>();

		for (int i = 0; i < currWord.length(); i++) {
			if (letter.equals(String.valueOf(currWord.charAt(i)))) {
				places.add(i);
			}

		}
		return places;
	}

	public String getWord() {
		int number = random.nextInt(dict.getSize() - 1) + 1072;
		return dict.getDictionary().get(number);
	}

	public ArrayList<JLabel> getLines() {
		return line;
	}

}
