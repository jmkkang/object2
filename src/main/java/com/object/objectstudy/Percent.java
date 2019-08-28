package com.object.objectstudy;

public class Percent implements Number {
    static Percent of(double percent) {
        return new Percent(percent);
    }

    private final double percent;

    public Percent(double percent) {
        this.percent = percent;
    }

    @Override
    public double getNumber() {
        return this.percent;
    }
}
