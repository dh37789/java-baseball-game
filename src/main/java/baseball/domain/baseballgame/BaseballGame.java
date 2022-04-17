package baseball.domain.baseballgame;

import baseball.global.constant.GameStatus;

public class BaseballGame {
    private static GameStatus status;
    private static int ball;
    private static int strike;

    private static BaseballGame baseballGame = new BaseballGame();

    public static BaseballGame getInstance() {
        return baseballGame;
    }

    public static void init() {
        status = GameStatus.START;
        ball = 0;
        strike = 0;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public boolean isStart(GameStatus status) {
        return status == GameStatus.START;
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
