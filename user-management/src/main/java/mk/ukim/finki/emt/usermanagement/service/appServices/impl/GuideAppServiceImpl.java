package mk.ukim.finki.emt.usermanagement.service.appServices.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.domain.model.GuideId;
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
}
