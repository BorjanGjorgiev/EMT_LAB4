package mk.ukim.finki.emt.filmcatalog.services;

import mk.ukim.finki.emt.filmcatalog.domain.models.Movie;
import mk.ukim.finki.emt.filmcatalog.domain.models.MovieId;
import mk.ukim.finki.emt.filmcatalog.services.form.MovieForm;

import java.util.List;

public interface MovieService {
    Movie findById(MovieId id);
    Movie createProduct(MovieForm form);
    Movie orderItemCreated(MovieId productId, int quantity);
    Movie orderItemRemoved(MovieId productId, int quantity);
    List<Movie> getAll();

}
