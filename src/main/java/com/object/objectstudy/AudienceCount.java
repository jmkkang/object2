package com.object.objectstudy;

public class AudienceCount implements Number {
    public static AudienceCount of(double count) {
        return new AudienceCount(count);
    }

    private final double count;

    public AudienceCount(double count) {
        this.count = count;
    }

    public boolean greaterThanEqual(AudienceCount count) {
        return this.count >= count.count;
    }

    @Override
    public double getNumber() {
        return this.count;
    }
}