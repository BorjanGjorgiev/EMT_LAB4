package mk.ukim.finki.emt.kernel.domain.base.infra;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
