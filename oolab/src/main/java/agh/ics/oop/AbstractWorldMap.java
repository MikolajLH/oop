package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Map<Vector2d,IMapElement> elements = new HashMap<>();

    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            throw new IllegalArgumentException(animal.getPosition().toString() + " is occupied");

        this.elements.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position){
        return this.elements.getOrDefault(position, null);
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el = elements.remove(oldPosition);
        elements.put(newPosition,el);
    }

    abstract public Vector2d upperRight();

    abstract public Vector2d lowerLeft();

    final public String toString(){
        return new MapVisualizer(this).draw(lowerLeft(), upperRight());
    }
}
