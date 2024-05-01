/** 
 * Validates the words formed against the dictionary
 * Ensures that only valid words are used in the game
*/ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordChecker{
	
	private List<String> validWords;
    private ArrayList<Character> alph;
    		
	public WordChecker() {
		this.validWords = new ArrayList<>();
			
		// few sample words for the alpha version
		validWords.add("world");
		validWords.add("hello");
		validWords.add("Game");
	    validWords.add("hope");
	    validWords.add("oven");
	    validWords.add("even");
	    validWords.add("lens");
	    validWords.add("pens");

         alph = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
         'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
         'w', 'x', 'y', 'z'));
	}
	
    //takes in a matrix to validate if all rows and columns contain valid words
	public boolean isValidBoard(char [][] board) {

        //checking rows
		System.out.println("Processing rows:");
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            System.out.print("Row " + i + ": ");
            isVaildWord(row);
            System.out.println();
        }

        //checking columns
		System.out.println("Processing columns:");
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

    //takes a line of the matrix to check if it is true
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
    public void printBoard(char [][] board) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    }
