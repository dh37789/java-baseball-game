package baseball.global.validate;

import java.util.*;
import java.util.regex.Pattern;

public class ValidateBaseball {

    private ValidateBaseball() {}

    private static final Pattern NUMBER = Pattern.compile("[0-9]+");

    public static boolean isEmpty(String ball) {
        return ball.isEmpty();
    }

    public static boolean isNumber(String ball) {
        return NUMBER.matcher(ball).matches();
    }

    public static boolean isContainZero(String ball) {
        return ball.contains("0");
    }

    public static boolean isValidLength(String ball, int count) {
        return ball.length() == count;
    }

    public static boolean isDuplicated(String ball) {
        List<Character> ballList = new ArrayList<>();
        for (int i = 0; i < ball.length(); i++) {
            ballList.add(ball.charAt(i));
        }
        Set<Character> ballSet = new HashSet<>(ballList);
        return ballList.size() != ballSet.size();
    }
}
