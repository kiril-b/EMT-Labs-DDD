package mk.ukim.finki.emt.usermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.service.appServices.GuideAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@AllArgsConstructor
public class GuideResource {

    private final GuideAppService guideAppService;

    @GetMapping
    public List<Guide> findAll() {
        return guideAppService.findAll();
    }

}
