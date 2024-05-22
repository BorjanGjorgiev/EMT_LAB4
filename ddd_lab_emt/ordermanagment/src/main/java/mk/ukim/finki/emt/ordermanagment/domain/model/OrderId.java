package mk.ukim.finki.emt.ordermanagment.domain.model;

import io.micrometer.common.lang.NonNull;
import mk.ukim.finki.emt.kernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId
{
    private OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NonNull String uuid) {
        super(uuid);
    }

}
