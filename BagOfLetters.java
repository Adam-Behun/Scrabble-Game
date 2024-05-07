import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class BagOfLetters {
    private ArrayList<Tile> tiles;
    private ImageIcon tileIcon;

    public BagOfLetters() {
        this.tiles = new ArrayList<>();
        this.tileIcon = new ImageIcon(getClass().getResource("/Resources/tile.PNG"));
        
        for (char c = 'A'; c <= 'Z'; c++) {
            tiles.add(new Tile(c, tileIcon, -1, -1));
        }
        Collections.shuffle(tiles);
    }

    public Tile pullLetter() {
        if (!tiles.isEmpty()) {
            return tiles.remove(0);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public Tile test() {
        return tiles.get(0);
    }
}