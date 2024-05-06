import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Driver extends JFrame{
	private BagOfLetters bagOfLetters;
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer; // Not sure if this is the right design
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
		
		setupGUI();
	}
	
	private void setupGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		player1Panel = new JPanel(new BorderLayout());
		player2Panel = new JPanel(new BorderLayout());
		
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
	}	
		
	
	private void togglePlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		updatePlayerDisplay();
	}
	
	private void updatePlayerDisplay() {
		if (currentPlayer == player1) {
			player1Panel.setBackground(Color.GREEN);
			player2Panel.setBackground(Color.GRAY);
		} else {
			player2Panel.setBackground(Color.GREEN);
			player1Pane1.setBackground(Color.GRAY);			
		}
	}
	
	
		
		public static void main(String[] args) {
			new Driver();
		}
}
