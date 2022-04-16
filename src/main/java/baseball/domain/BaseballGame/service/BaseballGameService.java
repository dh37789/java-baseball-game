package baseball.domain.BaseballGame.service;

import baseball.domain.BaseballGame.BaseballGame;
import baseball.domain.Computer.Computer;
import baseball.global.constant.GameStatus;

public class BaseballGameService {
    public BaseballGame createComputerNumber(Computer computer, BaseballGame baseballGame) {
        computer.createNumber();
        baseballGame.setStatus(GameStatus.USER_READY);
        return baseballGame;
    }
}
