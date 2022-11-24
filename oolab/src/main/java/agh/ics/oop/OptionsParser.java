package agh.ics.oop;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class OptionsParser {

    public static MoveDirection[] parse(List<String> args) {

        Function<String,MoveDirection> convert =
                (String s) -> switch (s) {
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> throw new IllegalArgumentException(s + " is not legal move specification");
            };

        return args.stream().
                map(convert).
                toArray(MoveDirection[]::new);
    }
}
