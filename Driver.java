import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Driver extends JFrame{
	private BagOfLetters bagOfLetters;
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer; 
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	private WordChecker checker;
	
	public Driver() {
		setTitle("Scrabble Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		
		bagOfLetters = new BagOfLetters();
		board = new Board();
		
		player1 = new Player(bagOfLetters);
		player2 = new Player(bagOfLetters);
		currentPlayer = player1;
		checker = new WordChecker();
		
		setupGUI();
		updatePlayerDisplay();
		setupGame();
		
		setVisible(true);
	}
	
	private void setupGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		player1Panel = new JPanel(new BorderLayout());
		player2Panel = new JPanel(new BorderLayout());
		player1Panel.setOpaque(true);
		player2Panel.setOpaque(true);
		
		setupPlayerPanel(player1Panel, "Player1's hand:", player1);
		setupPlayerPanel(player2Panel, "Player2's hand:", player2);
		
		mainPanel.add(board, BorderLayout.CENTER);
		mainPanel.add(player1Panel, BorderLayout.NORTH);
		mainPanel.add(player2Panel, BorderLayout.SOUTH);
		
		addControlPanel(mainPanel);
		add(mainPanel);		
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void setupPlayerPanel(JPanel panel, String label, Player player) {
		JLabel playerLabel = new JLabel(label);
		playerLabel.setForeground(Color.WHITE);
		playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		panel.add(playerLabel, BorderLayout.NORTH);
		panel.add(player, BorderLayout.CENTER);
		panel.setBackground(Color.BLACK);
	}
	
	private void addControlPanel(JPanel mainPanel) {
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
		
		JButton changeTurnButton = new JButton("Change turn");
		changeTurnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
						changeTurn();
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
		controlPanel.add(changeTurnButton);
		controlPanel.add(printButton);
		
		mainPanel.add(controlPanel, BorderLayout.EAST);
	}	
	
	public void setupGame() {
		Tile[][] tiles = board.getTiles();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				Tile tile = tiles[i][j];
				tile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Tile pressed");
						handleTilePlacement(tile);
					}
				});
			}
		}
	}
	
	private void handleTilePlacement(Tile tile) {
		if (tile.getChar() == ' ') {
			String input = JOptionPane.showInputDialog(this, "Please Enter Title From Hand");
			if (input != null && input.length() == 1) {
				 char tileChar = Character.toUpperCase(input.charAt(0));
				 System.out.println("Attempting to place: " + tileChar);
				 System.out.println("Checking if player has tile '" + tileChar + "' :" + currentPlayer.hasTile(tileChar));
				 
				 if (Character.isLetter(tileChar) && currentPlayer.hasTile(tileChar)) {
					 if (board.placeTile(tile.getRow(), tile.getCol(), tileChar)) {
						 currentPlayer.useTile(tileChar);
						 System.out.println("Tile placed success");
						 //togglePlayer();
						 //updatePlayerDisplay();
					 } else {
						 JOptionPane.showMessageDialog(this, "Invalid move");
						 System.out.println("Failed to place tile: Invalid position or word");
					 } 
				 } else {
					 JOptionPane.showMessageDialog(this, "Tile not in hand or invalid character");
					 System.out.println("Tile not in hand or not a valid letter");
				 }
		} else {
			JOptionPane.showMessageDialog(this, "Enter a single letter");
			System.out.println("No input or multiple characters");
		}
	} else {
		JOptionPane.showMessageDialog(this, "Tile position already occupied");
		System.out.println("Tile place already occupied");
		}
	}
	
	private void changeTurn() {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
		updatePlayerDisplay();
		System.out.println("Turn switched to: " + (currentPlayer == player1 ? "Player 1" : "Player 2"));
	}
		
/*	
	private void togglePlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		System.out.println("Current player switched to: " + (currentPlayer == player1 ? "Player 1" : "Player 2"));
		updatePlayerDisplay();
	}
	
*/
	
	private void updatePlayerDisplay() {
		SwingUtilities.invokeLater(() -> {
			System.out.println("Updating display for: " + (currentPlayer == player1 ? "Player 1" : "Player 2"));
			if (currentPlayer == player1) {
				player1Panel.setBackground(Color.GREEN);
				player2Panel.setBackground(Color.GRAY);
			} else {
				player2Panel.setBackground(Color.GREEN);
				player1Panel.setBackground(Color.GRAY);			
			}		
			player1Panel.revalidate();
			player1Panel.repaint();
			player2Panel.revalidate();
			player2Panel.repaint();
		});
		
	}
	
	
		
		public static void main(String[] args) {
			new Driver();
		}
}
