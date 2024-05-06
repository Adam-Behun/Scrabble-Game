public class PointCalculator{
	
	// how to do multipliers?
	public int calculatePoints(String word, int[] multipliers) {
		int score = 0;
		for (int i = 0; i < word.length(); i++) {
			score += getLetterValue(word.charAt(i)) * multipliers[i];
		}
		return score;
	}
	
	private int getLetterValue(char letter) {
		// preliminary
		return 1;
	}
}