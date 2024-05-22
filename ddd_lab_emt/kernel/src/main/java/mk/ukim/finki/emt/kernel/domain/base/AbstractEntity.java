package mk.ukim.finki.emt.kernel.domain.base;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.util.ProxyUtils;

import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId>
{
@EmbeddedId
    private ID Id;


    protected AbstractEntity() {
    }

    /**
     * Copy constructor
     *
     * @param source the entity to copy from.
     */
    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        Objects.requireNonNull(source, "source must not be null");
        this.Id = source.Id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.Id = Objects.requireNonNull(id, "id must not be null");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        var other = (AbstractEntity<?>) obj;
        return Id != null && Id.equals(other.Id);
    }

    @Override
    public int hashCode() {
        return Id == null ? super.hashCode() : Id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), Id);
    }

}
