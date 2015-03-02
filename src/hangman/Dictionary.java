package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {

	private ArrayList<String> dictionary;
	
	public Dictionary() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("./OWL.txt"));
		dictionary = new ArrayList<String>();
		while(scanner.hasNext()){
			dictionary.add(scanner.next());
			scanner.nextLine();
		}
		
		
	}
	public String getWord(){
		Random random = new Random();
		int number = random.nextInt(dictionary.size()-1)+1072;
		return dictionary.get(number);
	}

	public ArrayList<String> getDictionary() {
		return dictionary;
	}
}
