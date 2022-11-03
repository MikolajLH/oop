package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IEngineTest {

    @Test
    void Test1(){

        String[] args = {"f b r l f f r r f f f f f f f f"};
        MoveDirection[] directions = new OptionsParser().parse(args);

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,4)));
    }

}
