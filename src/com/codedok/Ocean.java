package com.codedok;

import java.util.ArrayList;
import java.util.Arrays;

public class Ocean {

    public static final int DEFAULT_DANGER_LEVEL = 0;
    private int[][] grid;
    private ArrayList<Line> ventLines;


    public Ocean(ArrayList<Line> ventLines, int gridXSize, int gridYSize) {
        this.ventLines = ventLines;
        this.grid = new int[gridXSize][gridYSize];
        setGridValuesToZero();
        fillGridWithVents();
    }

    public static Ocean getWithAutoGridSize(ArrayList<Line> ventLines) {
        int xSize = ventLines.stream()
                .map(value -> value.getVents().stream()
                        .map(Vent::getxPosition)
                        .max(Integer::compare)
                        .get())
                .max(Integer::compare).get() + 1;
        int ySize = ventLines.stream()
                .map(value -> value.getVents().stream()
                        .map(Vent::getyPosition)
                        .max(Integer::compare)
                .get()).max(Integer::compare).get() + 1;
        return new Ocean(ventLines, xSize, ySize);
    }

    private void setGridValuesToZero() {
        for (int[] line : grid) {
            Arrays.fill(line, Ocean.DEFAULT_DANGER_LEVEL);
        }
    }

    private void fillGridWithVents() {
        ventLines.forEach(line -> {
            line.getVents().forEach(vent -> this.grid[vent.getxPosition()][vent.getyPosition()]++);
        });
    }

    public int[][] getGrid() {
        return grid;
    }

    public ArrayList<Line> getVentLines() {
        return ventLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ocean ocean = (Ocean) o;

        if (!Arrays.deepEquals(grid, ocean.grid)) return false;
        return ventLines != null ? ventLines.equals(ocean.ventLines) : ocean.ventLines == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(grid);
        result = 31 * result + (ventLines != null ? ventLines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ocean{" +
                "grid=" + Arrays.toString(grid) +
                ", ventLines=" + ventLines +
                '}';
    }
}
