import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordChecker{
	
	private Set<String> validWords;
	
	public WordChecker() {
		loadDictionary();
	}
				
	// find a way to change the validWords hashset for a .txt dictionary of english words
	private void loadDictionary() {
		validWords = new HashSet<>(Arrays.asList("hello", "world", "java", "game", "something", "verylongword"));
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

/*
	alph = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
	'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
	'w', 'x', 'y', 'z'));

*/

	
/*    
    public Boolean isVaildWord(char[] words){
        String result = "";
        boolean valid = true;

        for (int i = 0; i < words.length; i++)
		{
			//checks if char is a letter	    	
			if (alph.contains(words[i])) {      
				result = result + words[i];
			}
            //when it finds a blank, it will conclude the word
            else{
                //if the result being tracked is only blank or a single letter it is ignored
                if(result.length() > 1){
                    if(validWords.contains(result)){
                        System.out.println(result + " is valid");

                    }
                    else{
                        System.out.println(result + " is invalid");
                        valid = false;
                        }
                }

                result = "";
            }
        }
            //final check for words at the edges of the matrix
            if(result.length() > 1){
                if(validWords.contains(result)){
                    System.out.println(result + " is valid");

                }
                else{
                    System.out.println(result + " is invalid");
                    valid = false;
                }
            }

        return valid;
    }

*/
	
/*	
	
	public boolean isValidBoard(char [][] board) {

        //checking rows
		System.out.println("Checking rows:");
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            System.out.print("Row " + i + ": ");
            isVaildWord(row);
            System.out.println();
        }

        //checking columns
		System.out.println("Checking columns:");
        for (int j = 0; j < board[0].length; j++) {
            char[] column = new char[board.length];
            System.out.print("Column " + j + ": ");
            for (int i = 0; i < board.length; i++) {
                column[i] = board[i][j];
            }
            isVaildWord(column);
            System.out.println();
        }
		return true;
    }

*/

/*
    public void printBoard(char [][] board) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    }

*/