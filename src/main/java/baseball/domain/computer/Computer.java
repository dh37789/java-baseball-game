package baseball.domain.computer;

import baseball.domain.Number;
import baseball.global.config.GameConfig;
import baseball.global.config.NumberConfig;
import baseball.global.utils.NumberGenerateUtils;

import java.util.List;

public class Computer {
    private Number number;

    private static Computer computer = new Computer();

    private Computer() {}

    public static Computer getInstance() {
        return computer;
    }

    public void createNumber() {
        number = new Number();
        List<Integer> numbers = NumberGenerateUtils.createUnipueNumberList(
                NumberConfig.MIN_NUMBER,NumberConfig.MAX_NUMBER, GameConfig.BALL_COUNT
        );
        number.setNumber(numbers);
    }

    public Number getNumber(){
        return number;
    }
}
