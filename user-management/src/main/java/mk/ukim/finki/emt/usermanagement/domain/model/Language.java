package mk.ukim.finki.emt.usermanagement.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.usermanagement.domain.enums.LanguageEnum;

@Entity
@Table(name = "languages")
@Getter
public class Language extends AbstractEntity<LanguageId> {

    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;

    public Language(LanguageEnum languageEnum) {
        super(LanguageId.randomId(LanguageId.class));
        this.languageEnum = languageEnum;
    }

    public Language() {
        super(LanguageId.randomId(LanguageId.class));
    }
}
