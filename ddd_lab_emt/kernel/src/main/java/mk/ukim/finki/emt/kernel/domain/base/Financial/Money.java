package mk.ukim.finki.emt.kernel.domain.base.Financial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.kernel.domain.base.ValueObject;

import java.util.Currency;

@Embeddable
@Getter
public class Money implements ValueObject {
    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private double amount;

    protected Money() {
        this.amount = 0.0;
        this.currency = null;
    }

    public Money(@NonNull Currency currency, @NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, int amount) {
        return new Money(currency, amount);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }

        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }

        return new Money(currency, amount - money.amount);

    }

    public Money multiply(int m)
    {
        return new Money(currency,amount*m);
    }
}
