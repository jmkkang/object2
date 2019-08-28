package com.object.objectstudy;

import java.time.LocalDateTime;

public class Screening {
    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(int sequence, LocalDateTime when) {
        this.sequence = sequence;
        this.whenScreened = when;
    }

    public int getSequence() {
        return this.sequence;
    }

    public boolean isAfterScreeningDate(LocalDateTime date) {
        return this.whenScreened.isAfter(date);
    }

    public boolean isBeforeScreeningDate(LocalDateTime date) {
        return this.whenScreened.isBefore(date);
    }
}