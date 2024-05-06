/** 
 * Working in Beta: small set of testing words
 * Next step: add a dictionary file .txt in loadDictionary method
*/ 

import java.util.HashSet;
import java.util.Set;

public class WordChecker{
	
	private Set<String> validWords;
	
	public WordChecker() {
		this.validWords = new HashSet<>();
		loadDictionary();

		
		/*
         alph = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
         'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
         'w', 'x', 'y', 'z'));
        */
		
	
	}

	
	private void loadDictionary() {
		
		// set of words serving as an example
		// will be loading dictionary later
		validWords.add("world");
		validWords.add("hello");
		validWords.add("Game");
    	validWords.add("hope");
    	validWords.add("oven");
    	validWords.add("even");
    	validWords.add("lens");
    	validWords.add("pens");
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
		String word = "";	// use StringBuilder if issues here 
		boolean isValid = true;
		
		for (char c : line) {
			if (Character.isLetter(c)) {
				word += c;
			} else {
				if (word.length() > 0) {
					if (!validWords.contains(word.toLowerCase())) {
						System.out.println(word + " is not a valid word.");
						isValid = false;
					}
					word = "";
					}
				}
			}
		
		// check last word in the line if not checked
		if (word.length() > 0 && !validWords.contains(word.toLowerCase())) {
			System.out.println(word + " is not a valid word.");
			isValid = false;
		}
		
		return isValid;
	}
}

	
	
		
	
	
	
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