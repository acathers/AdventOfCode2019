package dev.cathers.adventofcode;

import dev.cathers.adventofcode.solutions.Day1;
import dev.cathers.adventofcode.solutions.Day2;
import dev.cathers.adventofcode.solutions.Day3;
import dev.cathers.adventofcode.solutions.Day4;
import java.util.List;

public class AdventOfCode {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println("Day 1 part 1: " + day1.solutionPartOne());
        System.out.println("Day 1 part 2: " + day1.solutionPartTwo());
        Day2 day2 = new Day2();
        System.out.println("Day 2 part 1: " + day2.solutionPartOne(12,2));
        System.out.println("Day 2 part 2: " + day2.solutionPartTwo());
        Day3 day3 = new Day3();
        System.out.println("Day 3 part 1: " + day3.solutionPartOne());
        System.out.println("Day 3 part 2: " + day3.solutionPartTwo());
        Day4 day4 = new Day4();
        List<Integer> valid = day4.solutionPartOne();
        System.out.println("Day 4 part 1: " + valid.size() );
        System.out.println("Day 4 part 2: " + day4.solutionPartTwo(valid));
    }
}
