package mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects;

import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;
import mk.ukim.finki.emt.kernel.domain.base.ValueObject;

import java.util.Currency;
import java.util.Random;

public class Movie implements ValueObject {

    private final MovieId movieId;
    private final String movieName;
    private final Money price;


    public Movie() {
        this.movieId=MovieId.randomId(MovieId.class);
        this.movieName="";
        this.price=Money.valueOf(Currency.getInstance("MKD"),0);

    }

    public Movie(MovieId movieId, String movieName, Money price) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.price = price;
    }
}
