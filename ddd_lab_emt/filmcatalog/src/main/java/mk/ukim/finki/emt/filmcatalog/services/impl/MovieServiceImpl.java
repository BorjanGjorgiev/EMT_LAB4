package mk.ukim.finki.emt.filmcatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.filmcatalog.domain.models.Movie;
import mk.ukim.finki.emt.filmcatalog.domain.models.MovieId;
import mk.ukim.finki.emt.filmcatalog.domain.models.exceptions.MovieNotFoundException;
import mk.ukim.finki.emt.filmcatalog.domain.models.repository.MovieRepository;
import mk.ukim.finki.emt.filmcatalog.services.MovieService;
import mk.ukim.finki.emt.filmcatalog.services.form.MovieForm;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;


    @Override
    public Movie findById(MovieId id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    @Override
    public Movie createProduct(MovieForm form) {
        Movie m=Movie.build(form.getMovieName(),form.getPrice(),form.getSales());

        movieRepository.save(m);
        return m;

    }

    @Override
    public Movie orderItemCreated(MovieId productId, int quantity) {
        Movie m=movieRepository.findById(productId).orElseThrow(MovieNotFoundException::new);
        m.addSales(quantity);
    movieRepository.saveAndFlush(m);
    return m;
    }

    @Override
    public Movie orderItemRemoved(MovieId productId, int quantity) {
        Movie m=movieRepository.findById(productId).orElseThrow(MovieNotFoundException::new);
        m.removeSales(quantity);
        movieRepository.saveAndFlush(m);
        return m;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
