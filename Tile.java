import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {
    private int scoreVal; // later on 
    private char charVal;
    private Font font = new Font("Arial", Font.BOLD, 24);
    private JLabel stringVal; 
    private ImageIcon bgImage; 

    public Tile(char charVal){
        this.charVal=charVal;
        this.bgImage = resize();
        setLayout(new BorderLayout());
        
        stringVal = new JLabel();
        stringVal.setText(Character.toString(charVal));
        stringVal.setHorizontalAlignment(JTextField.CENTER);
        stringVal.setOpaque(false);
        stringVal.setFont(font);

        setPreferredSize(new Dimension(100, 100));
        add(stringVal, BorderLayout.CENTER);
    }

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

