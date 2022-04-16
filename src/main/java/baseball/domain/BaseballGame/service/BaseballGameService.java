package baseball.domain.BaseballGame.service;

import baseball.domain.Computer.Computer;
import baseball.domain.User.User;
import baseball.domain.User.service.UserService;

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
