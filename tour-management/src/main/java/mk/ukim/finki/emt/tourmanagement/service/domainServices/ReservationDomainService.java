package mk.ukim.finki.emt.tourmanagement.service.domainServices;

import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.tourmanagement.service.forms.ReservationForm;

public interface ReservationDomainService {

    Money calculateReservationPrice(ReservationForm reservationForm);

    Reservation toDomainObject(ReservationForm reservationForm);

}
