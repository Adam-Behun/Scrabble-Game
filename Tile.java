import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {
    private char charVal;
    private ImageIcon bgImage;
    private int row;
    private int col;
	private int point;
    private static final Font font = new Font("Arial", Font.BOLD, 33);
 
    public Tile(char charVal, ImageIcon bgImage,int point, int row, int col){
    	super();
    	this.bgImage = bgImage;
    	this.charVal = charVal;
    	this.row = row;
    	this.col = col;
		this.point = point;
    	setIcon(bgImage);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(55, 55));
        setFont(font);
        setText(Character.toString(charVal));
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        addActionListener(e -> updateTile());
    }

	public Tile(char charVal, ImageIcon bgImage,int point){
    	super();
    	this.bgImage = bgImage;
    	this.charVal = charVal;
    	this.row = 0;
    	this.col = 0;
		this.point = point;
    	setIcon(bgImage);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(55, 55));
        setFont(font);
        setText(Character.toString(charVal));
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        addActionListener(e -> updateTile());
    }
    
    public int getRow() {
    	return row;
    }
    
    public int getCol() {
    	return col;
    }


    public void updateTile() {
    	String input = JOptionPane.showInputDialog(this, "Please Confirm Letter:");
    	if (input != null && input.length() == 1 && Character.isLetter(input.charAt(0))) {
    		this.charVal = Character.toUpperCase(input.charAt(0)); // update the char value
    		setText(String.valueOf(this.charVal)); // update the displayed letter
    	} else {
    		setText("");
    		this.charVal = '\u0000';
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if (bgImage != null) {
    		g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    		g.setColor(Color.BLACK);
    		g.setFont(font);
    		
    		// draws text over the icon at its center
    		FontMetrics fm = g.getFontMetrics();
    		int x = (getWidth() - fm.stringWidth(getText())) /2;
    		int y = (getHeight() + fm.getHeight()) / 2 - fm.getDescent();
    		g.drawString(getText(), x, y);
    	}
    }
    
    public char getChar() {
    	return charVal;
    }

}
