package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
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

    public LocationValueObject() {
        this.locationId = LocationId.randomId(LocationId.class);
        this.basePrice = new Money(Currency.EUR, 0);
    }
}
