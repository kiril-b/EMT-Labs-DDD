package mk.ukim.finki.emt.usermanagement.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.geographical.Address;
import mk.ukim.finki.emt.usermanagement.domain.enums.LanguageEnum;
import mk.ukim.finki.emt.usermanagement.domain.model.Guide;
import mk.ukim.finki.emt.usermanagement.domain.model.Language;
import mk.ukim.finki.emt.usermanagement.domain.repository.GuideRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final GuideRepository guideRepository;

    @PostConstruct
    public void init() {
        if (guideRepository.findAll().isEmpty()) {
            Guide guide1 = Guide.build("Peter", "Norvig", "123456789", "pn@gmail.com", new Address("A", "B", "C", "22D"));
            Guide guide2 = Guide.build("Stuart", "Russell", "123456789", "sr@gmail.com", new Address("M", "N", "P", "22D"));

            Language fr = new Language(LanguageEnum.FR);
            Language eng = new Language(LanguageEnum.ENG);

            guide1.addLanguage(fr);
            guide1.addLanguage(eng);

            guide2.addLanguage(eng);

            guideRepository.saveAndFlush(guide1);
            guideRepository.saveAndFlush(guide2);
        }
    }
}
