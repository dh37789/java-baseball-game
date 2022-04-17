package baseball.controller;

import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.baseballgame.service.BaseballGameService;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.global.constant.GameStatus;
import baseball.global.constant.MessageConfig;

public class BaseballGameController {
    private static BaseballGame baseballGame;
    private static BaseballGameService baseballGameService;
    private static Computer computer;
    private static User user;

    public static BaseballGameController init(){
        baseballGame = BaseballGame.getInstance();
        BaseballGame.init();
        baseballGameService = new BaseballGameService();
        computer = Computer.getInstance();
        user = User.getInstance();
        return new BaseballGameController();
    }

    public void play(){
        do {
            createComputerNumber();
            startBaseballGame();
        }while (!baseballGame.isRunning(GameStatus.RUNNING));
    }

    public void createComputerNumber(){
        baseballGame.setStatus(GameStatus.READY);
        baseballGameService.createComputerNumber(computer);
    }

    private void startBaseballGame() {
        baseballGame.setStatus(GameStatus.RUNNING);
        do {
            baseballGameService.createUserNumber(user);
            baseballGameService.getResult(computer, user);
        } while (baseballGame.isRunning(baseballGame.getStatus()));
        restartBaseballGame();
    }

    private void restartBaseballGame() {
        System.out.println(MessageConfig.RESTART_REQUEST);
        baseballGameService.restartBaseballGame();

        if (baseballGame.isStart(baseballGame.getStatus())){
            play();
        }
    }
}
