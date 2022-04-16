package baseball.domain.user.service;

import baseball.domain.user.User;
import baseball.global.config.GameConfig;
import baseball.global.constant.ErrorCode;
import baseball.global.constant.MessageConfig;
import baseball.global.utils.ConsoleUtils;
import baseball.global.validate.ValidateBaseball;

public class UserService {
    public void inputUserNumber(User user) {
        System.out.print(MessageConfig.PLEASE_INPUT_NUMBER);
        String ball = ConsoleUtils.inputDate();
        isValidateBall(ball);
        user.setUserNumber(ball);
    }

    private void isValidateBall(String ball) {
        isBallBlank(ball);
        isBallNumber(ball);
        isBallThreeLength(ball);
        isBallContainZero(ball);
        isBallDuplicated(ball);
    }

    private void isBallBlank(String ball) {
        if (ValidateBaseball.isEmpty(ball)) {
            throw new IllegalArgumentException(ErrorCode.NOT_INPUT.getMessage());
        }
    }

    private void isBallNumber(String ball) {
        if (!ValidateBaseball.isNumber(ball)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER.getMessage());
        }
    }

    private void isBallThreeLength(String ball) {
        if (!ValidateBaseball.isValidLength(ball, GameConfig.BALL_COUNT)) {
            throw new IllegalArgumentException(ErrorCode.INPUT_ZERO.getMessage());
        }
    }

    private void isBallContainZero(String ball) {
        if (ValidateBaseball.isContainZero(ball)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LENGTH.getMessage());
        }
    }

    private void isBallDuplicated(String ball) {
        if (ValidateBaseball.isDuplicated(ball)) {
            throw new IllegalArgumentException(ErrorCode.INPUT_DUPLICATE.getMessage());
        }
    }
}
