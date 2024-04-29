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
	
	public boolean isValidBoard(char [][] board) {
		
		System.out.println("Processing rows:");
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
		System.out.println("Processing columns:");
        for (int j = 0; j < board[0].length; j++) {
            System.out.print("Column " + j + ": ");
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
		return true;
    }
	}
