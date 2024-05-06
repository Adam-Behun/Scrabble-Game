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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Driver extends JFrame{
	private BagOfLetters bagOfLetters;
	private Board board;
	private Player player1;
	private Player player2;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	private WordChecker checker;
	
	public Driver() {
		setTitle("Scrabble Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		// top L is score, bL is something else, TL is board, bottom left is player's hand
		
		bagOfLetters = new BagOfLetters();
		board = new Board();
		
		player1 = new Player(bagOfLetters);
		player2 = new Player(bagOfLetters);
		checker = new WordChecker();
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		player1Panel = new JPanel(new BorderLayout());
		player2Panel = new JPanel(new BorderLayout());
		
		// Display player1's hand
		player1Panel.add(new JLabel("Player1's hand:"), BorderLayout.NORTH);
		player1Panel.add(player1, BorderLayout.CENTER);
		player1Panel.setBackground(Color.BLUE);
		
		// Display player2's hand
		player2Panel.add(new JLabel("Player2's hand:"), BorderLayout.NORTH);
		player2Panel.add(player2, BorderLayout.CENTER);
		player2Panel.setBackground(Color.BLUE);
		
		// Layout config
		mainPanel.add(board, BorderLayout.CENTER);
		mainPanel.add(player1Panel, BorderLayout.NORTH);
		mainPanel.add(player2Panel, BorderLayout.SOUTH);
		
		add(mainPanel);
		
		JButton checkButton = new JButton("Check the board");
		checkButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if (checker.isValidBoard(board.getMatrix())) {
					JOptionPane.showMessageDialog(null, "All words are valid");
				} else {
					JOptionPane.showMessageDialog(null, "Some words are not valid");
				}
			}
		});
		
		
		JButton printButton = new JButton("Print matrix");
		printButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
						board.printBoard();
					}
				});
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(checkButton);
		controlPanel.add(printButton);
		
		mainPanel.add(controlPanel, BorderLayout.EAST);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
		
		public static void main(String[] args) {
			new Driver();
		}
}

/*		
		
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(150, 1000));
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(Color.BLUE);
		
		
		// Top right (850x850)
		JPanel topRightPanel = new JPanel();
		topRightPanel.setPreferredSize(new Dimension(850, 850));
		topRightPanel.setLayout(new FlowLayout());
		topRightPanel.setBackground(Color.RED);
		
		// Bottom (850x150)
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(850, 150));
		// Add components to bottomPanel using suitable layout manager
		bottomPanel.setBackground(Color.black);
		
		add(leftPanel, BorderLayout.WEST);
		topRightPanel.add(board);
		add(topRightPanel, BorderLayout.CENTER);						
		
		JPanel topPlayerTitle = new JPanel();
		topPlayerTitle.setPreferredSize(new Dimension(850, 50));
		//add a title here and what the player is

		JLabel playerTilesGUI = new JLabel();
		playerTilesGUI.setLayout(new GridLayout(1, 7));

		for (int i = 0; i < 7; i++) {
			player1.addLetter();
			playerTilesGUI.add(player1.getTile(i));
		}
				
		JPanel bottomPlayerHand = new JPanel();
		bottomPlayerHand.setPreferredSize(new Dimension(850, 100));
		bottomPlayerHand.add(playerTilesGUI);
		bottomPanel.add(topPlayerTitle);
		bottomPanel.add(bottomPlayerHand);
		add(bottomPanel, BorderLayout.SOUTH);	

		JButton checkButton = new JButton("Check the board");
		checkButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if (checker.isValidBoard(board.getMatrix())) {
					JOptionPane.showMessageDialog(null, "All words are valid");
				} else {
					JOptionPane.showMessageDialog(null, "Some words are not valid");
				}
			}
		});
		
		JButton printButton = new JButton("Print matrix");
		printButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
						board.printBoard();
					}
				});
		
		topRightPanel.add(checkButton);
		topRightPanel.add(printButton);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Driver();
	}
}
*/