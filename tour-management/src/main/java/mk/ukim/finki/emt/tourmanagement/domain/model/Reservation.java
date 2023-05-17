package mk.ukim.finki.emt.tourmanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.Duration;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.LocationId;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.LocationValueObject;

@Entity
@Table(name = "reservations")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    private Duration duration;

    @AttributeOverride(name="id", column = @Column(name="location_id", nullable = false))
    private LocationId locationId;

    private Money price;

    public Reservation(@NonNull Duration duration, @NonNull LocationId locationId, @NonNull Money price) {
        super(ReservationId.randomId(ReservationId.class));
        this.duration = duration;
        this.price = price;
        this.locationId = locationId;

    }

    public Reservation() {

    }

}
