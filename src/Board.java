import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class Board extends JFrame implements KeyListener{
    private Snake snake;
    private TimerTask task;
    private Coordinate food;
    public Board(Snake snake) {
        this.snake = snake;
        this.food = new Coordinate((int)Math.round(Math.random()*100)*5,(int)Math.round((Math.random()*100))*5);
        setSize(500, 500);
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void paint(Graphics g) {
        if (snake.prev != null) {
            g.clearRect(this.snake.prev.getX(), this.snake.prev.getY(), 5, 5);
        }
        for (Coordinate coordinate : snake.getBody()) {
            g.setColor(new Color(2, 3, 2));
            g.fillRect(coordinate.getX(), coordinate.getY(), 5, 5);
        }
        g.fillRect(food.getX(), food.getY(), 5, 5);
    }

    public void moveSnake(String direction){
        if(task != null)  task.cancel();
        task = new TimerTask() {
            @Override
            public void run() {
                if(snake.eat(food)){
                    placeFood();
                }
                snake.move(direction);
                repaint();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task,new Date(), 50);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveSnake("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveSnake("down");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveSnake("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveSnake("left");
        }
    }

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

    private void placeFood() {
        this.food = new Coordinate((int)Math.round(Math.random()*100)*5,(int)Math.round((Math.random()*100))*5);
    }
}