package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    final int n;

    Vector2d random_unique_position(int n){
        final int min = 0;
        final int max = (int)Math.sqrt((double)n * 10);
        Random rand = new Random();

        while(true)
        {
            int x = rand.nextInt((max - min) + 1) + min;
            int y = rand.nextInt((max - min) + 1) + min;
            Vector2d rand_position = new Vector2d(x,y);
            if(!isOccupied(rand_position)) {
                return rand_position;
            }
        }
    }

    GrassField(int n){
        this.n = n;
        for(int i = 0; i < n; i++)
        {
            Vector2d position = this.random_unique_position(this.n);
            elements.put(position,new Grass(position));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        Object object = objectAt(position);
        return !(object instanceof  Animal);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Object object = objectAt(newPosition);
        if(object instanceof Grass){
            Vector2d new_grass_position = random_unique_position(this.n);
            IMapElement grass_e = elements.remove(newPosition);
            elements.put(new_grass_position,grass_e);
        }
        super.positionChanged(oldPosition, newPosition);
    }

    @Override
    protected Vector2d upperRight(){
        if (elements.size() == 0) {
            return new Vector2d(0,0);
        }
        Optional<Vector2d> uR = this.elements.keySet().stream().reduce(Vector2d::upperRight);
        return uR.get();
    }

    @Override
    protected Vector2d lowerLeft(){
        if (elements.size() == 0) {
            return new Vector2d(0,0);
        }
        Optional<Vector2d> lL = this.elements.keySet().stream().reduce(Vector2d::lowerLeft);
        return lL.get();
    }
}

