package mk.ukim.finki.emt.usermanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class GuideId extends DomainObjectId {

    public GuideId(@NonNull String uuid) {
        super(uuid);
    }

    public GuideId() {
        super(GuideId.randomId(GuideId.class).getId());
    }
}
