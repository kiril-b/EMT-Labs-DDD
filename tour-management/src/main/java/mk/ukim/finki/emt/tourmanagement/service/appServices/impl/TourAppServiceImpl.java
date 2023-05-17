package mk.ukim.finki.emt.tourmanagement.service.appServices.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.tourmanagement.domain.exceptions.TourIdNotExistsException;
import mk.ukim.finki.emt.tourmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.tourmanagement.domain.model.ReservationId;
import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.domain.model.TourId;
import mk.ukim.finki.emt.tourmanagement.domain.repository.TourRepository;
import mk.ukim.finki.emt.tourmanagement.service.appServices.TourAppService;
import mk.ukim.finki.emt.tourmanagement.service.domainServices.ReservationDomainService;
import mk.ukim.finki.emt.tourmanagement.service.domainServices.TourDomainService;
import mk.ukim.finki.emt.tourmanagement.service.forms.ReservationForm;
import mk.ukim.finki.emt.tourmanagement.service.forms.TourForm;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TourAppServiceImpl implements TourAppService {

    private final TourRepository tourRepository;

    private final TourDomainService tourDomainService;

    private final ReservationDomainService reservationDomainService;

    @Override
    public TourId createTour(@Valid TourForm tourForm) {
        Tour newTour = tourDomainService.toDomainObject(tourForm);
        this.tourRepository.saveAndFlush(newTour);
        return newTour.getId();
    }

    @Override
    public List<Tour> findAll() {
        return this.tourRepository.findAll();
    }

    @Override
    public Optional<Tour> findById(TourId tourId) {
        return this.tourRepository.findById(tourId);
    }

    @Override
    public void addReservation(TourId tourId, ReservationForm reservationForm) {
        Tour tour = this.tourRepository.findById(tourId).orElseThrow(TourIdNotExistsException::new);
        Reservation reservation = this.reservationDomainService.toDomainObject(reservationForm);

        tour.addReservation(reservation);
        this.tourRepository.saveAndFlush(tour);
    }

    @Override
    public void removeReservation(TourId tourId, ReservationId reservationId) {
        Tour tour = this.tourRepository.findById(tourId).orElseThrow(TourIdNotExistsException::new);

        tour.removeReservation(reservationId);
        this.tourRepository.saveAndFlush(tour);
    }
}
