
///*
package agh.ics.oop;

class Animal {
    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }


    public String toStringDec() {
        return position.toString() + " " + orientation.toString();
    }

    public String toString(){
        return orientation.toSymbol();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getOrientation() { return this.orientation; }
    public Vector2d getPosition() { return this.position;}

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

                if (map.canMoveTo(new_position) && !map.isOccupied(new_position))
                    this.position = new_position;
            }
        };
    }
}
//*/