package dev.cathers.adventofcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day4 extends Day {

    public List<Integer> solutionPartOne() {
        List<Integer> valid = new ArrayList<>();
        next:
        for (Integer i = 264793; i <= 803935; i++) {
            int[] digits = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            if (Arrays.stream(digits).distinct().count() == digits.length) continue;
                for (int j = 0; j < digits.length - 1; j++) {
                    if(digits[j] > digits[j + 1]) {
                        continue next;
                    }
                }
            valid.add(i);
        }
        return valid;
    }

    public long solutionPartTwo(List<Integer> valid) {
        return valid.stream().map(Object::toString).filter(f -> f.matches("^((\\d)\\2(?!\\2)\\d*|\\d*(\\d)(?!\\3)(\\d)\\4(?!\\4)\\d*)$")).count();
    }
}

