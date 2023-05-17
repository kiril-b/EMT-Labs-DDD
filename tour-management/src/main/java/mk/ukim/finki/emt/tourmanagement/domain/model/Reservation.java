package mk.ukim.finki.emt.tourmanagement.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.Duration;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.LocationValueObject;

@Entity
@Table(name = "reservations")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    private Duration duration;

    private LocationValueObject location;

    private Money price;

    public Reservation(@NonNull Duration duration, @NonNull LocationValueObject location, @NonNull Money price) {
        super(ReservationId.randomId(ReservationId.class));
        this.duration = duration;
        this.location = location;
        this.price = price;
    }

    public Reservation() {

    }

}
