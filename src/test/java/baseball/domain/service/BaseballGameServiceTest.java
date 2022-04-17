package baseball.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.Application;
import baseball.domain.Number;
import baseball.domain.baseballgame.BaseballGame;
import baseball.domain.baseballgame.service.BaseballGameService;
import baseball.global.constant.GameStatus;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class BaseballGameServiceTest extends NsTest {
    
    @Test
    @DisplayName("같은 위치의 볼 체크 테스트")
    void isSameBall_test(){
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
    void isContainBall_test(){
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
    void insertBallCount_test() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        Number computerNumber = initNumbers("157");
        Number userNumber = initNumbers("715");
        BaseballGameService gameService = new BaseballGameService();

        gameService.insertBallCount(computerNumber, userNumber);

        assertThat(baseballGame.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("Strike count 계산 테스트")
    void insertStrikeCount_test() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        Number computerNumber = initNumbers("326");
        Number userNumber = initNumbers("396");
        BaseballGameService gameService = new BaseballGameService();

        gameService.insertStrikeCount(computerNumber, userNumber);

        assertThat(baseballGame.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("3Strike 테스트")
    void calcResult_threeStrike_test() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        baseballGame.setStrike(3);
        baseballGame.setBall(0);

        BaseballGameService gameService = new BaseballGameService();

        gameService.calcResult();

        assertThat(baseballGame.getStatus()).isEqualTo(GameStatus.END);
        assertThat(output()).contains("3스트라이크", "게임 종료");
    }

    @Test
    @DisplayName("nothing 테스트")
    void calcResult_Nothig_test() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        baseballGame.setStrike(0);
        baseballGame.setBall(0);

        BaseballGameService gameService = new BaseballGameService();

        gameService.calcResult();

        assertThat(output()).contains("낫싱");
    }

    @Test
    @DisplayName("calcResult 테스트")
    void calcResult_test() {
        BaseballGame baseballGame = BaseballGame.getInstance();
        baseballGame.setStrike(1);
        baseballGame.setBall(2);

        BaseballGameService gameService = new BaseballGameService();

        gameService.calcResult();

        assertThat(output()).contains("2볼 1스트라이크");
    }

    @Test
    @DisplayName("restart 공백 예외 테스트")
    void restart_NOT_INPUT_exception_test() {
        BaseballGameService gameService = new BaseballGameService();

        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.restartBaseballGame();
        });
    }

    @Test
    @DisplayName("restart 1과 2외의 값 입력시 예외 테스트1")
    void restart_NOT_INVALID_SELECT_exception_test1() {
        BaseballGameService gameService = new BaseballGameService();

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.restartBaseballGame();
        });
    }

    @Test
    @DisplayName("restart 1과 2외의 값 입력시 예외 테스트2")
    void restart_NOT_INVALID_SELECT_exception_test2() {
        BaseballGameService gameService = new BaseballGameService();

        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.restartBaseballGame();
        });
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
