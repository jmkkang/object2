package com.object.objectstudy;

public class CommissionRate implements Number {
    private final double rate;

    static CommissionRate of(double rate) {
        return new CommissionRate(rate);
    }

    public CommissionRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getNumber() {
        return this.rate;
    }
}
