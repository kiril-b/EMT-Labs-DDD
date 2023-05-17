package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;

@Getter
public class GuideValueObject implements ValueObject {

    private final GuideId guideId;

    private final String name;

    @JsonCreator
    public GuideValueObject(@JsonProperty("id") GuideId guideId, @JsonProperty("name") String name) {
        this.guideId = guideId;
        this.name = name;
    }
}
