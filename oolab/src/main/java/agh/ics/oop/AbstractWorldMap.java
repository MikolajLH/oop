package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    //protected LinkedList<IMapElement> elements = new LinkedList<>();

    public Map<Vector2d,IMapElement> elements = new HashMap<>();

    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            return false;

        this.elements.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position){
        return this.elements.getOrDefault(position, null);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el = elements.remove(oldPosition);
        elements.put(newPosition,el);
    }

    abstract protected Vector2d upperRight();

    abstract protected Vector2d lowerLeft();

    final public String toString(){
        return new MapVisualizer(this).draw(lowerLeft(), upperRight());
    }
}
