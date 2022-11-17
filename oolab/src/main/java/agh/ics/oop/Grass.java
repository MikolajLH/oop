package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass implements IMapElement{
    private Vector2d position;

    public Grass(Vector2d position)
    {
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public boolean isAt(Vector2d position){return this.position.equals(position);}

    public String toString(){
        return "*";
    }
}
