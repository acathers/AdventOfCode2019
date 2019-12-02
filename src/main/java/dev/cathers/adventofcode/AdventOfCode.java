package dev.cathers.adventofcode;

import dev.cathers.adventofcode.solutions.Day1;
import dev.cathers.adventofcode.solutions.Day2;

public class AdventOfCode {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println("Day 1 part 1: " + day1.solutionPartOne());
        System.out.println("Day 1 part 2: " + day1.solutionPartTwo());
        Day2 day2 = new Day2();
        System.out.println("Day 2 part 1: " + day2.solutionPartOne(12,2));
        System.out.println("Day 2 part 2: " + day2.solutionPartTwo());
    }
}
