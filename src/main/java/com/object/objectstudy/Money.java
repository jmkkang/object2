package com.object.objectstudy;

public class Money {
    public static Money of(Double amount) {
        return new Money(amount);
    }

    private final Double amount;

    Money(Double amount) {
        this.amount = amount;
    }

    public Money minus(Money amount) {
        return new Money(this.amount > amount.amount ? this.amount - amount.amount : 0.0);
    }

    public Money multi(Number number) {
        return new Money(this.amount * number.getNumber());
    }

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public boolean greaterThen(Money amount) {
        return this.amount >= amount.amount;
    }

    public Double getAmount() {
        return this.amount;
    }

}