package com.object.objectstudy;

interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening, AudienceCount audienceCount);

    Money calculateFee(Money fee);
}