package hangman;

import java.io.FileNotFoundException;

import javax.swing.JLabel;

public class Word {

	//private int size;
	private JLabel[] line;
	//private Dictionary dict ;
	private String currWord;
	
	public String getCurrWord() {
		return currWord;
	}

	public Word() throws FileNotFoundException{
		Dictionary dict = new Dictionary();
		 currWord = dict.getWord();
	//	this.size = size;
		line = new JLabel[currWord.length()];
		for(int i =0;i< line.length;i++){
			line[i] = new JLabel();
			line[i].setText("_____");
		}
	}

	public JLabel[] getLines() {
		return line;
	}
	
}
