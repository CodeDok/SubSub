package com.codedok.tests;

import com.codedok.Line;
import com.codedok.Ocean;
import com.codedok.Vent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class OceanTest {

    static ArrayList<Line> expectedLines;

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

    @BeforeAll
    public static void setup() {
        expectedLines = new ArrayList<>();
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("0,9"), Vent.getFromString("5,9")));
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("9,4"), Vent.getFromString("3,4")));
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("2,2"), Vent.getFromString("2,1")));
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("7,0"), Vent.getFromString("7,4")));
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("0,9"), Vent.getFromString("2,9")));
        expectedLines.add(Line.getFromEndpoints(Vent.getFromString("3,4"), Vent.getFromString("1,4")));
    }

    @Test
    public void testAutoGridSize() {
        Ocean expected = new Ocean(expectedLines, 10, 10);
        Ocean actual = Ocean.getWithAutoGridSize(expectedLines);

        Assertions.assertArrayEquals(expected.getGrid(), actual.getGrid());
    }

    @Test
    public void testGridFill() {
        int[][] expected = new int[][] {
                {0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,1,0,0,0,0,2},
                {0,1,1,0,1,0,0,0,0,2},
                {0,0,0,0,2,0,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,0},
                {1,1,1,1,2,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
        };

        Ocean ocean = Ocean.getWithAutoGridSize(expectedLines);
        Assertions.assertArrayEquals(expected, ocean.getGrid());
    }



}
