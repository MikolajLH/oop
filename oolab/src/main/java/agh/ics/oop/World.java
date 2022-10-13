package agh.ics.oop;

public class World {

    public static void main(String[] args){
        System.out.println("Start");

        Direction[] directions = new Direction[args.length];

        for (int i = 0; i < directions.length; i++) {
            directions[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.FORWARD;
            };
        }

        run(directions);

        System.out.println("Stop");
    }
    public static void run(Direction[] directions){

        for(Direction d : directions){
            String message  = switch (d){
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case LEFT -> "zwierzak skręca w lewo";
                case RIGHT -> "zwierzak skręca w prawo";
            };
            System.out.println(message);
        }
    }
}
