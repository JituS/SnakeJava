import java.util.*;

public class Snake{
    private ArrayList<Coordinate> body;
    public Coordinate prev;
    private Coordinate face;

    public Coordinate getFace() {
        return face;
    }

    public ArrayList<Coordinate> getBody() {
        return body;
    }

    public Snake(ArrayList<Coordinate> body, Coordinate face) {
        this.body = body;
        this.face = face;
    }

    public void manipulate(String cord, int moveTo){
        Coordinate coordinate  = this.body.get(0);
        Coordinate newCoordinate = (cord == "y") ?
                new Coordinate(coordinate.getX(), coordinate.getY() + moveTo):
                new Coordinate(coordinate.getX() + moveTo, coordinate.getY());
        this.body.set(0, newCoordinate);
        for (int i = 1; i < this.body.size(); i++){
            Coordinate c = this.body.get(i);
            this.body.set(i, coordinate);
            this.prev = coordinate = c;
        }
    }

    public void move(String direction) {
        if (Objects.equals(direction, "up")) {
            manipulate("y", -5);
        }
        if (Objects.equals(direction, "down")) {
            manipulate("y", 5);
        }
        if (Objects.equals(direction, "right")) {
            manipulate("x", 5);
        }
        if (Objects.equals(direction, "left")) {
            manipulate("x", -5);
        }
    }
    public boolean eat(Coordinate food){
        if(body.get(0).getX() == food.getX() && body.get(0).getY() == food.getY()){
            body.add(new Coordinate(body.get(0).getX(), body.get(0).getY()));
            return true;
        }
        return false;
    }
}
