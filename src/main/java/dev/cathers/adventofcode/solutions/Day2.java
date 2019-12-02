package dev.cathers.adventofcode.solutions;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day2 extends Day {

    public int solutionPartOne(int addressOne, int addressTwo){
        int[] values = Stream.of(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        values[1] = addressOne;
        values[2] = addressTwo;
        for(int i = 0; i < values.length; i+=4){
                int opCode = values[i];
                if(opCode == 99){
                    break;
                }
                int val1 = values[values[i + 1]];
                int val2 = values[values[i + 2]];
                values[values[i + 3]] = calculate(opCode, val1, val2);

        }
        return values[0];
    }

    public int calculate(int opcode, int val1, int val2){
        if(opcode == 1){
            return val1 + val2;
        }

        if(opcode == 2) {
            return val1 * val2;
        }
        return 0;
    }

    public int solutionPartTwo(){
        for(int noun = 0; noun < 100; noun++){
            for(int verb = 0; verb < 100; verb++) {
               if(solutionPartOne(noun, verb) == 19690720){
                   return 100 * noun + verb;
                }
            }
        }
        return -1;
    }
}
