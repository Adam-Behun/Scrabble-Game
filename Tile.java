import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {
    private char charVal;
    private ImageIcon bgImage;
    private static final Font font = new Font("Arial", Font.BOLD, 33);
 
    public Tile(char charVal, ImageIcon bgImage){
    	super();
    	this.bgImage = bgImage;
    	setIcon(bgImage);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(55, 55));
        setFont(font);
        setText(Character.toString(charVal));
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        addActionListener(e -> updateTile());
    }
    
    public void updateTile() {
    	String input = JOptionPane.showInputDialog(this, "Enter a letter:");
    	if (input != null && input.length() == 1 && Character.isLetter(input.charAt(0))) {
    		charVal = Character.toUpperCase(input.charAt(0)); // update the char value
    		setText(String.valueOf(charVal)); // update the displayed letter
    	} else {
    		setText("");
    		charVal = '\u0000';
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
