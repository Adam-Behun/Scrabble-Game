import javax.swing.JPanel;

public class Board extends JPanel{
    private char[][] matrix = {
        {'h', 'e', 'l', 'l','o'},
        {'o', 'v', 'e', 'n',' '},
        {'p', 'e', 'n', 's',' '},
        {'e', 'n', 's', 's',' '}
};
;

    public Board() {
    
    }
    public char[][] getBoard(){
        return matrix;
    }
}
