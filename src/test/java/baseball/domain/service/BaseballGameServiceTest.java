package baseball.domain.service;

import baseball.domain.Number;
import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.baseballgame.service.BaseballGameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballGameServiceTest {
    
    @Test
    @DisplayName("같은 위치의 볼 체크 테스트")
    void isSameBall_테스트(){
        Number computerNumber = initNumbers("157");
        Number userNumber = initNumbers("167");

        BaseballGameService gameService = new BaseballGameService();
        boolean isSameBallFirst = gameService.isSameBall(computerNumber, userNumber, 0);
        boolean isSameBallSecond = gameService.isSameBall(computerNumber, userNumber, 1);
        boolean isSameBallThird = gameService.isSameBall(computerNumber, userNumber, 2);

        assertThat(isSameBallFirst).isTrue();
        assertThat(isSameBallSecond).isFalse();
        assertThat(isSameBallThird).isTrue();
    }

    @Test
    @DisplayName("숫자 포함여부 테스트")
    void isContainBall_테스트(){
        Number computerNumber = initNumbers("157");
        Number userNumber = initNumbers("715");

        BaseballGameService gameService = new BaseballGameService();
        boolean isContainBallFirst = gameService.isContainBall(computerNumber, userNumber, 0);
        boolean isContainBallSecond = gameService.isContainBall(computerNumber, userNumber, 1);
        boolean isContainBallThird = gameService.isContainBall(computerNumber, userNumber, 2);

        assertThat(isContainBallFirst).isTrue();
        assertThat(isContainBallSecond).isTrue();
        assertThat(isContainBallThird).isTrue();
    }
    
    @Test
    @DisplayName("ball count 계산 테스트")
    void insertBallCount_테스트() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        Number computerNumber = initNumbers("157");
        Number userNumber = initNumbers("715");
        BaseballGameService gameService = new BaseballGameService();

        gameService.insertBallCount(computerNumber, userNumber);

        assertThat(baseballGame.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("Strike count 계산 테스트")
    void insertStrikeCount_테스트() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        Number computerNumber = initNumbers("326");
        Number userNumber = initNumbers("396");
        BaseballGameService gameService = new BaseballGameService();

        gameService.insertStrikeCount(computerNumber, userNumber);

        assertThat(baseballGame.getStrike()).isEqualTo(2);
    }

    private Number initNumbers(String numberString) {
        Number number = new Number();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberString.length(); i++){
            numbers.add(Integer.parseInt(numberString.split("")[i]));
        }
        number.setNumberList(numbers);
        return number;
    }
}
