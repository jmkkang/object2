package com.object.objectstudy;

import java.time.LocalDateTime;

public class Period {
    public static Period of(LocalDateTime startDate, LocalDateTime endDate) {
        return new Period(startDate, endDate);
    }

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    
    public LocalDateTime getStartDate(){
        return startDate;
    }
}
