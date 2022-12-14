package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IMapTest {

    @Test
    public void RectangularMapTest(){

        IWorldMap map = new RectangularMap(10,5);
        Animal animal_1 = new Animal(map, new Vector2d(11,6));

        Vector2d init_pos = new Vector2d(3,3);
        Animal animal_2 = new Animal(map, init_pos);

        try {
            map.place(animal_1);
        }
        catch(IllegalArgumentException e){
            Assertions.assertEquals("(11,6) is occupied",e.getMessage());
        }
        catch(Exception e)
        {
            Assertions.fail("this part of code is not supposed to throw any exceptions");
        }

        try{
            map.place(animal_2);
        }
        catch(Exception e){
            Assertions.fail("this part of code is not supposed to throw any exceptions");
        }


        Assertions.assertTrue(map.isOccupied(init_pos));

        Assertions.assertTrue(map.objectAt(init_pos) instanceof Animal);
        Assertions.assertNull(map.objectAt(new Vector2d(1, 1)));


        animal_2.move(MoveDirection.FORWARD);

        Assertions.assertTrue(map.isOccupied(init_pos.add(new Vector2d(0,1))));
    }

    @Test
    public void GrassFieldTest(){

        final int n = 10;
        final int min = 0;
        final int max = (int)Math.sqrt((double)n * 10);

        IWorldMap map = new GrassField(n);

        int counter = 0;
        Vector2d grass_position = new Vector2d(-1,-1);
        for(int x = min; x <= max; x++)
        {
            for(int y = min; y <= max; y++)
            {
                Vector2d position = new Vector2d(x,y);
                if(map.isOccupied(position))
                {
                    counter++;
                    grass_position = position;
                }
            }
        }
        Assertions.assertNotEquals(grass_position, new Vector2d(-1, -1));
        Assertions.assertEquals(n,counter);
        Assertions.assertTrue(map.objectAt(grass_position) instanceof Grass);


        Animal animal = new Animal(map,grass_position);

        try{
            map.place(animal);
        }
        catch(Exception e)
        {
            Assertions.fail("this part of code is not supposed to throw any exceptions");
        }


        animal.move(MoveDirection.FORWARD);

        Assertions.assertNull(map.objectAt(grass_position));
    }


}
