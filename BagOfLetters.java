import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class BagOfLetters {
    private ArrayList<Tile> tiles;
    private ImageIcon tileIcon;

    public BagOfLetters() {
        this.tiles = new ArrayList<>();
        this.tileIcon = new ImageIcon(getClass().getResource("/Resources/tile.PNG"));

        for(int i = 0; i<9;i++)
            tiles.add(new Tile('A',tileIcon,1));

        for(int i = 0; i<13;i++)
            tiles.add(new Tile('E',tileIcon,1));

        for(int i = 0; i<7;i++)
            tiles.add(new Tile('T',tileIcon,1));

        for(int i = 0; i<6;i++)
            tiles.add(new Tile('R',tileIcon,1));

        for(int i = 0; i<3;i++)
            tiles.add(new Tile('G',tileIcon,3));
        
        for(int i = 0; i<8;i++){
            tiles.add(new Tile('O',tileIcon,1));
            tiles.add(new Tile('I',tileIcon,1));
        }

        for(int i = 0; i<4;i++){
            tiles.add(new Tile('H',tileIcon,3));
            tiles.add(new Tile('L',tileIcon,2));
            tiles.add(new Tile('U',tileIcon,2));
        }

        for(int i = 0; i<5;i++){
            tiles.add(new Tile('N',tileIcon,2));
            tiles.add(new Tile('D',tileIcon,2));
            tiles.add(new Tile('S',tileIcon,1));
        }

        for(int i = 0; i<2;i++){
            tiles.add(new Tile('B',tileIcon,4));
            tiles.add(new Tile('C',tileIcon,4));
            tiles.add(new Tile('M',tileIcon,4));
            tiles.add(new Tile('V',tileIcon,5));
            tiles.add(new Tile('W',tileIcon,4));
            tiles.add(new Tile('Y',tileIcon,3));
            tiles.add(new Tile('F',tileIcon,4));
            tiles.add(new Tile('P',tileIcon,4));
        }

        tiles.add(new Tile('Q',tileIcon,10));
        tiles.add(new Tile('X',tileIcon,8));
        tiles.add(new Tile('Z',tileIcon,10));
        tiles.add(new Tile('J',tileIcon,10));
        tiles.add(new Tile('K',tileIcon,5));

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