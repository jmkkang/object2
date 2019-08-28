package com.object.objectstudy;

public class CountPercentDiscount extends PercentDiscount {
    private final AudienceCount count;

    public CountPercentDiscount(double percent, AudienceCount count) {
        super(percent);
        this.count = count;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, AudienceCount audienceCount) {
        return audienceCount.greaterThanEqual(this.count);
    }
}