package mk.ukim.finki.emt.tourmanagement.service.domainServices.impl;

import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.tourmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.Duration;
import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.LocationValueObject;
import mk.ukim.finki.emt.tourmanagement.service.domainServices.ReservationDomainService;
import mk.ukim.finki.emt.tourmanagement.service.forms.ReservationForm;
import org.springframework.stereotype.Service;

@Service
public class ReservationDomainServiceImpl implements ReservationDomainService {
    @Override
    public Money calculateReservationPrice(ReservationForm reservationForm) {

        Currency currency = reservationForm.getLocationValueObject().getBasePrice().getCurrency();

        Double basePriceAmount = reservationForm.getLocationValueObject().getBasePrice().getAmount();
        Long reservationDays = reservationForm.getDuration().calculateDurationInDays();

        return new Money(currency, basePriceAmount * reservationDays);
    }

    @Override
    public Reservation toDomainObject(ReservationForm reservationForm) {
        Money reservationPrice = this.calculateReservationPrice(reservationForm);

        return new Reservation(
                reservationForm.getDuration(),
                reservationForm.getLocationValueObject().getLocationId(),
                reservationPrice
        );
    }
}
