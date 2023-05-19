package mk.ukim.finki.emt.usermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.geographical.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "guides")
@Getter
public class Guide extends AbstractEntity<GuideId> {

    private String name;

    private String surname;

    private String phone;

    private String email;

    private Address address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Language> languages;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TourIdHolder> tours;

    public Guide() {
        super(GuideId.randomId(GuideId.class));
    }

    public static Guide build(String name, String surname, String phone, String email, Address address) {
        Guide newGuide = new Guide();
        newGuide.name = name;
        newGuide.surname = surname;
        newGuide.phone = phone;
        newGuide.email = email;
        newGuide.address = address;
        newGuide.languages = new ArrayList<>();
        newGuide.tours = new ArrayList<>();
        return newGuide;
    }

    public void addLanguage(Language language) {
        Objects.requireNonNull(language, "Language must not be null!");
        this.languages.add(language);
    }

    public void removeLanguage(LanguageId languageId) {
        Objects.requireNonNull(languageId, "Language must not be null!");
        this.languages.removeIf(l -> l.getId().equals(languageId));
    }

    public void addTour(TourIdHolder tourIdHolder) {
        Objects.requireNonNull(tourIdHolder, "Tour must not be null!");
        this.tours.add(tourIdHolder);
    }

    public void removeTour(TourId tourId) {
        Objects.requireNonNull(tourId, "TourId must not be null!");
        this.tours.removeIf(t -> t.getTourId().equals(tourId));
    }

}
