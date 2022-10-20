package agh.ics.oop;


public class World {

    public static void main(String[] args) {

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));


        MapDirection N = MapDirection.NORTH;
        MapDirection E = MapDirection.EAST;
        MapDirection S = MapDirection.SOUTH;
        MapDirection W = MapDirection.WEST;

        System.out.println(N);
        System.out.println(E);
        System.out.println(S);
        System.out.println(W);

        System.out.println();

        System.out.println(N.next());
        System.out.println(E.next());
        System.out.println(S.next());
        System.out.println(W.next());

        System.out.println();

        Vector2d Nv = N.toUnitVector();
        Vector2d Ev = E.toUnitVector();
        Vector2d Sv = S.toUnitVector();
        Vector2d Wv = W.toUnitVector();

        System.out.println(Nv);
        System.out.println(Ev);
        System.out.println(Sv);
        System.out.println(Wv);
    }
}
