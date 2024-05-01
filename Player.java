/** 
 * Manages attributes and methods of a player in the game
 * Keeps track of score, and letters currently holding
*/ 

import java.util.ArrayList;

public class Player{
	private int score;
	private ArrayList<Character> letters;
	
	public Player() {
		this.score = 0;
		this.letters = new ArrayList<>();
	}
	
	public void addLetter(char letter) {
		letters.add(letter);
	}
	
	public void removeLetter(char letter) {
		letters.remove(Character.valueOf(letter));
	}
	
	public int getScore() {
		return score;
	}
	
	public void updateScore(int points) {
		score += points;
	}
}
