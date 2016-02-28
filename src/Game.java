import java.util.ArrayList;

class Game{
    public static void main(String[] args) {
        ArrayList<Coordinate> cords = new ArrayList<>();
        for (int i = 100; i <= 125; i+=5){
            Coordinate c = new Coordinate(100, i);
            cords.add(c);
        }
        Snake snake = new Snake(cords, cords.get(0));
        Board board = new Board(snake);
        board.repaint();
        board.addKeyListener(board);
    }
}