/** 
 * Validates the words formed against the dictionary
 * Ensures that only valid words are used in the game
*/ 

import java.util.ArrayList;
import java.util.List;

public class WordChecker{
	private List<String> validWords;
	
	public WordChecker() {
		this.validWords = new ArrayList<>();
		
		// few sample words if we need them for testing
		// in the future should be using a dictiornary
		validWords.add("example");
		validWords.add("board--12");
		validWords.add("Game");
	}
	
	public boolean isValidWord(String word) {
		return validWords.contains(word.toLowerCase());
	}
}
