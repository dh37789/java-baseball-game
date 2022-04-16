package baseball.controller;

import baseball.domain.BaseballGame.BaseballGame;
import baseball.domain.BaseballGame.service.BaseballGameService;
import baseball.domain.Computer.Computer;
import baseball.global.constant.GameStatus;

public class BaseballGameController {
    private static BaseballGame baseballGame;
    private static BaseballGameService baseballGameService;

    public static BaseballGameController init(){
        baseballGame = new BaseballGame(GameStatus.START);
        baseballGameService = new BaseballGameService();
        return new BaseballGameController();
    }

    public void play(){
        baseballGame.setStatus(GameStatus.COMPUTER_READY);
        do {
            Computer computer = Computer.getInstance();
            baseballGame = baseballGameService.createComputerNumber(computer, baseballGame);
        }while (!baseballGame.isComputerReady(baseballGame.getStatus()));
    }
}
