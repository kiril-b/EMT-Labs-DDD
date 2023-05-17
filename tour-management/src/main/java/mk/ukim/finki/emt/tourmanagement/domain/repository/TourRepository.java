package mk.ukim.finki.emt.tourmanagement.domain.repository;

import mk.ukim.finki.emt.tourmanagement.domain.model.Tour;
import mk.ukim.finki.emt.tourmanagement.domain.model.TourId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, TourId> {
}
