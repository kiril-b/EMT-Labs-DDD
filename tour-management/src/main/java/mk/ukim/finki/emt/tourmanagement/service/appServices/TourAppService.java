package mk.ukim.finki.emt.tourmanagement.service.appServices;

import mk.ukim.finki.emt.tourmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.tourmanagement.domain.model.ReservationId;
import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.domain.model.TourId;
import mk.ukim.finki.emt.tourmanagement.service.forms.ReservationForm;
import mk.ukim.finki.emt.tourmanagement.service.forms.TourForm;

import java.util.List;
import java.util.Optional;

public interface TourAppService {

    TourId createTour(TourForm tourForm);

    void removeTour(TourId tourId);

    List<Tour> findAll();

    Optional<Tour> findById(TourId tourId);

    void addReservation(TourId tourId, ReservationForm reservationForm);

    void removeReservation(TourId tourId, ReservationId reservationId);

}
