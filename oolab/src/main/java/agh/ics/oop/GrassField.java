package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    Vector2d random_position(int n){
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
    final int n;

    public boolean place(Animal animal){
        boolean free = move_element(animal,animal.getPosition());
        if(!free){
            return false;
        }
        elements.add(animal);
        return true;
    }

    GrassField(int n){
        this.n = n;
        for(int i = 0; i < n; i++)
        {
            elements.add(new Grass(this.random_position(this.n)));
        }
    }

    public boolean canMoveTo(Vector2d position){
        return true;
    }

    public boolean move_element(IMapElement el, Vector2d new_position){
        Object object = objectAt(new_position);
        if(object instanceof Animal){
            return false;
        }
        if(object instanceof Grass){
            elements.add(new Grass(random_position(this.n)));
            elements.remove(object);
            return true;
        }
        return true;
    }

    protected Vector2d upperRight(){

        if (elements.size() == 0)
        {
            return new Vector2d(0,0);
        }
        Vector2d uR = elements.get(0).getPosition();
        return this.elements.stream().
                map(IMapElement::getPosition).
                reduce(uR,Vector2d::upperRight);
    }

    protected Vector2d lowerLeft(){
        if (elements.size() == 0)
        {
            return new Vector2d(0,0);
        }
        Vector2d lL = elements.get(0).getPosition();

        return this.elements.stream().
                map(IMapElement::getPosition).
                reduce(lL,Vector2d::lowerLeft);
    }
}

