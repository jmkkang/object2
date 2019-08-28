package com.object.objectstudy;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    Reservation reserve(Customer customer, Theater theater, ScreeningPlace screeningPlace, Movie movie, Screening screening, AudienceCount count) {
        Reservation reservation = Reservation.NONE;
        Money price = movie.calculateFee(screening, count);

        System.out.println("total amount = " + price.getAmount());

        if (customer.hasAmount(price)) {
            reservation = ticketOffice.reserve(theater, screeningPlace, movie, screening, count);
            if (reservation != Reservation.NONE) customer.minusAmount(price);
        }
        return reservation;
    }
}
