package com.gshoogeveen.serverclient.quadtree;

public class Interval2DD { 
    public final IntervalD intervalX;   // x-interval
    public final IntervalD intervalY;   // y-interval
   
    public Interval2DD(IntervalD intervalX, IntervalD intervalY) {
        this.intervalX = intervalX;
        this.intervalY = intervalY;
    }

    // does this 2D interval a intersect b?
    public boolean intersects(Interval2DD b) {
        if (intervalX.intersects(b.intervalX)) return true;
        if (intervalY.intersects(b.intervalY)) return true;
        return false;
    }

    // does this 2D interval contain (x, y)?
    public boolean contains(double x, double y) {
        return intervalX.contains(x) && intervalY.contains(y);
    }

    // return string representation
    public String toString() {
        return intervalX + " x " + intervalY;
    }
}