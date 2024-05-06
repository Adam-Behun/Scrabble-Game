// Handles the config off individual tiles
// as well as user interactions

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {
    private char charVal;
    private ImageIcon bgImage;
    private static final Font font = new Font("Arial", Font.BOLD, 33);
    // private JLabel stringVal;  
    // private int scoreVal; // later on 

    public Tile(char charVal, ImageIcon bgImage){
    	super();
    	if (bgImage == null) {
    		System.out.println("Bg img is null");
    		bgImage = new ImageIcon();
    	}
    	this.bgImage = bgImage;
    	setIcon(bgImage);
    	
        this.charVal=charVal;
        this.bgImage = bgImage;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(55, 55));
        setText(Character.toString(charVal));
        setFont(font);
        setIcon(bgImage);
        addActionListener(e -> updateTile());
    }
    
    public void updateTile() {
    	String input = JOptionPane.showInputDialog(this, "Enter a letter:");
    	if (input != null && input.length() == 1 && Character.isLetter(input.charAt(0))) {
    		charVal = Character.toUpperCase(input.charAt(0)); // update the char value
    		setText(String.valueOf(charVal)); // update the displayed letter
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if (bgImage != null) {
    		g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    	}
    }
}


/*        
        stringVal = new JLabel();
        stringVal.setText(Character.toString(charVal));
        stringVal.setHorizontalAlignment(JTextField.CENTER);
        stringVal.setOpaque(false);
        stringVal.setFont(font);

        setPreferredSize(new Dimension(100, 100));
        add(stringVal, BorderLayout.CENTER);
    }

*/

/*
    public ImageIcon resize(){
        ImageIcon tempIcon = new ImageIcon("Resources/tile.PNG");
        Image norm = tempIcon.getImage();
        Image resizedImage = norm.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void setBackgroundImage(ImageIcon backgroundImage) {
        this.bgImage = backgroundImage;
        repaint();
    }
}

*/