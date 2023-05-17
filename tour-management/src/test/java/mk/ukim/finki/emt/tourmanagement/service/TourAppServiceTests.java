package mk.ukim.finki.emt.tourmanagement.service;

import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.enums.TransportType;
import mk.ukim.finki.emt.tourmanagement.domain.exceptions.TourIdNotExistsException;
import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.domain.model.TourId;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.*;
import mk.ukim.finki.emt.tourmanagement.service.appServices.TourAppService;
import mk.ukim.finki.emt.tourmanagement.service.forms.ReservationForm;
import mk.ukim.finki.emt.tourmanagement.service.forms.TourForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TourAppServiceTests {

    @Autowired
    private TourAppService tourAppService;

    @Test
    public void testAddTour_thenAddReservations() {
        TourForm tourForm = new TourForm();
        tourForm.setTourName("Tour France");
        tourForm.setGuideValueObject(new GuideValueObject(GuideId.randomId(GuideId.class), "Peter"));
        tourForm.setTransportType(TransportType.AEROPLANE);

        ReservationForm reservationForm1 = new ReservationForm();
        reservationForm1.setLocationValueObject(
                new LocationValueObject(LocationId.randomId(LocationId.class),
                        new Money(Currency.EUR, 200))
        );
        reservationForm1.setDuration(new Duration(LocalDateTime.of(2021, 5, 15, 0, 0),
                LocalDateTime.of(2021, 5, 20, 0, 0)));

        ReservationForm reservationForm2 = new ReservationForm();
        reservationForm2.setLocationValueObject(
                new LocationValueObject(LocationId.randomId(LocationId.class),
                        new Money(Currency.EUR, 300))
        );
        reservationForm2.setDuration(new Duration(LocalDateTime.of(2021, 5, 15, 0, 0),
                LocalDateTime.of(2021, 5, 20, 0, 0)));

        TourId newTourId = tourAppService.createTour(tourForm);
        tourAppService.addReservation(newTourId, reservationForm1);
        tourAppService.addReservation(newTourId, reservationForm2);

        Tour tour = tourAppService.findById(newTourId).orElseThrow(TourIdNotExistsException::new);
        Assertions.assertEquals(tour.totalPrice(), Money.valueOf(Currency.EUR, 300 * 5 + 200 * 5));
    }
}
