package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class UserTest {

    @Test
    @DisplayName("유저 숫자 저장 테스트")
    void user_setUserNumber_test() {
        User user = User.getInstance();
        user.setUserNumber("427");

        Number number = user.getNumber();
        List<Integer> list = number.getNumberList();
        assertThat(list.get(0)).isEqualTo(4);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(7);
    }
}
