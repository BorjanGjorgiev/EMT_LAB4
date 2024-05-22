package mk.ukim.finki.emt.kernel.domain.base;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId  implements Serializable
{
    private String Id;


    protected DomainObjectId(@NonNull String uuid) {
        this.Id = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    public DomainObjectId() {

    }


    /**
     * Creates a new, random instance of the given {@code idClass}.
     */
    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }

}
