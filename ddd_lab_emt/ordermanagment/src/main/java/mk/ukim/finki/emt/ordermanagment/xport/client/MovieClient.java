package mk.ukim.finki.emt.ordermanagment.xport.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects.Movie;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service

public class MovieClient
{
    private final RestTemplate restTemplate;

    private final String serverUrl;


    public MovieClient(@Value("${app.filmcatalog.url") String serverUrl)
    {
        this.serverUrl=serverUrl;
        this.restTemplate=new RestTemplate();
        var requestFactory=new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri()
    {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Movie> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/movie").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Movie>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }



}
