package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        Point third = new Point(38977, 111);

        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));

        System.out.println("distance(third)= " + first.distance(third));

        Point point = new Point(0, 0);
        System.out.println("distance()= " + point.distance());
    }
}