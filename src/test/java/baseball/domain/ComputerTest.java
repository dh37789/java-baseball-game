package baseball.domain;

import baseball.domain.Computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {

    @Test
    @DisplayName("컴퓨터 3자리 숫자생성 테스트")
    void computer_number_create_테스트() {
        Computer computer = Computer.getInstance();

        computer.createNumber();

        Number number = computer.getNumber();
        List<Integer> list = number.numbers;

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터 중복안되는 숫자 생성 테스트")
    void computer_number_unipue_테스트() {
        Computer computer = Computer.getInstance();

        computer.createNumber();

        Number number = computer.getNumber();
        List<Integer> list = number.numbers;

        assertThat(list.get(0)).isNotEqualTo(list.get(1));
        assertThat(list.get(0)).isNotEqualTo(list.get(2));
        assertThat(list.get(1)).isNotEqualTo(list.get(0));
        assertThat(list.get(1)).isNotEqualTo(list.get(2));
        assertThat(list.get(2)).isNotEqualTo(list.get(0));
        assertThat(list.get(2)).isNotEqualTo(list.get(1));
    }
}
