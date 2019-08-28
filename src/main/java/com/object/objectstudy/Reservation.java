package com.object.objectstudy;

public class Reservation {
    static final Reservation NONE = new Reservation(null, null, null, AudienceCount.of(0));
    final Theater theater;
    final Movie movie;
    final Screening screening;
    final AudienceCount count;

    Reservation(Theater theater, Movie movie, Screening screening, AudienceCount audienceCount) {
        this.theater = theater;
        this.movie = movie;
        this.screening = screening;
        this.count = audienceCount;
    }
}