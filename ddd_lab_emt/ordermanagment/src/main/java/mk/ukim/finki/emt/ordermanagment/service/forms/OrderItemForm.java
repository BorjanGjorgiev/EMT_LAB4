package mk.ukim.finki.emt.ordermanagment.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects.Movie;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class OrderItemForm {
    @NotNull
    private Movie movie;

    @Min(1)
    private int quantity=1;
}
