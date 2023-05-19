package mk.ukim.finki.emt.tourmanagement.xport.client;

import mk.ukim.finki.emt.tourmanagement.domain.valueObjects.GuideValueObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class GuideClient {

    private final RestTemplate restTemplate;

    private final String serverUrl;

    public GuideClient(@Value("${app.guide-service.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();

        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<GuideValueObject> findAll() {
        try {
            return restTemplate.exchange(
                    uri().path("/api/guides").build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GuideValueObject>>() {}
            ).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
