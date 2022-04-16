package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    static List<Integer> numbers;

    public Number() {
        this.numbers = new ArrayList<>();
    }

    public void setNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
