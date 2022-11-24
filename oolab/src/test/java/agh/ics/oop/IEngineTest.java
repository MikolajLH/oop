package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IEngineTest {

    @Test
    void Test(){

        String[] args = {"f", "b", "r", "f", "f", "f", "f", "left", "b" , "b" ,"b"};
        try {
            MoveDirection[] directions = OptionsParser.parse(Arrays.stream(args).toList());

            AbstractWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = {new Vector2d(1, 3), new Vector2d(2, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);


            try {
                map.place(new Animal(map, new Vector2d(10, 10)));
            }
            catch (IllegalArgumentException ignored){
                ;
            }
            Assertions.assertTrue(map.isOccupied(new Vector2d(1, 3)));
            Assertions.assertNotNull(map.objectAt(new Vector2d(2, 4)));
        }
        catch(Exception e){
            Assertions.fail("this part of code is not supposed to throw any exceptions");
        }
    }
    @Test
    void Test2(){
        String[] args = {"f", "test", "aaa", "Left"};
        try {
            MoveDirection[] directions = OptionsParser.parse(Arrays.stream(args).toList());
        }
        catch(IllegalArgumentException e){
            Assertions.assertEquals("test is not legal move specification", e.getMessage());
        }
    }
}
