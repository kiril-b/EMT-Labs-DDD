package mk.ukim.finki.emt.usermanagement.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.events.tours.TourCreated;
import mk.ukim.finki.emt.sharedkernel.events.tours.TourRemoved;
import mk.ukim.finki.emt.usermanagement.service.appServices.GuideAppService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@AllArgsConstructor
public class UserEventListener {


    private final GuideAppService guideAppService;

    @KafkaListener(topics = TopicHolder.TOPIC_TOUR_CREATED, groupId = "userManagement")
    public void consumeTourCreatedEvent(@RequestParam(required = false) String jsonMessage) {
        try {
            TourCreated event = DomainEvent.fromJson(jsonMessage, TourCreated.class);
            guideAppService.assignNewTourToGuide(event.getTourId(), event.getGuideId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_TOUR_REMOVED, groupId = "userManagement")
    public void consumeTourRemovedEvent(String jsonMessage) {
        try {
            TourRemoved event = DomainEvent.fromJson(jsonMessage, TourRemoved.class);
            guideAppService.removeTourFromGuide(event.getTourId(), event.getGuideId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
