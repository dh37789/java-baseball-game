package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ComputerTest {

    @Test
    @DisplayName("컴퓨터 3자리 숫자생성 테스트")
    void computer_number_create_test() {
        Computer computer = Computer.getInstance();

        computer.createNumber();

        Number number = computer.getNumber();
        List<Integer> list = number.getNumberList();

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터 중복안되는 숫자 생성 테스트")
    void computer_number_unipue_test() {
        Computer computer = Computer.getInstance();

        computer.createNumber();

        Number number = computer.getNumber();
        List<Integer> list = number.getNumberList();

        assertThatEquals(list);
    }

    private void assertThatEquals(List<Integer> list) {
        assertThat(list.get(0)).isNotEqualTo(list.get(1));
        assertThat(list.get(0)).isNotEqualTo(list.get(2));
        assertThat(list.get(1)).isNotEqualTo(list.get(0));
        assertThat(list.get(1)).isNotEqualTo(list.get(2));
        assertThat(list.get(2)).isNotEqualTo(list.get(0));
        assertThat(list.get(2)).isNotEqualTo(list.get(1));
    }

}
