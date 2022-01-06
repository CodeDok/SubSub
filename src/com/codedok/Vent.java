package com.codedok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vent {
    private int xPosition;
    private int yPosition;

    public Vent(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static Vent getFromString(String vent) {
        List<Integer> positions = Arrays.stream(vent.split(",")).map(Integer::valueOf).toList();
        return new Vent(positions.get(0), positions.get(1));
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public String toString() {
        return "Vent{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vent vent = (Vent) o;

        if (xPosition != vent.xPosition) return false;
        return yPosition == vent.yPosition;
    }

    @Override
    public int hashCode() {
        int result = xPosition;
        result = 31 * result + yPosition;
        return result;
    }
}
