package baseball.domain.baseballgame;

import baseball.global.constant.GameStatus;

public class BaseballGame {
    private GameStatus status;
    private int ball;
    private int strike;

    private static BaseballGame baseballGame = new BaseballGame();

    public static BaseballGame getInstance() {
        return baseballGame;
    }

    public BaseballGame initBaseballGame() {
        this.status = GameStatus.START;
        this.ball = 0;
        this.strike = 0;
        return getInstance();
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public boolean isReady(GameStatus status) {
        return status == GameStatus.READY;
    }

    public boolean isRunning(GameStatus status) {
        return status == GameStatus.RUNNING;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
