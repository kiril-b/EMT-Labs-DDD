package mk.ukim.finki.emt.tourmanagement.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Embeddable
@Getter
public class Duration {

    private final LocalDateTime dateFrom;

    private final LocalDateTime dateTo;


    public Duration(@NonNull LocalDateTime from, @NonNull LocalDateTime to) {
        this.dateFrom = from;
        this.dateTo = to;
    }

    public Duration() {
        this.dateFrom = LocalDateTime.now();
        this.dateTo = LocalDateTime.now();
    }

    public Long calculateDurationInDays() {
        return ChronoUnit.DAYS.between(dateFrom, dateTo);
    }

    public static Duration of(LocalDateTime from, LocalDateTime to) {
        return new Duration(from, to);
    }
}
