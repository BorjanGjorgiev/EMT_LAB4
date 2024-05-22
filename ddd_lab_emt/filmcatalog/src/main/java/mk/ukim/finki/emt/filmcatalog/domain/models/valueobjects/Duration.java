package mk.ukim.finki.emt.filmcatalog.domain.models.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.kernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Duration implements ValueObject {

    private final int duration;

    protected Duration()
    {
        this.duration=0;
    }

}
