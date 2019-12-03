package dev.cathers.adventofcode.solutions;

import java.util.*;

public class Day3 extends Day {

    public double solutionPartOne(){
        List<String> wireOnePath = Arrays.asList(input.get(0).split(","));
        List<String> wireTwoPath = Arrays.asList(input.get(1).split(","));
        List<Point> wireOnePoints= calculateEnd(wireOnePath);
        List<Point> wireTwoPoints = calculateEnd(wireTwoPath);
        List<Point> crossing = new ArrayList<>();
        for(Point point: wireOnePoints){
            if(wireTwoPoints.contains(point)){
                crossing.add(wireTwoPoints.remove(wireTwoPoints.indexOf(point)));
            }
        }
        int min = Integer.MAX_VALUE;
        Point starting = new Point(0, 0);
        for(Point point: crossing){
            int value = starting.calcDist(point);
            if(value < min){
                min = value;
            }
        }
        return min;
    }

    public double solutionPartTwo(){
        List<String> wireOnePath = Arrays.asList(input.get(0).split(","));
        List<String> wireTwoPath = Arrays.asList(input.get(1).split(","));
        List<Point> wireOnePoints= calculateEnd(wireOnePath);
        List<Point> wireTwoPoints = calculateEnd(wireTwoPath);
        List<Integer> steps = new ArrayList<>();
        for(Point point: wireOnePoints){
            if(wireTwoPoints.contains(point)){
            //    steps.add(wireTwoPoints.indexOf(point) + wireOnePoints.indexOf(point) );
                return wireTwoPoints.indexOf(point) + wireOnePoints.indexOf(point);
            }
        }

        int min = Integer.MAX_VALUE;
        Point starting = new Point(0, 0);

        for(int point: steps){
            if(point < min){
                min = point;
            }
        }
        return min;
    }



    List<Point> calculateEnd(List<String> path){
        int nextX = 0;
        int nextY = 0;
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        for(String value: path){
            Point lastPoint = points.get(points.size() - 1);
            if(value.startsWith("U")){
                nextY += Integer.parseInt(value.substring(1));
                while(lastPoint.y < nextY){
                    points.add(new Point(lastPoint.x, ++lastPoint.y));
                }
            }
            if(value.startsWith("D")){
                nextY -= Integer.parseInt(value.substring(1));
                while(lastPoint.y > nextY){
                    points.add(new Point(lastPoint.x, --lastPoint.y));
                }
            }
            if(value.startsWith("L")){
                nextX -= Integer.parseInt(value.substring(1));
                while(lastPoint.x > nextX){
                    points.add(new Point(--lastPoint.x, lastPoint.y));
                }
            }
            if(value.startsWith("R")){
                nextX += Integer.parseInt(value.substring(1));
                while(lastPoint.x < nextX){
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
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int calcDist(Point p){
        return Math.abs(x-p.x) + Math.abs(y-p.y);
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

    public String toString(){
        return String.format("(%d, %d)", x, y);
    }
}
