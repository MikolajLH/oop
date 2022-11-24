package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    final int n;
    MapBoundary mapBoundary = new MapBoundary();

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

    public GrassField(int n){
        this.n = n;
        for(int i = 0; i < n; i++)
        {
            Grass grass = new Grass(this.random_unique_position(this.n));
            this.add(grass);
        }
    }

    private void add(IMapElement e){
        elements.put(e.getPosition(),e);
        mapBoundary.add(e);
    }

    @Override
    public boolean place(Animal animal){
        super.place(animal);
        animal.addObserver(mapBoundary);
        mapBoundary.add(animal);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        Object object = objectAt(position);
        return !(object instanceof  Animal);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(objectAt(newPosition) instanceof Grass){
            elements.remove(newPosition);
            Grass new_grass = new Grass(this.random_unique_position(this.n));
            this.add(new_grass);
        }
        super.positionChanged(oldPosition, newPosition);
    }

    @Override
    public Vector2d upperRight(){
        return mapBoundary.upperRight();
        /*
        if (elements.size() == 0) {
            return new Vector2d(0,0);
        }
        Optional<Vector2d> uR = this.elements.keySet().stream().reduce(Vector2d::upperRight);
        return uR.get();
        */
    }

    @Override
    public Vector2d lowerLeft(){
        return mapBoundary.lowerLeft();
        /*
        if (elements.size() == 0) {
            return new Vector2d(0,0);
        }
        Optional<Vector2d> lL = this.elements.keySet().stream().reduce(Vector2d::lowerLeft);
        return lL.get();
        */
    }
}

