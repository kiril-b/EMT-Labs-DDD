package mk.ukim.finki.emt.tourmanagement.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.enums.TransportType;
import mk.ukim.finki.emt.tourmanagement.domain.exceptions.ReservationCurrencyMismatchException;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.GuideValueObject;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tours")
public class Tour extends AbstractEntity<TourId> {

    private String tourName;

    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    private GuideValueObject guide;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    public Tour(String tourName, TransportType transportType, GuideValueObject guide) {
        super(TourId.randomId(TourId.class));
        this.tourName = tourName;
        this.transportType = transportType;
        this.guide = guide;
    }

    public Tour() {

    }

    public void addReservation(@NonNull Reservation reservation) {
        Objects.requireNonNull(reservation, "Reservation must not be null!");
        if (this.reservationCurrencyMismatch(reservation)) {
            throw new ReservationCurrencyMismatchException(this.reservations.get(0), reservation);
        }
        this.reservations.add(reservation);
    }

    public void removeReservation(@NonNull ReservationId reservationId) {
        Objects.requireNonNull(reservationId, "Reservation must not be null!");
        this.reservations.removeIf(r -> r.getId().equals(reservationId));
    }

    private boolean reservationCurrencyMismatch(Reservation reservation) {
        if (this.reservations.isEmpty()) {
            return false;
        }
        return !getTourCurrency().equals(reservation.getPrice().getCurrency());
    }

    private Currency getTourCurrency() {
        if (this.reservations.isEmpty()) {
            throw new RuntimeException("Tour has no reservations");
        }
        return this.reservations.get(0).getPrice().getCurrency();
    }


    public Money totalPrice() {
        if (this.reservations.isEmpty()) {
            return new Money(Currency.MKD, 0);
        }
        Money moneyInitial = new Money(this.getTourCurrency(), 0);
        return this.reservations.stream()
                .map(Reservation::getPrice)
                .reduce(moneyInitial, Money::add);
    }

}
