package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.List;

public class OptionsParser {


    public static MoveDirection[] parse(String[] args) {

        Function<String,MoveDirection> convert =
                (String s) -> switch (s) {
                                    case "b", "backward" -> MoveDirection.BACKWARD;
                                    case "f", "forward" -> MoveDirection.FORWARD;
                                    case "l", "left" -> MoveDirection.LEFT;
                                    case "r", "right" -> MoveDirection.RIGHT;
                                    default -> null;
                                };

        return Arrays.stream(args).
                map(convert).
                filter(Objects::nonNull).
                toList().toArray(MoveDirection[]::new);
    }
}
