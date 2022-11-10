package agh.ics.oop;


class RectangularMap extends AbstractWorldMap{

    private final int Width;
    private final int Height;

    RectangularMap(int width, int height)
    {
        this.Width = width;
        this.Height = height;
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
}
