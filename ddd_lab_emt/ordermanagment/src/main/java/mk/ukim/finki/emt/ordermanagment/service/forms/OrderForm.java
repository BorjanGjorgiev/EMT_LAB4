package mk.ukim.finki.emt.ordermanagment.service.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Data
public class OrderForm implements Source {


    @NonNull
    private Currency currency;

    @Valid
    @NotEmpty

    private List<OrderItemForm> items=new ArrayList<>();

    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return null;
    }
}
