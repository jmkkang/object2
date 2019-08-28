package com.object.objectstudy;

public class SequenceAmountDiscount extends AmountDiscount {
    private final int sequence;

    public SequenceAmountDiscount(Money amount, int sequence) {
        super(amount);
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, AudienceCount audienceCount) {
        System.out.println(screening.getSequence()+"/"+sequence);
        return screening.getSequence() == sequence;
    }
}