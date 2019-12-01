package dev.cathers.adventofcode.solutions;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Day1 extends Day{
    UnaryOperator<Integer> calculateFuel = (v) -> v / 3 - 2;

    public int solutionPartOne() {
      return input.stream().mapToInt(Integer::parseInt).map(e -> calculateFuel.apply(e)).sum();
    }


    public int solutionPartTwo(){
        return input.stream().mapToInt(Integer::parseInt).map(this::calculateFuelForModule).sum();
    }

    private int calculateFuelForModule(int mass) {
        int fuelRequired = 0;
        while(calculateFuel.apply(mass) > 0){
            fuelRequired += (mass = calculateFuel.apply(mass));
        }
        return fuelRequired;
    }

}
