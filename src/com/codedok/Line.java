package com.codedok;

import java.util.ArrayList;

public class Line {
    private ArrayList<Vent> vents;

    public Line(ArrayList<Vent> vents) {
        this.vents = vents;
    }

    public static Line getFromEndpoints(Vent vent1, Vent vent2) {
        ArrayList<Vent> vents = new ArrayList<>();
        if(vent1.getxPosition() == vent2.getxPosition()) {
            if(vent1.getyPosition() > vent2.getyPosition()) {
                Vent tmpVent = vent2;
                vent2 = vent1;
                vent1 = tmpVent;
            }
            for (int y = vent1.getyPosition(); y <= vent2.getyPosition(); y++) {
                vents.add(new Vent(vent1.getxPosition(), y));
            }
        } else if (vent1.getyPosition() == vent2.getyPosition()) {
            if(vent1.getxPosition() > vent2.getxPosition()) {
                Vent tmpVent = vent2;
                vent2 = vent1;
                vent1 = tmpVent;
            }
            for (int x = vent1.getxPosition(); x <= vent2.getxPosition(); x++) {
                vents.add(new Vent(x, vent1.getyPosition()));
            }
        } else {
            return null;
        }
        return new Line(vents);
    }

    public ArrayList<Vent> getVents() {
        return vents;
    }

    public void setVents(ArrayList<Vent> vents) {
        this.vents = vents;
    }

    @Override
    public String toString() {
        return "Line{" +
                "vents=" + vents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return vents != null ? vents.equals(line.vents) : line.vents == null;
    }

    @Override
    public int hashCode() {
        return vents != null ? vents.hashCode() : 0;
    }
}
