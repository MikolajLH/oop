package agh.ics.oop;

import java.util.LinkedList;

abstract class AbstractWorldMap implements IWorldMap {

    protected LinkedList<IMapElement> elements = new LinkedList<>();

    public boolean canMoveTo(Vector2d position){
        return true;
    }

    public boolean place(Animal animal){
        if(this.isOccupied(animal.getPosition()) || !canMoveTo(animal.getPosition()))
            return false;

        this.elements.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position){
        for(IMapElement e : this.elements)
            if(e.isAt(position))
                return e;
        return null;
    }

    public boolean move_element(IMapElement el, Vector2d new_position) {
        return this.canMoveTo(new_position) && !this.isOccupied(new_position);
    }

    abstract protected Vector2d upperRight();

    abstract protected Vector2d lowerLeft();

    public String toString(){
        return new MapVisualizer(this).draw(lowerLeft(), upperRight());
    }
}
