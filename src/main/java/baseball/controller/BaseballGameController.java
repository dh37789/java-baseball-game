package baseball.controller;

import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.baseballgame.service.BaseballGameService;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.global.constant.GameStatus;

public class BaseballGameController {
    private static BaseballGame baseballGame;
    private static BaseballGameService baseballGameService;
    private static Computer computer;
    private static User user;

    public static BaseballGameController init(){
        baseballGame = new BaseballGame(GameStatus.START);
        baseballGameService = new BaseballGameService();
        computer = Computer.getInstance();
        user = User.getInstance();
        return new BaseballGameController();
    }

    public void play(){
        do {
            createComputerNumber(computer);
            startBaseballGame(user);
        }while (!baseballGame.isRunning(GameStatus.RUNNING));
    }

    public void createComputerNumber(Computer computer){
        baseballGame.setStatus(GameStatus.READY);
        baseballGameService.createComputerNumber(computer);
    }

    private void startBaseballGame(User user) {
        baseballGame.setStatus(GameStatus.RUNNING);
        do {
            baseballGameService.createUserNumber(user);
        } while (!baseballGame.isRunning(GameStatus.RUNNING));
    }
}
