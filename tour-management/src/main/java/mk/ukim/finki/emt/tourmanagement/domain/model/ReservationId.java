package mk.ukim.finki.emt.tourmanagement.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class ReservationId extends DomainObjectId {
    public ReservationId(@NonNull String uuid) {
        super(uuid);
    }

    public ReservationId() {
        super(TourId.randomId(TourId.class).getId());
    }
}
