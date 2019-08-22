package com.object.objectstudy;

abstract public class SequenceDiscount implements DiscountCondition {
    private final int sequence;

    SequenceDiscount(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public final boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}
