package baseball.domain.baseballgame.service;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.user.service.UserService;

public class BaseballGameService {
    private final UserService userService;

    public BaseballGameService() {
        this.userService = new UserService();
    }

    public void createComputerNumber(Computer computer) {
        computer.createNumber();
    }

    public void createUserNumber(User user) {
        userService.inputUserNumber(user);

    }
}
