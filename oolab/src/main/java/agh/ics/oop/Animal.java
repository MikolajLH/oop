
///*
package agh.ics.oop;

import java.util.Optional;
import java.util.function.Function;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;

    public Animal() {

    }

    public String toString() {
        return position.toString() + " " + orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getOrientation() { return this.orientation; }
    public Vector2d getPosition() { return this.position;}

    public static boolean is_safe(Vector2d position, int w, int h){
        return position.x >= 0 && position.x < w && position.y >= 0 && position.y < h;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            default -> {
                Vector2d delta =
                        direction == MoveDirection.FORWARD ?
                                orientation.toUnitVector() :
                                orientation.toUnitVector().opposite();

                final Vector2d new_position = this.position.add(delta);

                if (is_safe(new_position, 5, 5))
                    this.position = new_position;
            }
        };
    }
}
//*/