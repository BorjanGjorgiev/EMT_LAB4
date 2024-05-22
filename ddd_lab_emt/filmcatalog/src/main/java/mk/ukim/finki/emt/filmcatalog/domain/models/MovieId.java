package mk.ukim.finki.emt.filmcatalog.domain.models;

import io.micrometer.common.lang.NonNull;
import mk.ukim.finki.emt.kernel.domain.base.DomainObjectId;

public class MovieId  extends DomainObjectId
{
    private MovieId() {
        super(randomId(MovieId.class).getId());
    }

    public MovieId(@NonNull String uuid) {
        super(uuid);
    }

    public static MovieId of(String uuid) {

        return new MovieId(uuid);
    }

}
