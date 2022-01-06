package com.codedok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Submarine {

    public static final int OVERLAPS_FOR_DANGER = 2;
    private String name;
    private ArrayList<Line> nearbyVentLines;


    public Submarine(String name, ArrayList<Line> nearbyVentLines) {
        this.name = name;
        this.nearbyVentLines = nearbyVentLines;
    }

    public static Submarine getFromVentString(String name, String nearbyVentLines) {
        return new Submarine(name, Submarine.convertStringToLines(nearbyVentLines));
    }

    private static ArrayList<Line> convertStringToLines(String nearbyVentLines) {
        String[] ventLines = nearbyVentLines.split("\n");
        ArrayList<Line> lines = Arrays.stream(ventLines).map(lineAsString -> {
            ArrayList<Vent> lineEndpointVents = Arrays.stream(lineAsString.split(" -> "))
                    .map(Vent::getFromString)
                    .collect(Collectors.toCollection(ArrayList::new));
            return Line.getFromEndpoints(lineEndpointVents.get(0), lineEndpointVents.get(1));
        })
        .filter(Objects::nonNull)
        .collect(Collectors.toCollection(ArrayList::new));
        return lines;
    }

    public int getNumberOfDangerousOverlaps(Ocean ocean) {
        int[][] grid = ocean.getGrid();
        int numberOfDangerousOverlaps = 0;
        for(int[] line : grid) {
            for(int cell : line) {
                if(cell >= Submarine.OVERLAPS_FOR_DANGER) {
                    numberOfDangerousOverlaps++;
                }
            }
        }
        return numberOfDangerousOverlaps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Line> getNearbyVentLines() {
        return nearbyVentLines;
    }

    public void setNearbyVentLines(ArrayList<Line> nearbyVentLines) {
        this.nearbyVentLines = nearbyVentLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Submarine submarine = (Submarine) o;

        if (name != null ? !name.equals(submarine.name) : submarine.name != null) return false;
        return nearbyVentLines != null ? nearbyVentLines.equals(submarine.nearbyVentLines) : submarine.nearbyVentLines == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nearbyVentLines != null ? nearbyVentLines.hashCode() : 0);
        return result;
    }
}
