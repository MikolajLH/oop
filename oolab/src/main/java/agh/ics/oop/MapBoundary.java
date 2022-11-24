package agh.ics.oop;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    SortedSet<Integer> setX = new TreeSet<>();
    SortedSet<Integer> setY = new TreeSet<>();

    public Vector2d upperRight(){
        return new Vector2d(setX.last(), setY.last());
    }

    public Vector2d lowerLeft(){
        return new Vector2d(setX.first(), setY.first());
    }

    public void add(IMapElement e){
        setX.add(e.getPosition().x);
        setY.add(e.getPosition().y);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        setX.remove(oldPosition.x);
        setY.remove(oldPosition.y);

        setX.add(newPosition.x);
        setY.add(newPosition.y);
    }
}
