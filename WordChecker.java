import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class WordChecker{
	
	private HashSet<String> validWords;
	
	public WordChecker() {
		validWords = new HashSet<String> validWords;
		loadDictionary();
	}
				
	// find a way to change the validWords hashset for a .txt dictionary of english words
	private void loadDictionary() {
		try(BufferedReader read = new BufferedReader(new FileReader("Resources/ScrabbleWords.txt"))){
			String word;
			while((word = read.readLine())!= null){
				word =word.trim();
				validWords.add(word);
			}	
		}catch(IOException e){
			System.err.println("bad file");
		}
	}

	public boolean isValidWord(String word) {
		return validWords.contains(word.toLowerCase());
	}
	
	public boolean isValidBoard(char[][] board) {
		
		// check every row
		for (int i = 0; i < board.length; i++) {
			if (!checkValidWordsInLine(board[i])) {
				return false;
			}
		}
		
		// check every column
		for (int j = 0; j < board[0].length; j++) {
			char[] column = new char[board.length];
			for (int i = 0; i < board.length; i++) {
				column[i] = board[i][j];
			}
			if (!checkValidWordsInLine(column)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkValidWordsInLine(char[] line) {
		StringBuilder word = new StringBuilder(); 
		boolean isValid = true;
		
		for (char c : line) {
			if (Character.isLetter(c)) {
				word.append(c);
			} else {
				if (word.length() > 0) {
					if (!validWords.contains(word.toString().toLowerCase())) {
						System.out.println(word + " is not a valid word.");
						isValid = false;
					}
					word.setLength(0);
					}
				}
			}
		
		// check last word in the line if not checked
		if (word.length() > 0 && !validWords.contains(word.toString().toLowerCase())) {
			System.out.println(word + " is not a valid word.");
			isValid = false;
		}
		
		return isValid;
	}
}