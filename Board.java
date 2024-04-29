import javax.swing.JPanel;

public class Board extends JPanel{
    private char[][] matrix = {
        {'a', 'b', 'c', 'd'},
        {'e', 'f', 'g', 'h'},
        {'i', 'j', 'k', 'l'}
};
;

    public Board() {
        this.matrix = matrix;
    }
}
