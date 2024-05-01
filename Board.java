import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Board extends JPanel{
    private JPanel Board;
    private JTextField placedTile;
    private char[][] matrix = {
        {'h', 'e', 'l', 'l','o',' ', ' ', ' ', ' '},
        {'o', 'v', 'e', 'n',' ',' ', ' ', ' ', ' '},
        {'p', 'e', 'n', 's',' ',' ', ' ', ' ', ' '},
        {'e', 'n', 's', 's',' ',' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ',' ',' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ',' ',' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ',' ',' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ',' ',' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ',' ',' ', ' ', ' ', ' '}
        
};
;
   
    public Board() {
        Board = new JPanel(new GridLayout(10,9));
        String center = "Resources/center.PNG";
        String tile = "Resources/tile.PNG";
        String dl = "Resources/DL.PNG"; 
        String dw = "Resources/DW.PNG";
        String tl = "Resources/TL.PNG";
        String tw = "Resources/TW.PNG";

       /* Board.add(buttonCreation(dl));
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
        */

        for (int i = 0; i < 9; i++) {
            for(int j =0; j < 9; j++){
            if(i == 4 && j == 4){
                Board.add(buttonCreation(center , i, j));
            }
            else{
            Board.add(buttonCreation(tile , i, j));
            }
        }
        }
        JLabel label = new JLabel("letter:");
        Board.add(label);
        placedTile = new JTextField();
        Board.add(placedTile );
    }
    
    public JPanel getBoard(){
        return Board;
    }

    private JButton buttonCreation(String path, int row, int column){
        ImageIcon tempIcon = new ImageIcon(path);
        Image norm = tempIcon.getImage();
        Image resizedImage = norm.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JButton resizedButton = new JButton(new ImageIcon(resizedImage));
        resizedButton.setPreferredSize(new Dimension(100, 100));

        //Action Listener for button, this currently returns the postion of the button to be used in 
        resizedButton.addActionListener(new ButtonListener());
        String text = String.valueOf(row) + "." + String.valueOf(column);
        resizedButton.setText(text);
        return resizedButton;
        

    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            System.out.println( "You clicked: " + button.getText());
            String temp = button.getText();
            int a = Character.getNumericValue(temp.charAt(0));
            int b = Character.getNumericValue(temp.charAt(2));
            matrix[a][b] = placedTile.getText().charAt(0);
        }
    }


    public char[][] getMatrix(){
        return matrix;
    }
}
