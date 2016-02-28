import java.util.*;

public class Snake{
    private ArrayList<Coordinate> body;
    public Coordinate prev;
    private Coordinate face;
    public String direction1;

    public ArrayList<Coordinate> getBody() {
        return body;
    }

    public Snake(ArrayList<Coordinate> body, Coordinate face) {
        this.body = body;
        this.face = face;
        this.direction1 = "up";
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

    public boolean move(String direction) {
        if (Objects.equals(direction, "up") && !Objects.equals(this.direction1, "down")) {
            manipulate("y", -5);
            this.direction1 = direction;
        }
        else if (Objects.equals(direction, "down") && !Objects.equals(this.direction1, "up")) {
            manipulate("y", 5);
            this.direction1 = direction;
        }
        else if (Objects.equals(direction, "right") && !this.direction1.equals("left")){
            manipulate("x", 5);
            this.direction1 = direction;
        }
        else if (Objects.equals(direction, "left") && !Objects.equals(this.direction1, "right")){
            manipulate("x", -5);
            this.direction1 = direction;
        }else return false;
        return true;
    }

    public boolean isDead(String dir){
        int x = getBody().get(0).getX();
        int y = getBody().get(0).getY();
        for (int i = 1; i < getBody().size()-1; i++) {
            if(getBody().get(i).getX() == x && getBody().get(i).getY() == y) return true;
        }
        return x < 0 || x > 500 || y < 20 || y > 500;
    }
    public boolean eat(Coordinate food){
        if(body.get(0).getX() == food.getX() && body.get(0).getY() == food.getY()){
            body.add(new Coordinate(body.get(0).getX(), body.get(0).getY()));
            return true;
        }
        return false;
    }
}
