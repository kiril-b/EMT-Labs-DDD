package mk.ukim.finki.emt.tourmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.Duration;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.LocationValueObject;

import javax.validation.constraints.NotNull;

@Data
public class ReservationForm {

    @NotNull
    private LocationValueObject locationValueObject;

    @NotNull
    private Duration duration;
}
