package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class GuideId extends DomainObjectId {
    public GuideId(@NonNull String uuid) {
        super(uuid);
    }

    public GuideId() {
        super(GuideId.randomId(GuideId.class).getId());
    }

    public static GuideId of(String uuid) {
        return new GuideId(uuid);
    }
}
