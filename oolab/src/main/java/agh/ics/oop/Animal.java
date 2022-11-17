package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

class Animal implements IMapElement{
    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(IWorldMap map){
        this(map,new Vector2d(0,0));
    }

    @Override
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    @Override
    public Vector2d getPosition() { return this.position;}


    public MapDirection getOrientation() { return this.orientation; }


    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            default -> {
                final Vector2d delta =
                        direction == MoveDirection.FORWARD ?
                                orientation.toUnitVector() :
                                orientation.toUnitVector().opposite();

                final Vector2d new_position = this.position.add(delta);

                if(this.map.canMoveTo(new_position))
                {
                    final Vector2d old_position = this.position;
                    this.position = new_position;
                    for(IPositionChangeObserver o : observers)
                        o.positionChanged(old_position, new_position);
                }
            }
        }
    }

    public String toStringDep() {
        return position.toString() + " " + orientation.toString();
    }

    @Override
    public String toString(){
        return orientation.toSymbol();
    }
}
//*/