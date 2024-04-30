import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    private JPanel Board;
    private char[][] matrix = {
        {'h', 'e', 'l', 'l','o'},
        {'o', 'v', 'e', 'n',' '},
        {'p', 'e', 'n', 's',' '},
        {'e', 'n', 's', 's',' '}
};
;
   
    public Board() {
        Board = new JPanel(new GridLayout(15,15));
        String center = "Resources/center.PNG";
        String tile = "Resources/tile.PNG";
        String dl = "Resources/DL.PNG"; 
        String dw = "Resources/DW.PNG";
        String tl = "Resources/TL.PNG";
        String tw = "Resources/TW.PNG";

        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(center));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));    
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));     
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));
        Board.add(buttonCreation(dl));
        Board.add(buttonCreation(dw));
        Board.add(buttonCreation(tile));
        Board.add(buttonCreation(tl));
        Board.add(buttonCreation(tw));
    }
    
    public JPanel getBoard(){
        return Board;
    }

    private JButton buttonCreation(String path){
        ImageIcon tempIcon = new ImageIcon(path);
        Image norm = tempIcon.getImage();
        Image resizedImage = norm.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JButton resizedButton = new JButton(new ImageIcon(resizedImage));
        resizedButton.setPreferredSize(new Dimension(100, 100));
        return resizedButton;
        //add button listener

    }

    public char[][] getMatrix(){
        return matrix;
    }
}
