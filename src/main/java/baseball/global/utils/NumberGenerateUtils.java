package baseball.global.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerateUtils {
    private NumberGenerateUtils() {}

    public static int createRandomNumber(int minNumber, int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

    public static List<Integer> createUnipueNumberList(int minNumber, int maxNumber, int count) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < count) {
            set.add(createRandomNumber(minNumber, maxNumber));
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
}
