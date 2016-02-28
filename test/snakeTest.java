//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by vathsala on 27/02/16.
// */
//public class snakeTest {
//    @Test
//    public void snake_face_coordinate_should_move_when_the_direction_is_up() throws Exception {
//        Coordinates coordinates = new Coordinates(20,20);
//        List<Coordinates> snakeBody = new ArrayList<Coordinates>();
//        snakeBody.add(coordinates);
//        Snake snake = new Snake(snakeBody);
//        Snake newSnake = snake.move("up");
//        Coordinates current = newSnake.getBody().get(0);
//        assertEquals(21, current.getY());
//    }
//    @Test
//    public void snake_face_coordinate_should_move_when_the_direction_is_down() throws Exception {
//        Coordinates coordinates = new Coordinates(20,20);
//        List<Coordinates> snakeBody = new ArrayList<Coordinates>();
//        snakeBody.add(coordinates);
//        Snake snake = new Snake(snakeBody);
//        Snake newSnake = snake.move("down");
//        Coordinates current = newSnake.getBody().get(0);
//        assertEquals(19, current.getY());
//    }@Test
//    public void snake_face_coordinate_should_move_when_the_direction_is_right() throws Exception {
//        Coordinates coordinates = new Coordinates(20,20);
//        List<Coordinates> snakeBody = new ArrayList<Coordinates>();
//        snakeBody.add(coordinates);
//        Snake snake = new Snake(snakeBody);
//        Snake newSnake = snake.move("right");
//        Coordinates current = newSnake.getBody().get(0);
//        assertEquals(21, current.getX());
//    }@Test
//    public void snake_face_coordinate_should_move_when_the_direction_is_left() throws Exception {
//        Coordinates coordinates = new Coordinates(20,20);
//        List<Coordinates> snakeBody = new ArrayList<Coordinates>();
//        snakeBody.add(coordinates);
//        Snake snake = new Snake(snakeBody);
//        Snake newSnake = snake.move("left");
//        Coordinates current = newSnake.getBody().get(0);
//        assertEquals(19, current.getX());
//    }
//}