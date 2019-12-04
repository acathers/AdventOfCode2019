package dev.cathers.adventofcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 extends Day {
    List<Integer> valid = new ArrayList<>();
    public List<Integer> solutionPartOne(){
           for(int i  = 264793; i <= 803935; i++){
            int[] digits = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            if(Arrays.stream(digits).distinct().toArray().length ==  digits.length ) {
                continue;
            }
           for(int j = 0; j < 5; j++){
                if(digits[j] > digits[j+1]){
                    break;
                }
                if(j == 4){
                    valid.add(i);
                }
           }
        }
        return valid;
    }

    public int solutionPartTwo(List<Integer> valid){
        List<String> stillValid = valid.stream().map(Object::toString).filter(f -> f.matches("^((\\d)\\2(?!\\2)\\d*|\\d*(\\d)(?!\\3)(\\d)\\4(?!\\4)\\d*)$")).collect(Collectors.toList());
        return stillValid.size();
    }
}
