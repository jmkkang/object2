package com.object.objectstudy;

public class CountAmountDiscount extends AmountDiscount{
    private final AudienceCount count;

    public CountAmountDiscount(Money amount, AudienceCount count) {
        super(amount);
        this.count = count;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, AudienceCount audienceCount) {
        return audienceCount.greaterThanEqual(this.count);
    }
}