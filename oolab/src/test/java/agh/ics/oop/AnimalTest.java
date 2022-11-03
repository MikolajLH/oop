/*package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
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
    public void AnimalTest_1(){
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertEquals(animal.getOrientation(),MapDirection.NORTH);
        final int w = Animal.w + 1;
        final int h = Animal.h + 1;

        for(int i=0; i < w;i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition().y, N-1);
        for(int i=0; i < w;i++)
            animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.getPosition().y,0);


        animal.move(MoveDirection.RIGHT);
        for(int i=0; i < h;i++)
            animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.getPosition().x,N-1);

        for(int i=0; i < h; i++)
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
    public void TestAnimal_2() {
        final String[] commands_s =
                {"f", "f", "l", "f"};
        final MoveDirection[] commands_e =
                {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD};

        MoveDirection[] parsed = OptionsParser.parse(commands_s);

        for (MoveDirection e : parsed)
            animal.move(e);
        Assertions.assertTrue(animal.isAt(new Vector2d(1, 4)));
        Assertions.assertEquals(animal.getOrientation(), MapDirection.WEST);
    }


    @Test
    public void TestAnimal_3() {
        final String[] commands_s =
                {"test","niepoprawny", "forward", "L", "   ", "asdfg", "backward", "f", "l", "right", "left", "f", "f" ,"f", "f"};

        MoveDirection[] parsed = OptionsParser.parse(commands_s);

        for (MoveDirection e : parsed)
            animal.move(e);
        Assertions.assertTrue(animal.isAt(new Vector2d(0, 3)));
        Assertions.assertEquals(animal.getOrientation(), MapDirection.WEST);
    }
}

 */
