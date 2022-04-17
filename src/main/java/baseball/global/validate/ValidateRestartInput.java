package baseball.global.validate;

public class ValidateRestartInput {

    private ValidateRestartInput() {}

    public static boolean isInvalidSelect(String restartGame) {
        return "1".equals(restartGame)||"2".equals(restartGame);
    }
}
