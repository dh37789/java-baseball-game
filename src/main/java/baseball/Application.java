package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGame = BaseballGameController.init();
        baseballGame.play();
    }
}
