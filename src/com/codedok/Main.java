package com.codedok;

public class Main {

    static String puzzleInput =
            "0,9 -> 5,9\n" +
            "8,0 -> 0,8\n" +
            "9,4 -> 3,4\n" +
            "2,2 -> 2,1\n" +
            "7,0 -> 7,4\n" +
            "6,4 -> 2,0\n" +
            "0,9 -> 2,9\n" +
            "3,4 -> 1,4\n" +
            "0,0 -> 8,8\n" +
            "5,5 -> 8,2";

    public static void main(String[] args) {
        Submarine sub = Submarine.getFromVentString("SubSub", puzzleInput);
        Ocean ocean = Ocean.getWithAutoGridSize(sub.getNearbyVentLines());
        System.out.printf(
                "The Submarine \"%s\" found %s dangerously overlapping vent lines!%n",
                sub.getName(),
                sub.getNumberOfDangerousOverlaps(ocean)
        );
        System.out.println("\nVent Map:");
        for (int x = 0; x < ocean.getGrid().length; x++) {
            for (int y = 0; y < ocean.getGrid()[x].length; y++) {
                System.out.print(ocean.getGrid()[y][x] + " | ");
            }
            System.out.println();
        }
    }
}
