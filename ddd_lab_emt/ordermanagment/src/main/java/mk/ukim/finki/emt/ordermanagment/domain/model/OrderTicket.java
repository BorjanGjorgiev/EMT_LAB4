package mk.ukim.finki.emt.ordermanagment.domain.model;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NonNull;
import mk.ukim.finki.emt.kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.kernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;
import mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects.MovieId;

@Entity
@Table(name="order_ticket")
public class OrderTicket extends AbstractEntity<OrderTicketId> {


private Money ticketPrice;

@Column(name = "qty",nullable = false)
private Integer quantity;


@AttributeOverride(name="id",column = @Column(name = "movie_id",nullable = false))
private MovieId movieId;


public OrderTicket(@NonNull MovieId movieId,@NonNull Money ticketPrice,int quantity)
{

    super(DomainObjectId.randomId(OrderTicketId.class));
    this.movieId=movieId;
    this.ticketPrice=ticketPrice;
    this.quantity=quantity;
}

    public OrderTicket() {

    }

    public Money subtotal()
{
    return ticketPrice.multiply(quantity);
}


}
