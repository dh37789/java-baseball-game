package baseball.domain.User;

public class User {
    private static User user = new User();

    private User() {}

    public static User getInstance() {
        return user;
    }
}
