package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x,int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other){
        return other.precedes(this);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(
                other.x > this.x ? other.x : this.x,
                other.y > this.y ? other.y : this.y);
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(
                other.x < this.x ? other.x : this.x,
                other.y < this.y ? other.y : this.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x,this.y);
        /*
        int prime = 89;
        int result = 1;
        result = prime * result + (this.x < 0 ? 13 * this.x : 19 * this.x);
        result = prime * result + (this.y < 0 ? 17 * this.y : 23 * this.y);
        return result;
        */
    }

    public int getX(){
        return  x;
    }
    public int getY(){
        return y;
    }
}
