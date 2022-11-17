package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IEngineTest {

    @Test
    void Test1(){

        String[] args = {"f b r f f f f left b b b"};
        MoveDirection[] directions = OptionsParser.parse(args);

        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(1,3), new Vector2d(2,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        Assertions.assertFalse(map.place(new Animal(map, new Vector2d(10,10))));

        Assertions.assertTrue(map.isOccupied(new Vector2d(1,3)));

        Assertions.assertNotNull(map.objectAt(new Vector2d(2, 4)));
    }

    @Test
    void Test2(){
        String[] args = {"f b r l f f r r f f f f f f f f"};
        //String[] args = {"f f"};
        MoveDirection[] directions = OptionsParser.parse(args);

        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,4)));
    }

}
