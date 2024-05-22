package mk.ukim.finki.emt.filmcatalog.xport.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.filmcatalog.domain.models.Movie;
import mk.ukim.finki.emt.filmcatalog.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieResource {

    private final MovieService movieService;


    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }


}
