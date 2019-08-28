package com.object.objectstudy;

import java.util.*;

public class ScreeningPlace {
    public static final Set<Screening> EMPTY = new HashSet<>();

    private final Map<Screening, Movie> screenings = new HashMap<>();
    private final Map<Screening, Double> seats = new HashMap<>();

    public boolean addScreening(Screening screening, Movie movie, Double seat) {
        if (screenings.containsKey(screening)) {
            return false;
        }
        screenings.put(screening, movie);
        seats.put(screening, seat);
        return true;
    }

    public Set<Screening> getScreening(Movie movie) {

        if (!screenings.containsValue(movie)) {
            return EMPTY;
        }

        Set<Screening> screeningSet = new HashSet<>();

        Set entries = screenings.entrySet();
        Iterator entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {

            Map.Entry mapping = (Map.Entry) entriesIterator.next();

            if (mapping.getValue() == movie) {
                screeningSet.add((Screening) mapping.getKey());
            }
        }

        return screeningSet;
    }

    boolean isValidScreening(Movie movie, Screening screening) {
        return this.getScreening(movie) == screening;
    }

    boolean hasSeat(Screening screening, AudienceCount count) {
        if (!this.seats.containsKey(screening)) return false;

        return this.seats.get(screening) >= count.getNumber();
    }

    void reserveSeat(Screening screening, AudienceCount count) {
        if (hasSeat(screening, count)) {
            Double seat = this.seats.get(screening);
            seat -= count.getNumber();
            this.seats.put(screening, seat);
        } else {
            throw new RuntimeException("no seat");
        }

    }
}
