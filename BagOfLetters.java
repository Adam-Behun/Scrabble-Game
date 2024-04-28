/** 
 * All available letters in the game
 * Checks if bag empty and allows to draw letters
*/ 

import java.util.ArrayList;
import java.util.Collections;

public class BagOfLetters{
	private ArrayList<Character> letters;
	
	public BagOfLetters() {
		this.letters = new ArrayList<>();
		
		// initialize the bag of letters
		for (char c = 'A'; c <= 'Z'; c++) {
			letters.add(c);
		}
		// then shuffle
		Collections.shuffle(letters);
	}
	
	public char pullLetter() {
		if (!letters.isEmpty()) {
			return letters.remove(0);
		}
		return '\0'; 
	}
	
	public boolean isEmpty() {
		return letters.isEmpty();
	}
}
