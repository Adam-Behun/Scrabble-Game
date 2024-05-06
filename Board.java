import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;
import java.net.URL;
import java.awt.event.ActionListener;

public class Board extends JPanel{
    private Tile[][] tiles;
    private char[][] matrix;    
    private ImageIcon centerIcon, tileIcon, dlIcon, dwIcon, tlIcon, twIcon;
    private WordChecker wordChecker = new WordChecker();
       
    public Board() {
    	loadImages();
    	setLayout(new GridLayout(15,15));
    	initializeTiles();
    }
        
    private void loadImages() {
    	centerIcon = loadImage("Resources/center.PNG");
    	tileIcon = loadImage("Resources/tile.PNG");
    	dlIcon = loadImage("Resources/DL.PNG");
    	dwIcon = loadImage("Resources/DW.PNG");
    	tlIcon = loadImage("Resources/TL.PNG");
    	twIcon = loadImage("Resources/TW.PNG");    			
    }
    
    private ImageIcon loadImage(String path) {
    	URL url = getClass().getResource(path);
    	if (url == null) {
    		System.err.println("Failed to load" + path);
    		return new ImageIcon();
    	}
    	
    	try {
    		BufferedImage img = ImageIO.read(url);
    		return new ImageIcon(img);
    	} catch (IOException e) {
    		System.err.println("Error" + path);
    		e.printStackTrace();
    		
    	}
    	return new ImageIcon();
    }    
    
    private void initializeTiles() {
    	tiles = new Tile[15][15];
    	matrix = new char[15][15];
    	for (int i = 0; i < 15; i++) {
    		for (int j = 0; j < 15; j++) {
    			    			
    			ImageIcon icon = selectIcon(i, j);
    			tiles[i][j] = new Tile(' ', icon);    				
    			
    			// inner class requires local variables to be final
    			final int finalI = i;
    			final int finalJ = j;
    			
    			tiles[i][j].addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					placeTile(finalI, finalJ, ((Tile) e.getSource()).getChar());
    				}
    				});
    				add(tiles[i][j]);
           		}
    		}
    	}
    
    public void placeTile(int row, int col, char letter) {
    	matrix[row][col] = letter;
    	tiles[row][col].setText(String.valueOf(letter));
    	
    	// check for horizontal and vertical words
    	String horizontalWord = extractWord(matrix[row]);
    	String verticalWord = extractWord(getColumn(matrix, col));
    	
    	
    	// improve wordchecker
    	if (!horizontalWord.isEmpty() && wordChecker.isValidWord(horizontalWord)) {
    		System.out.println("Horizontal word: " + horizontalWord + " is valid.");
    	} 
    	if (!verticalWord.isEmpty() && wordChecker.isValidWord(verticalWord)){
    		System.out.println("Vertical word: " + verticalWord + " is valid.");	
    	}
    }
    
    // anytime a letter is entered, check row and column
    // method extracts the word
    private String extractWord(char[] line) {
    	StringBuilder word = new StringBuilder();
    	for (char c : line) {
    		if (Character.isLetter(c)) {
    			word.append(c);
    		} else if (word.length() > 1) {
    			break;
    		} else {
    			word.setLength(0);
    		}
    	}
    	return word.toString();
    }
    
    // extract characters from a specific column
    private char[] getColumn(char[][] matrix, int col) {
    	char[] column = new char[matrix.length];
    	for (int i = 0; i < matrix.length; i++) {
    		column[i] = matrix[i][col];
    	}
    	return column;
    }
    
    private ImageIcon selectIcon(int row, int col) {
    	// set special tiles based on rules
    	if (row == 7 && col == 7) {
    		return centerIcon;
    	} else if ((row % 4 == 0 && col % 4 == 0) || (row == col) || (row + col == 14)){
    		return dwIcon;    		
    	} else if ((row % 3 == 0 && col % 3 == 0)) {
    		return tlIcon;
    	} else {
    		return tileIcon;    		
    	}
    }
    
	public char[][] getMatrix(){
		return matrix;
	}


    public void printBoard() {
    	System.out.println("Current Board:");
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			
    			// check for null character
    			if (matrix[i][j] == '\u0000') {
    				System.out.print('-');
    			} else {
    				System.out.print(matrix[i][j]);
    			}
    			System.out.println();
    		}
    	}
    }
}
