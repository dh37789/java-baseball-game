package baseball.global.validate;

public class ValidateCommon {
    private ValidateCommon() {}

    public static boolean isEmpty(String ball) {
        return ball.isEmpty();
    }

    public static boolean isValidLength(String ball, int count) {
        return ball.length() == count;
    }

}
