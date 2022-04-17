package baseball.domain.baseballgame.service;

import baseball.domain.Number;
import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.user.service.UserService;
import baseball.global.config.GameConfig;
import baseball.global.constant.ErrorCode;
import baseball.global.constant.GameStatus;
import baseball.global.constant.MessageConfig;
import baseball.global.utils.ConsoleUtils;
import baseball.global.validate.ValidateCommon;
import baseball.global.validate.ValidateRestartInput;

public class BaseballGameService {
    private final UserService userService;
    private final BaseballGame baseballGame;

    public BaseballGameService() {
        this.userService = new UserService();
        this.baseballGame = BaseballGame.getInstance();
    }

    public void createComputerNumber(Computer computer) {
        computer.createNumber();
    }

    public void createUserNumber(User user) {
        userService.inputUserNumber(user);
    }

    public void getResult(Computer computer, User user) {
        Number computerNumber = computer.getNumber();
        Number userNumber = user.getNumber();
        insertBallCount(computerNumber, userNumber);
        insertStrikeCount(computerNumber, userNumber);
        calcResult();
    }

    public void insertBallCount(Number computerNumber, Number userNumber) {
        int ball = 0;
        for (int i = 0; i < GameConfig.BALL_COUNT; i++){
            ball += getBallCount(computerNumber, userNumber, i);
        }
        baseballGame.setBall(ball);
    }

    public void insertStrikeCount(Number computerNumber, Number userNumber) {
        int strike = 0;
        for (int i = 0; i < GameConfig.BALL_COUNT; i++){
            strike += getStrikeCount(computerNumber, userNumber, i);
        }
        baseballGame.setStrike(strike);
    }

    private int getBallCount(Number computerNumber, Number userNumber, int index) {
        if (isSameBall(computerNumber, userNumber, index)){
            return 0;
        }

        if (isContainBall(computerNumber, userNumber, index)) {
            return 1;
        }

        return 0;
    }

    private int getStrikeCount(Number computerNumber, Number userNumber, int index) {
        if (isSameBall(computerNumber, userNumber, index)){
            return 1;
        }

        return 0;
    }

    public boolean isSameBall(Number computerNumber, Number userNumber, int index) {
        return computerNumber.getNumber(index) == userNumber.getNumber(index);
    }

    public boolean isContainBall(Number computerNumber, Number userNumber, int index) {
        return computerNumber.getNumberList().contains(userNumber.getNumber(index));
    }

    public void calcResult() {
        if (isEndGame(baseballGame.getStrike())){
            System.out.print(baseballGame.getStrike() + "스트라이크");
            System.out.println(MessageConfig.GAME_WIN);
            baseballGame.setStatus(GameStatus.END);
            return;
        }

        if (isNothing(baseballGame.getStrike(), baseballGame.getBall())){
            System.out.println(MessageConfig.NOTHING);
            return;
        }

        getResultMessage();
    }

    private boolean isEndGame(int strike) {
        return strike == 3;
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0&&ball == 0;
    }

    private void getResultMessage() {
        if (baseballGame.getBall() > 0) {
            System.out.print(baseballGame.getBall() + "볼 ");
        }

        if (baseballGame.getStrike() > 0) {
            System.out.print(baseballGame.getStrike() + "스트라이크");
        }

        System.out.println();
    }

    public void restartBaseballGame() {
        String restartGame = ConsoleUtils.inputDate();
        validateInputRestart(restartGame);
        if ("2".equals(restartGame)){
            return;
        }

        if ("1".equals(restartGame)){
            BaseballGame.init();
        }
    }

    private void validateInputRestart(String restartGame) {
        isInputRestartBlank(restartGame);
        isInputValidSelect(restartGame);
    }

    private void isInputRestartBlank(String restartGame) {
        if (ValidateCommon.isEmpty(restartGame)) {
            throw new IllegalArgumentException(ErrorCode.NOT_INPUT.getMessage());
        }
    }

    private void isInputValidSelect(String restartGame) {
        if (!ValidateRestartInput.isInvalidSelect(restartGame)){
            throw new IllegalArgumentException(ErrorCode.NOT_INVALID_SELECT.getMessage());
        }
    }
}
