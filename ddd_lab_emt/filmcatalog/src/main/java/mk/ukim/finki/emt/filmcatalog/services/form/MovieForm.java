package mk.ukim.finki.emt.filmcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.kernel.domain.base.Financial.Money;


@Data

public class MovieForm {

    private String movieName;
    private Money price;

    private int sales;

}
