package agh.ics.oop;


import java.util.LinkedList;

class RectangularMap implements IWorldMap{

    private final int Width;
    private final int Height;
    private LinkedList<Animal> animals;

    RectangularMap(int width, int height)
    {
        this.Width = width;
        this.Height = height;
        animals = new LinkedList<>();
    }

    public Vector2d upperRight(){
        return new Vector2d(Width,Height);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(0,0);
    }

    public boolean canMoveTo(Vector2d position){
        return position.x >= 0 && position.x <= this.Width && position.y >= 0 && position.y <= this.Height;
    }

    public boolean place(Animal animal){
        if(this.isOccupied(animal.getPosition()) || !canMoveTo(animal.getPosition()))
            return false;

        this.animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        for(Animal animal : this.animals) {
            if (animal.isAt(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal : this.animals)
            if(animal.isAt(position))
                return animal;
        return null;
    }

    public String toString(){
        return new MapVisualizer(this).draw(lowerLeft(), upperRight());
    }

}
