package mk.ukim.finki.emt.tourmanagement.service.domainServices.impl;

import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.service.domainServices.TourDomainService;
import mk.ukim.finki.emt.tourmanagement.service.forms.TourForm;
import org.springframework.stereotype.Service;

@Service
public class TourDomainServiceImpl implements TourDomainService {
    @Override
    public Tour toDomainObject(TourForm tourForm) {
        return new Tour(
                tourForm.getTourName(),
                tourForm.getTransportType(),
                tourForm.getGuideValueObject()
        );
    }
}
