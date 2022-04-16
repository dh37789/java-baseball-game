package baseball.domain.baseballgame.service;

import baseball.domain.Number;
import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.user.service.UserService;
import baseball.global.config.GameConfig;

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

}
