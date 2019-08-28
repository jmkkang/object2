package com.object.objectstudy;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Movie<T extends DiscountPolicy & DiscountCondition> {
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final Set<T> discountConditions = new HashSet<>();

    public Movie(String title, Duration runningTime, Money fee, T... conditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions.addAll(Arrays.asList(conditions));
    }

    Money calculateFee(Screening screening, AudienceCount audienceCount) {
        Money resultFee = this.fee;

        for (T condition : discountConditions) {
            if (condition.isSatisfiedBy(screening, audienceCount)) {

                resultFee = condition.calculateFee(resultFee);

                System.out.println("할인 내역 = "+condition+" / "+resultFee.getAmount());
            }
        }

        return resultFee.multi(audienceCount);
    }
}