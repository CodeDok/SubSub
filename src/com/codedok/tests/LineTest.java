package com.codedok.tests;

import com.codedok.Line;
import com.codedok.Vent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LineTest {

    @Test
    public void testLineFromEndpoints() {
        // 0,9 -> 5,9
        ArrayList<Vent> vents = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            vents.add(new Vent(i,9));
        }
        Line expected = new Line(vents);
        Line actual = Line.getFromEndpoints(new Vent(0,9), new Vent(5,9));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testLineFromEndpointsDiagonal() {
        // 8,0 -> 0,8
        Line actual = Line.getFromEndpoints(new Vent(8,0), new Vent(0,8));

        Assertions.assertNull(actual);
    }
}
