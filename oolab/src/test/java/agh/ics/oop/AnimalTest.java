package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    private Animal animal;
    final int N = 5;

    @BeforeEach
    public void init(){
        this.animal = new Animal();
    }


    @Test
    public void AnimalTest(){
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertEquals(animal.getOrientation(),MapDirection.NORTH);
        final int w = 6;

        for(int i=0; i < w;i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition().y, N-1);
        for(int i=0; i < w;i++)
            animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.getPosition().y,0);


        animal.move(MoveDirection.RIGHT);
        for(int i=0; i < w;i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition().x,N-1);

        for(int i=0; i < w; i++)
            animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.getPosition().x,0);

        Assertions.assertTrue(animal.isAt(new Vector2d(0,0)));
        Assertions.assertEquals(animal.getOrientation(), MapDirection.EAST);

        for(int i=0; i < 4; i++)
            animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.EAST);

        for(int i=0; i < 4; i++)
            animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.getOrientation(), MapDirection.EAST);
    }

    @Test
    public void TestAnimal2() {
        final String[] commands_1_s =
                {"f", "f", "l", "f"};
        final MoveDirection[] commands_1_e =
                {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};

        MoveDirection[] parsed_1 = OptionsParser.parse(commands_1_s);

        for (MoveDirection e : parsed_1)
            animal.move(e);
        Assertions.assertTrue(animal.isAt(new Vector2d(1, 4)));
        Assertions.assertEquals(animal.getOrientation(), MapDirection.WEST);


        final String[] commands_2_s =
                {"test", "forward", "L", "   ", "backward", "f", "l", "right", "left"};
        final MoveDirection[] commands_2_e =
                {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};

        MoveDirection[] parsed_2 = OptionsParser.parse(commands_2_s);

        for (MoveDirection e : parsed_2)
            animal.move(e);
        Assertions.assertTrue(animal.isAt(new Vector2d(0, 4)));
        Assertions.assertEquals(animal.getOrientation(), MapDirection.SOUTH);
    }
}
