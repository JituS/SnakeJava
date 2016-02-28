import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class Board extends JFrame implements KeyListener{
    private Snake snake;
    private boolean isGameOver = false;
    private TimerTask task;
    private Coordinate food;
    private int score;

    public Board(Snake snake) {
        this.snake = snake;
        this.food = new Coordinate((int)Math.round(Math.random()*40)*10,(int)Math.round((Math.random()*40))*10);
        setSize(500, 500);
        setResizable(false);
        Color color = new Color(193,193,193);
        setBackground(color);
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

    public void restart(Graphics g){
        score = 0;
        for (Coordinate coordinate : this.snake.getBody()) {
            g.clearRect(0,0, getWidth(),getHeight());
            ArrayList<Coordinate> cords = new ArrayList<>();
            for (int i = 100; i <= 140; i += 10) {
                Coordinate c = new Coordinate(100, i);
                cords.add(c);
            }
            snake = new Snake(cords, cords.get(0));
            isGameOver = false;
            repaint();
        }
    }
    @Override
    public void paint(Graphics g) {
        if(isGameOver) {
            restart(g);
        }
        if (snake.prev != null) {
            g.clearRect(0,0, getWidth(),getHeight());
        }
        for (Coordinate coordinate : snake.getBody()) {
            g.setColor(new Color(2, 3, 2));
            g.fillRect(coordinate.getX(), coordinate.getY(), 10, 10);
            g.fillRect(food.getX(), food.getY(), 10, 10);
        }
        g.setFont(new Font("Times new Roman", 25, 25));
        g.drawString("Score:" + score , 400, 40);
    }

    public void moveSnake(String direction){
        if(task != null)  task.cancel();
        task = new TimerTask() {
            @Override
            public void run() {
                if(snake.eat(food)){
                    score++;
                    placeFood();
                };
                if(snake.isDead(direction)){
                    isGameOver = true;
                    cancel();
                }else{
                   boolean moved =  snake.move(direction);
                    if(!moved){
                        moveSnake(snake.direction1);
                    }
                }
                repaint();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task,new Date(), 70);
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

    private void placeFood() {
        this.food = new Coordinate((int)Math.round(Math.random()*40)*10,(int)Math.round((Math.random()*40))*10);
    }
}