package com.object.objectstudy;

public class PeriodAmountDiscount extends AmountDiscount {
    private final Period period;

    public PeriodAmountDiscount(Money amount, Period period) {
        super(amount);
        this.period = period;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, AudienceCount audienceCount) {
       return screening.isAfterScreeningDate(this.period.getStartDate())
               && screening.isBeforeScreeningDate(this.period.getEndDate());
    }
}
