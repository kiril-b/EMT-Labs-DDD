package mk.ukim.finki.emt.tourmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.tourmanagement.domain.enums.TransportType;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.GuideValueObject;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TourForm {
    @NotNull
    private String tourName;

    @Valid
    @NotEmpty
    private GuideValueObject guideValueObject;

    @NotNull
    private TransportType transportType;

}
