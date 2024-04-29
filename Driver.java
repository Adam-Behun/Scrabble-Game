/** 
 * Gui code using Java Swing
 * 
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame{
	private BagOfLetters bagOfLetters;
	private Board board;
	private Player player1;
	private Player player2;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	
	public Driver() {
		setTitle("Scrabble Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		bagOfLetters = new BagOfLetters();
		board = new Board();
		player1 = new Player();
		player2 = new Player();
		
		add(board, BorderLayout.CENTER);
		
		JPanel scorePanel = new JPanel(new GridLayout(1, 2));
		scoreLabel1 = new JLabel("Player 1 Score: ");
		scoreLabel2 = new JLabel("Player 2 Score: ");
		
		scorePanel.add(scoreLabel1);
		scorePanel.add(scoreLabel2);
		add(scorePanel, BorderLayout.NORTH);
		
		// need to add the control panel
		
	}
	
	private void updateTurn() {
		
	}
	
	private static void main(String[] args) {
		new Driver();
	}
}
