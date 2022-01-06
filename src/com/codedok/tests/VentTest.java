package com.codedok.tests;

import com.codedok.Vent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VentTest {

    @Test
    public void testVentFromString() {
        String vent = "0,9";

        Vent expected = new Vent(0,9);
        Vent actual = Vent.getFromString(vent);

        Assertions.assertEquals(expected, actual);
    }
}
