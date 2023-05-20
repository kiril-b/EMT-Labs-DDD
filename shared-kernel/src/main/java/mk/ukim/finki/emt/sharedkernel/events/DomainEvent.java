package mk.ukim.finki.emt.sharedkernel.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
public class DomainEvent {
    private String topic;
//    private Instant occurredOn;
//    private LocalDateTime occurredOn;

    public DomainEvent(String topic) {
//        this.occurredOn = LocalDateTime.now();
        this.topic = topic;
    }

    public String toJson() {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        String output = null;
        try {
            output = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output;
    }

    public String topic() {
        return topic;
    }

    public static <E extends DomainEvent> E fromJson(String json, Class<E> eventClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, eventClass);
    }

}
