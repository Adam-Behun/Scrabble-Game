import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Player extends JPanel{
	private int score;
	final private ArrayList<Tile> tilesInHand;
	final private BagOfLetters bagOfLetters;
	
	public Player(BagOfLetters bagOfLetters) {
		this.bagOfLetters = bagOfLetters;
		this.score = 0;
		this.tilesInHand = new ArrayList<>();
		drawInitialTiles();
		updateHandDisplay();
	}
	
	// each player starts with 7 tiles
	private void drawInitialTiles() {
		for (int i = 0; i < 7; i++) {
			addLetter();
		}
	}
	
	public boolean hasTile(char charVal) {
		for (Tile tile : tilesInHand) {
			if (tile.getChar() == charVal) {
				return true;
			}
		}
		return false;
	}
	
	public void useTile(char charVal) {
		Tile toRemove = null;
		for (Tile tile : tilesInHand) {
			if (tile.getChar() == charVal) {
				toRemove = tile;
				break;
			}
		}
		
		if (toRemove != null) {
			tilesInHand.remove(toRemove);
			updateHandDisplay();
		}
	}
	
	public void addLetter() {
		Tile tile = bagOfLetters.pullLetter();
		if (tile != null) {
			tilesInHand.add(tile);
		}
	}
	
	private void updateHandDisplay() {
		this.removeAll();
		this.setLayout(new FlowLayout());
		for (Tile tile : tilesInHand) {
			this.add(tile);
		}
		this.revalidate();
		this.repaint();
	}
	
	public Tile getTile(int index){
		return this.tilesInHand.get(index);
	}
	
	public void removeLetter(Tile tile) {
		tilesInHand.remove(tile);
		updateHandDisplay();
	}
	
	public int getScore() {
		return score;
	}
	
	public void updateScore(int points) {
		score += points;
	}

	public ArrayList<Tile> getTilesInHand(){
		return tilesInHand;
	}
}
