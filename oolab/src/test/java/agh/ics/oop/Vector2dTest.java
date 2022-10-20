package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d v = new Vector2d(1,2);
        Vector2d u = new Vector2d(1,2);

        Vector2d k = new Vector2d(1,3);
        Vector2d l = new Vector2d(3,2);
        Vector2d m = new Vector2d(3,3);
        int n = 1;

        Assertions.assertEquals(Boolean.TRUE,v.equals(v));
        Assertions.assertEquals(Boolean.TRUE,v.equals(u));

        Assertions.assertEquals(Boolean.FALSE,v.equals(k));
        Assertions.assertEquals(Boolean.FALSE,v.equals(l));
        Assertions.assertEquals(Boolean.FALSE,v.equals(m));
        Assertions.assertEquals(Boolean.FALSE,v.equals(n));
    }

    @Test
    public void toStringTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d u = new Vector2d(1,2);
        Vector2d k = new Vector2d(2,1);
        Vector2d l = new Vector2d(-1,-30);
        Vector2d m = new Vector2d(23,-18);
        Vector2d n = new Vector2d(-3,19);

        Assertions.assertEquals("(0,0)",v.toString());
        Assertions.assertEquals("(1,2)",u.toString());
        Assertions.assertEquals("(2,1)",k.toString());
        Assertions.assertEquals("(-1,-30)",l.toString());
        Assertions.assertEquals("(23,-18)",m.toString());
        Assertions.assertEquals("(-3,19)",n.toString());
    }

    @Test
    public void precedesTest(){
        Vector2d v = new Vector2d(0,0);

        Assertions.assertEquals(Boolean.TRUE, v.precedes(v));
        Assertions.assertEquals(Boolean.TRUE, v.precedes(new Vector2d(1,1)));
        Assertions.assertEquals(Boolean.TRUE, v.precedes(new Vector2d(0,1)));
        Assertions.assertEquals(Boolean.TRUE, v.precedes(new Vector2d(1,0)));
    }

    @Test
    public void followsTest(){
        Vector2d v = new Vector2d(0,0);

        Assertions.assertEquals(Boolean.TRUE, v.follows(v));
        Assertions.assertEquals(Boolean.TRUE, v.follows(new Vector2d(-1,-1)));
        Assertions.assertEquals(Boolean.TRUE, v.follows(new Vector2d(0,-1)));
        Assertions.assertEquals(Boolean.TRUE, v.follows(new Vector2d(-1,0)));
    }

    @Test
    public void upperRightTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d u = new Vector2d(1,1);

        Vector2d p = new Vector2d(0,1);
        Vector2d q = new Vector2d(1,0);

        Assertions.assertEquals(u, v.upperRight(u));
        Assertions.assertEquals(u, u.upperRight(v));

        Assertions.assertEquals(u,p.upperRight(q));
        Assertions.assertEquals(u,q.upperRight(p));

        Assertions.assertEquals(v, v.upperRight(v));
    }


    @Test
    public void lowerLeftTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d u = new Vector2d(1,1);

        Vector2d p = new Vector2d(0,1);
        Vector2d q = new Vector2d(1,0);


        Assertions.assertEquals(v, v.lowerLeft(u));
        Assertions.assertEquals(v, u.lowerLeft(v));

        Assertions.assertEquals(v, p.lowerLeft(q));
        Assertions.assertEquals(v, q.lowerLeft(p));

        Assertions.assertEquals(v, v.upperRight(v));
    }

    @Test
    public void addTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d p = new Vector2d(1,0);
        Vector2d q = new Vector2d(0,1);
        Vector2d w = new Vector2d(1,1);
        Vector2d s = new Vector2d(-1,-1);

        Assertions.assertEquals(v, v.add(v));
        Assertions.assertEquals(p, p.add(v));
        Assertions.assertEquals(q, q.add(v));
        Assertions.assertEquals(w, w.add(v));

        Assertions.assertEquals(w, p.add(q));
        Assertions.assertEquals(w, q.add(p));

        Assertions.assertEquals(v, w.add(s));
        Assertions.assertEquals(v, s.add(w));
    }

    @Test
    public void subtractTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d p = new Vector2d(1,0);
        Vector2d q = new Vector2d(0,1);
        Vector2d w = new Vector2d(1,1);
        Vector2d s = new Vector2d(-1,-1);

        Assertions.assertEquals(v, v.subtract(v));
        Assertions.assertEquals(p, p.subtract(v));
        Assertions.assertEquals(q, q.subtract(v));
        Assertions.assertEquals(w, w.subtract(v));

        Assertions.assertEquals(p, w.subtract(q));
        Assertions.assertEquals(q, w.subtract(p));

        Assertions.assertEquals(new Vector2d(2,2), w.subtract(s));
        Assertions.assertEquals(new Vector2d(-2,-2), s.subtract(w));

        Assertions.assertEquals(v,w.subtract(w));
        Assertions.assertEquals(v,s.subtract(s));
    }

    @Test
    public void oppositeTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d p = new Vector2d(1,0);
        Vector2d q = new Vector2d(0,1);
        Vector2d w = new Vector2d(1,1);
        Vector2d s = new Vector2d(-1,-1);

        Assertions.assertEquals(v,v.opposite());

        Assertions.assertEquals(s,w.opposite());
        Assertions.assertEquals(w,s.opposite());

        Assertions.assertEquals(new Vector2d(-1,0),p.opposite());
        Assertions.assertEquals(new Vector2d(0,-1),q.opposite());
    }
}
