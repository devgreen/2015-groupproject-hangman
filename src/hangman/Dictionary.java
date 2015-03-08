package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<Integer, String> dictionary;

	public Dictionary() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("./OWL.txt"));
		Integer i = 0;
		dictionary = new HashMap<Integer, String>();
		while (scanner.hasNext()) {
			dictionary.put(i++, scanner.next());
			scanner.nextLine();
		}
		scanner.close();

	}

	public int getSize() {
		return dictionary.size();
	}

	public Map<Integer, String> getDictionary() {
		return dictionary;
	}
}
