package mk.ukim.finki.emt.tourmanagement.domain.exceptions;

import mk.ukim.finki.emt.tourmanagement.domain.model.Reservation;

public class ReservationCurrencyMismatchException extends RuntimeException {
    public ReservationCurrencyMismatchException(Reservation r1, Reservation r2) {
        super("Tour currency: " + r1.getPrice().getCurrency() + " does not match reservation currency: " + r2.getPrice().getCurrency());
    }
}
