package mk.ukim.finki.emt.usermanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class LanguageId extends DomainObjectId {
    public LanguageId(@NonNull String uuid) {
        super(uuid);
    }

    public LanguageId() {
        super(LanguageId.randomId(GuideId.class).getId());
    }
}
