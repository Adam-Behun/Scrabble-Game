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
		
		// need to add the control panel
		checker.isValidBoard(board.getBoardBad());
		
		add(board.getBoard());

		//space holder for something bottom left
		JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE); 
        panel1.setPreferredSize(new Dimension(200, 200));
		add(panel1);
		
		//space holder for player's hand
		JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE); 
        panel2.setPreferredSize(new Dimension(200, 200));
		add(panel2);
	}
	
	private void updateTurn() {
		
	}
	
	public static void main(String[] args) {
		new Driver();
	}
}
