/** 
 * Manages attributes and methods of a player in the game
 * Keeps track of score, and letters currently holding
*/ 

import java.util.ArrayList;
import javax.swing.JPanel;

public class Player extends JPanel{
	private int score;
	final private ArrayList<Tile> tilesInHand;
	final private BagOfLetters BagOfLetters;
	
	public Player(BagOfLetters letterBag) {
		this.score = 0;
		this.tilesInHand = new ArrayList<Tile>();
		this.BagOfLetters = letterBag;
	}
	//update letter bag

	public void addLetter() {
			this.tilesInHand.add(this.BagOfLetters.pullLetter()); // when is this. needed?
	}
	
	public Tile getTile(int index){
		return this.tilesInHand.get(index);
	}
	
	//display hand
	public void removeLetter(char letter) {
		//this.tilesInHand.remove(); FIX THIS
	}
	
	public int getScore() {
		return score;
	}
	
	public void updateScore(int points) {
		score += points;
	}

	
}
