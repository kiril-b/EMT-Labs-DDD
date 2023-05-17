package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Getter
public class LocationValueObject implements ValueObject {

    private final LocationId locationId;

    private final Money basePrice;

    @JsonCreator
    public LocationValueObject(@JsonProperty("locationId") LocationId locationId, @JsonProperty("basePrice") Money basePrice) {
        this.locationId = locationId;
        this.basePrice = basePrice;
    }
}
