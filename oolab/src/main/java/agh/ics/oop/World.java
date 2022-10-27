package agh.ics.oop;


public class World {

    public static void main(String[] args) {
        /*String s = switch (d){
            case BACKWARD -> "b";
            case FORWARD -> "f";
            case LEFT -> "l";
            case RIGHT -> "r";
        };*/
        MoveDirection[] commands = OptionsParser.parse(args);

        Animal animal = new Animal();
        for(MoveDirection c : commands)
            animal.move(c);
    }
}
