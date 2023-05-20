package mk.ukim.finki.emt.usermanagement.service.appServices;

import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.domain.model.GuideId;
import mk.ukim.finki.emt.usermanagement.domain.model.TourIdHolder;

import java.util.List;
import java.util.Optional;

public interface GuideAppService {

    Optional<Guide> findById(GuideId guideId);

    List<Guide> findAll();

    void assignNewTourToGuide(String tourId, String guideId);

    void removeTourFromGuide(String tourId, String guideId);

}
