package baseball.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.Number;
import baseball.domain.user.User;
import baseball.domain.user.service.UserService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserServiceTest {

    @Test
    @Order(1)
    @DisplayName("빈값 입력 예외 테스트")
    void user_NOT_INPUT_exception_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.inputUserNumber(user);
        });
    }

    @Test
    @Order(2)
    @DisplayName("유저 글자입력시 예외 테스트")
    void user_INVALID_NUMBER_exception_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "1a3";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.inputUserNumber(user);
        });
    }

    @Test
    @Order(3)
    @DisplayName("0 입력 예외 테스트")
    void user_INPUT_ZERO_exception_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "103";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.inputUserNumber(user);
        });
    }

    @Test
    @Order(4)
    @DisplayName("유저 입력값 글자수 테스트")
    void user_INVALID_LENGTH_exception_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.inputUserNumber(user);
        });
    }

    @Test
    @Order(5)
    @DisplayName("유저 입력값 중복 체크 테스트")
    void user_INPUT_DUPLICATE_exception_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "112";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.inputUserNumber(user);
        });
    }

    @Test
    @Order(6)
    @DisplayName("유저 입력값 체크 테스트")
    void user_number_check_테스트() {
        UserService userService = new UserService();
        User user = User.getInstance();

        String input = "159";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        userService.inputUserNumber(user);
        Number number = user.getNumber();
        List<Integer> list = number.getNumberList();

        assertThatEquals(list);
    }

    private void assertThatEquals(List<Integer> list) {
        assertThat(list.get(0)).isNotEqualTo("1");
        assertThat(list.get(1)).isNotEqualTo("5");
        assertThat(list.get(2)).isNotEqualTo("9");
    }


}
