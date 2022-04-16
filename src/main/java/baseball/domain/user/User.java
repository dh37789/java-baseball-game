package baseball.domain.user;

import baseball.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Number number;

    private static User user = new User();

    private User() {}

    public static User getInstance() {
        return user;
    }

    public Number getNumber(){
        return number;
    }

    public void setUserNumber(String ball) {
        number = new Number();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ball.length(); i++) {
            numbers.add(Integer.parseInt(ball.split("")[i]));
        }
        number.setNumberList(numbers);
    }
}
