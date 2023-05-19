package mk.ukim.finki.emt.usermanagement.service.appServices;

import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.domain.model.GuideId;

import java.util.List;
import java.util.Optional;

public interface GuideAppService {

    Optional<Guide> findById(GuideId guideId);

    List<Guide> findAll();

}
