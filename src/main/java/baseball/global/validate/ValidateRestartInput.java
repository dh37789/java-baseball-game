package baseball.global.validate;

import baseball.global.config.GameConfig;

public class ValidateRestartInput {

    private ValidateRestartInput() {}

    public static boolean isInvalidSelect(String restartGame) {
        return GameConfig.RESTART.equals(restartGame)|| GameConfig.END.equals(restartGame);
    }
}
