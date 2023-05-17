package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class LocationId extends DomainObjectId {
    public LocationId(@NonNull String uuid) {
        super(uuid);
    }

    public LocationId() {
        super(LocationId.randomId(LocationId.class).getId());
    }

    public static LocationId of(String uuid) {
        return new LocationId(uuid);
    }
}
