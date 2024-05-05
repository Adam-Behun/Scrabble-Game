import java.util.ArrayList;
import java.util.Collections;

public class BagOfLetters {
    private ArrayList<Tile> tiles;

    public BagOfLetters() {
        this.tiles = new ArrayList<>();
        // initialize the bag of letters
        for (char c = 'A'; c <= 'Z'; c++) {
            tiles.add(new Tile(c));
            System.out.println(tiles.size());
        }
        // then shuffle
        Collections.shuffle(tiles);
    }

    public Tile pullLetter() {
        if (!tiles.isEmpty()) {
            return tiles.remove(0);
        } else {
            // Handle empty bag scenario
            return null; // or throw an exception
        }
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public Tile test() {
        return tiles.get(0);
    }
}