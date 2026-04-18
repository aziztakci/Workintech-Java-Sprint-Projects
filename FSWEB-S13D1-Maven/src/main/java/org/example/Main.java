package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean shouldWakeUp(boolean isBarking, int clock) {
        if (clock < 0 || clock > 23) {
            return false;
        }

        if (isBarking && (clock < 8 || clock >= 20)) {
            return true;
        }


        return false;
    }

    public static boolean hasTeen(int firstAge, int secondAge, int thirdAge) {
        int[] ages = {firstAge, secondAge, thirdAge};
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] >= 13 && ages[i] <= 19) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCatPlaying(boolean isSummer, int temp) {
        if (!isSummer && (temp >= 25 && temp <= 35)) {
            return true;
        } else if (isSummer && (temp >= 25 && temp <= 45)) {
            return true;
        } else {
            return false;
        }
    }

    public static double area(double width, double height) {
        if (width < 0 || height < 0) {
            return -1;
        }
        return width * height;
    }

    public static double area(double radius) {
        if(radius<0) {
            return -1;
        }
        return radius * radius * Math.PI;
    }
}
