package mk.ukim.finki.emt.usermanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;

@Entity
@Table(name = "tour_ids")
@Getter
public class TourIdHolder extends AbstractEntity<TourId> {

    @JsonCreator
    public TourIdHolder(TourId tourId) {
        super(tourId);
    }

    public TourIdHolder() {
        super(TourId.randomId(TourId.class));
    }
}
