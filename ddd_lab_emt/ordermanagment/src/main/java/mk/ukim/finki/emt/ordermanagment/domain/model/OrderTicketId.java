package mk.ukim.finki.emt.ordermanagment.domain.model;

import mk.ukim.finki.emt.kernel.domain.base.DomainObjectId;

public class OrderTicketId extends DomainObjectId
{
    private OrderTicketId() {
        super(OrderTicketId.randomId(OrderTicketId.class).getId());
    }

    public OrderTicketId(String uuid) {
        super(uuid);
    }

}
