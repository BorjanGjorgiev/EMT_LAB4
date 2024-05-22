package mk.ukim.finki.emt.filmcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.filmcatalog.domain.models.Movie;
import mk.ukim.finki.emt.filmcatalog.domain.models.repository.MovieRepository;
import mk.ukim.finki.emt.filmcatalog.domain.models.valueobjects.Currency;
import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer
{

    private final MovieRepository productRepository;

    @PostConstruct
    public void initData() {
        Movie p1 = Movie.build("Pizza", Money.valueOf(Currency.MKD,500), 10);
        Movie p2 = Movie.build("Ice Cream", Money.valueOf(Currency.MKD,100), 5);
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }

    }
