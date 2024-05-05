import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Board extends JPanel{
    private JPanel Board;
    private JTextField placedTile;
    
    //this the matrix that will hold the letters on the game board
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
        // these are images that we plan on using for our gameboard
        String center = "Resources/center.PNG";
        String tile = "Resources/tile.PNG";
        String dl = "Resources/DL.PNG"; 
        String dw = "Resources/DW.PNG";
        String tl = "Resources/TL.PNG";
        String tw = "Resources/TW.PNG";


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
        //sets the size and icon for the buttons
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
    //we decided for the sake of readble code to have a implemention of action listener 
    //this prints out the point pressed on the board, and updates the matrix with the given
    //character.
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