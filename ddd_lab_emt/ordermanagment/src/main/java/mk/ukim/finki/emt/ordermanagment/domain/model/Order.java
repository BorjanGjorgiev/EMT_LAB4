package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.ukim.finki.emt.kernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;
import mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import mk.ukim.finki.emt.*;
import java.time.Instant;
import java.util.Currency;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order extends AbstractEntity<OrderId>
{
    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Money total;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<OrderTicket> orderMovieList;

    public Order()
    {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now,@NonNull Currency currency)
    {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn=now;
        this.currency=currency;
    }



    public Money total()
    {
        return orderMovieList.stream().map(OrderTicket::subtotal).reduce(new Money(currency,0),Money::add);
    }

    public OrderTicket addMovie(@NonNull Movie movie, int qty )
    {

        Objects.requireNonNull(movie,"movie must not be null");

        var item =new OrderTicket(movie.getId(),movie.getPrice(),qty);
        orderMovieList.add(item);
        return item;
    }
    public void removeItem(@NonNull OrderTicketId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderMovieList.removeIf(v->v.getId().equals(orderItemId));
    }



}
