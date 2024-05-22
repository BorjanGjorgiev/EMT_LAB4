package mk.ukim.finki.emt.filmcatalog.domain.models;


import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.filmcatalog.domain.models.valueobjects.Duration;
import mk.ukim.finki.emt.kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;

@Entity
@Table(name="movie")
@Getter
public class Movie extends AbstractEntity<MovieId>
{
    private int sales;
private String MovieName;
private mk.ukim.finki.emt.filmcatalog.domain.models.valueobjects.Duration duration;
private String Genre;

@AttributeOverrides({@AttributeOverride(name="amount",column = @Column(name = "price_amount")),
@AttributeOverride(name = "currency",column = @Column(name = "price_currency"))})
private Money price;

private Movie()
{
    super(MovieId.randomId(MovieId.class));
}

public static Movie build(String movieName,Money price,int sales)
{
    Movie m =new Movie();
    m.price=price;
    m.sales=sales;
    m.MovieName=movieName;
    return m;

}

public void addSales(int qty)
{
    this.sales=this.sales-qty;

}
public void removeSales(int qty)
{
    this.sales-=qty;
}
}
