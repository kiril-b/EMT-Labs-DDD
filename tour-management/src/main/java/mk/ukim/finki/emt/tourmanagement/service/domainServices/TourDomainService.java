package mk.ukim.finki.emt.tourmanagement.service.domainServices;

import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.service.forms.TourForm;

public interface TourDomainService {
    Tour toDomainObject(TourForm tourForm);
}
