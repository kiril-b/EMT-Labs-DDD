package mk.ukim.finki.emt.usermanagement.service.appServices.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.exceptions.GuideNotFoundException;
import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.domain.model.GuideId;
import mk.ukim.finki.emt.usermanagement.domain.model.TourId;
import mk.ukim.finki.emt.usermanagement.domain.model.TourIdHolder;
import mk.ukim.finki.emt.usermanagement.domain.repository.GuideRepository;
import mk.ukim.finki.emt.usermanagement.service.appServices.GuideAppService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GuideAppServiceImpl implements GuideAppService {

    private final GuideRepository guideRepository;

    @Override
    public Optional<Guide> findById(GuideId guideId) {
        return this.guideRepository.findById(guideId);
    }

    @Override
    public List<Guide> findAll() {
       return guideRepository.findAll();
    }

    @Override
    public void assignNewTourToGuide(String tourId, String guideIdString) {
        GuideId guideId = new GuideId(guideIdString);
        TourIdHolder tourIdHolder = new TourIdHolder(new TourId(tourId));
        Guide guide = this.guideRepository.findById(guideId).orElseThrow(GuideNotFoundException::new);
        guide.addTour(tourIdHolder);
        this.guideRepository.saveAndFlush(guide);
    }

    @Override
    public void removeTourFromGuide(String tourId, String guideIdString) {
        GuideId guideId = new GuideId(guideIdString);
        TourIdHolder tourIdHolder = new TourIdHolder(new TourId(tourId));
        Guide guide = this.guideRepository.findById(guideId).orElseThrow(GuideNotFoundException::new);
        guide.removeTour(tourIdHolder);
        this.guideRepository.saveAndFlush(guide);
    }
}
