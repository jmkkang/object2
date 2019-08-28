package com.object.objectstudy;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

@SpringBootApplication
public class ObjectStudyApplication {

    public static void main(String[] args) {
        Theater theater = new Theater(Money.of(100.0));

        theater.setScreeningPlace("#1", new ScreeningPlace());
        theater.setScreeningPlace("#2", new ScreeningPlace());
        theater.setScreeningPlace("#3", new ScreeningPlace());

        Movie movie = new Movie<AmountDiscount>(
                "spiderman",
                Duration.ofMinutes(120L),
                Money.of(5000.0),
                new SequenceAmountDiscount(Money.of(1000.0), 1),
                new CountAmountDiscount(Money.of(1200.0), AudienceCount.of(3)),
                new PeriodAmountDiscount(Money.of(900.0),
                        Period.of(LocalDateTime.of(2019, 8, 1, 0, 0, 0),
                                LocalDateTime.of(2019, 8, 28, 23, 59, 59)))
        );

        theater.addMovie(movie);

        ScreeningPlace screeningPlace = theater.getScreeningPlace("#1");
        for (int day = 7; day < 8; day++) {
            for (int hour = 10, seq = 1; hour < 24; hour += 3, seq++) {

                screeningPlace.addScreening(
                        new Screening(seq, LocalDateTime.of(2019, 8, day, hour, 00, 00)),
                        movie,
                        1.0
                );
            }
        }

        TicketOffice ticketOffice = new TicketOffice(Money.of(100.0));
        theater.contractTicketOffice(ticketOffice, 10.0);
        TicketSeller seller = new TicketSeller();
        seller.setTicketOffice(ticketOffice);

        Customer customer = new Customer(Money.of(30000.0));

        for (Screening screening : screeningPlace.getScreening(movie)) {
            customer.reserve(seller, theater, screeningPlace, movie, screening, AudienceCount.of(3));
            boolean isOk = theater.enter(customer, screeningPlace, AudienceCount.of(3));
            System.out.println(isOk);
            break;
        }
    }
}