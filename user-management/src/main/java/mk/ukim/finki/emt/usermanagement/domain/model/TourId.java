package mk.ukim.finki.emt.usermanagement.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class TourId extends DomainObjectId {
    public TourId(@NonNull String uuid) {
        super(uuid);
    }

    public TourId() {
        super(TourId.randomId(TourId.class).getId());
    }
}