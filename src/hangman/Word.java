package hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Word {

	//private int size;
	private ArrayList<JLabel> line;
	//private Dictionary dict ;
	private String currWord;
	
	public String getCurrWord() {
		return currWord;
	}

	public Word() throws FileNotFoundException{
		Dictionary dict = new Dictionary();
		 currWord = dict.getWord();
	//	this.size = size;
		line = new ArrayList<JLabel>();
		for(int i =0;i< currWord.length();i++){
			line.add(new JLabel());
			line.get(i).setText("_____");
		}
	}

	public ArrayList<JLabel> getLines() {
		return line;
	}
	
}
