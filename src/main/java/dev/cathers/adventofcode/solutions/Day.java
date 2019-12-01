package dev.cathers.adventofcode.solutions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public abstract class Day {
        protected List<String> input;

        protected Day() {
            String filename = this.getClass().getSimpleName() + ".input";
            try {
                input = Files.readAllLines(Path.of(Objects.requireNonNull(this.getClass().getClassLoader().getResource("input/" + filename)).toURI()));
            } catch (IOException | URISyntaxException e) {
                System.out.println("Could not find input file for " + this.getClass().getSimpleName());
            }
        }
    }

