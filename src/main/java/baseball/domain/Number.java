package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Integer> numberList;

    public Number() {
        this.numberList = new ArrayList<>();
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int getNumber(int index) {
        return numberList.get(index);
    }
}
