package baseball.domain.BaseballGame;

import baseball.global.constant.GameStatus;

public class BaseballGame {
    private GameStatus status;

    public BaseballGame(GameStatus status) {
        this.status = status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public boolean isComputerReady(GameStatus status) {
        return status == GameStatus.COMPUTER_READY;
    }

    public boolean isRunning(GameStatus status) {
        return status == GameStatus.RUNNING;
    }

}
