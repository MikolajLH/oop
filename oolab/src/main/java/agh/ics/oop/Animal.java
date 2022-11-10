package agh.ics.oop;

//*
class Animal implements IMapElement{
    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(IWorldMap map){
        this.map = map;
        this.position = new Vector2d(0,0);
    }

    public String toStringDep() {
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

                if(this.map.move_element(this,new_position))
                {
                    this.position = new_position;
                }
            }
        }
    }
}
//*/