package com.object.objectstudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Theater {

    private final Set<TicketOffice> ticketOffices = new HashSet<>();
    private final Set<Movie> movies = new HashSet<>();
    private Money amount;
    private Map<String, ScreeningPlace> screeningPlaces = new HashMap<>();

    public Theater(Money amount) {
        this.amount = amount;
    }

    public boolean addMovie(Movie movie) {
        if (movies.contains(movie)) return false;
        movies.add(movie);
        return true;
    }

    public boolean contractTicketOffice(TicketOffice ticketOffice, Double rate) {
        if (!ticketOffice.contract(this, rate)) return false;
        return ticketOffices.add(ticketOffice);
    }

    public boolean cancelTicketOffice(TicketOffice ticketOffice) {
        if (!ticketOffices.contains(ticketOffice) || !ticketOffice.cancel(this)) return false;
        return ticketOffices.remove(ticketOffice);
    }

    public boolean enter(Customer customer, ScreeningPlace screeningPlace, AudienceCount count) {
        Reservation reservation = customer.reservation;
        return reservation != Reservation.NONE && reservation.theater == this && screeningPlace.isValidScreening(reservation.movie, reservation.screening) && reservation.count == count;
    }

    Reservation reserve(Movie movie, ScreeningPlace screeningPlace, Screening screening, AudienceCount count) {
        if (!screeningPlace.isValidScreening(movie, screening)
                || !screeningPlace.hasSeat(screening, count))
            return Reservation.NONE;
        screeningPlace.reserveSeat(screening, count);
        return new Reservation(this, movie, screening, count);
    }

    void plusAmount(Money amount) {
        this.amount = this.amount.plus(amount);
    }

    public boolean setScreeningPlace(String name, ScreeningPlace screeningPlace) {
        if (this.screeningPlaces.containsKey(name)) return false;
        this.screeningPlaces.put(name, screeningPlace);
        return true;
    }

    public ScreeningPlace getScreeningPlace(String name) {
        return this.screeningPlaces.get(name);
    }

    public boolean hasScreeningPlace(ScreeningPlace screeningPlace) {
        return this.screeningPlaces.containsValue(screeningPlace);
    }

}