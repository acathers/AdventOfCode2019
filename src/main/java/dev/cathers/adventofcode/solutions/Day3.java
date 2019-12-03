package dev.cathers.adventofcode.solutions;
import java.util.*;
import java.util.stream.Collectors;

public class Day3 extends Day {
    List<String> wireOnePath = Arrays.asList(input.get(0).split(","));
    List<String> wireTwoPath = Arrays.asList(input.get(1).split(","));
    List<Point> wireOnePoints = calculateEnd(wireOnePath);
    List<Point> wireTwoPoints = calculateEnd(wireTwoPath);
    HashSet<Point> wireTwoPointsFast = new HashSet<>(wireTwoPoints);
    HashMap<Point, Integer> wireOnePointQuickIndex = new HashMap<>();
    HashMap<Point, Integer> wireTwoPointQuickIndex = new HashMap<>();
    List<Point> intersections = wireOnePoints.stream().filter(wireTwoPointsFast::contains).collect(Collectors.toList());

    public int solutionPartOne() {
       return intersections.stream()
               .map(new Point(0, 0)::calcDist)
               .min(Integer::compareTo)
               .orElse(-1);
    }

    public int solutionPartTwo() {
        wireOnePoints.stream().forEachOrdered(point -> wireOnePointQuickIndex.put(point, wireOnePointQuickIndex.size()));
        wireTwoPoints.stream().forEachOrdered(point -> wireTwoPointQuickIndex.put(point, wireTwoPointQuickIndex.size()));
        return intersections.stream()
                .map(point -> wireTwoPointQuickIndex.get(point) + wireOnePointQuickIndex.get(point)).min(Integer::compareTo)
                .orElse(-1);
    }

    List<Point> calculateEnd(List<String> path) {
        int nextX = 0;
        int nextY = 0;
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        for (String value : path) {
            Point lastPoint = points.get(points.size() - 1);
            if (value.startsWith("U")) {
                nextY += Integer.parseInt(value.substring(1));
                while (lastPoint.y < nextY) {
                    points.add(new Point(lastPoint.x, ++lastPoint.y));
                }
            } else if (value.startsWith("D")) {
                nextY -= Integer.parseInt(value.substring(1));
                while (lastPoint.y > nextY) {
                    points.add(new Point(lastPoint.x, --lastPoint.y));
                }
            } else if (value.startsWith("L")) {
                nextX -= Integer.parseInt(value.substring(1));
                while (lastPoint.x > nextX) {
                    points.add(new Point(--lastPoint.x, lastPoint.y));
                }
            } else if (value.startsWith("R")) {
                nextX += Integer.parseInt(value.substring(1));
                while (lastPoint.x < nextX) {
                    points.add(new Point(++lastPoint.x, lastPoint.y));
                }
            }
        }
        return points;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcDist(Point p) {
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
