/** 
 * Gui code using Java Swing
 * Note for USe. the Alpah version of the Scrabble game is limited, each of the buttons operated by readign the 
 * first char from the text field, pressing the button will replace the char their with the one in the test field
 * the alpha version of our game has the interactive board as explained above, and the functions for printing out the 
 * letter on the game board and checking the board for legal and ilegal moves. these changes will be printed into your
 * terminal for the time being, this should be changed in the future.
 * 
 * we have work done for our other classes but they are not fully functional in the aplha version 
 * 
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Driver extends JFrame{
	private BagOfLetters bagOfLetters;
	private Board board;
	private Player player1;
	private Player player2;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	private WordChecker checker;
	
	public Driver() {
		setTitle("Scrabble Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		setSize(2000,2000);
		// top L is score, bL is something else, TL is board, bottom left is player's hand
		
		bagOfLetters = new BagOfLetters();
		board = new Board();

		player1 = new Player();
		player2 = new Player();
		checker = new WordChecker();
		
		JPanel leftPanel = new JPanel(new GridLayout(4, 1));
		
		//will be used to display scores
		scoreLabel1 = new JLabel("Player 1 Score: ");
		scoreLabel1.setPreferredSize(new Dimension(180, 180));
		scoreLabel2 = new JLabel("Player 2 Score: ");
		scoreLabel2.setPreferredSize(new Dimension(180, 180));

		leftPanel.add(scoreLabel1);
		leftPanel.add(scoreLabel2);

		add(leftPanel);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
		add(board.getBoard());
		checker.printBoard(board.getMatrix());

		//space holder for something bottom left
		JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE); 
        panel1.setPreferredSize(new Dimension(200, 200));
		add(panel1);
		
		//Hold buttons for adding letters and printing the buttons
		JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE); 
        panel2.setPreferredSize(new Dimension(200, 200));
		JButton checkButton = new JButton("check the board");

		checkButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{	
						checker.isValidBoard(board.getMatrix());
					}
				});
				
		panel2.add(checkButton);
		JButton printButton = new JButton("print matrix");

		printButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{	
						checker.printBoard(board.getMatrix());
					}
				});
				
		panel2.add(printButton);
		add(panel2);
	}

	
	
	private void updateTurn() {
		
	}
	
	public static void main(String[] args) {
		new Driver();
	}
}
