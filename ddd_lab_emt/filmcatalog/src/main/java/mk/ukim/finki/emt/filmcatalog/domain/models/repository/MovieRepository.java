package mk.ukim.finki.emt.filmcatalog.domain.models.repository;

import mk.ukim.finki.emt.filmcatalog.domain.models.Movie;
import mk.ukim.finki.emt.filmcatalog.domain.models.MovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, MovieId> {
}
