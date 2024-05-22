package mk.ukim.finki.emt.ordermanagment.service;

import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderTicket;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderTicketId;
import mk.ukim.finki.emt.ordermanagment.domain.model.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface OrderService {


    OrderId placeOrder(OrderForm orderForm) throws ConstraintViolationException;

    List<Order> findAll();


    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderNotFoundException;


        void deleteItem(OrderId orderId, OrderTicketId orderTicketId) throws OrderItemIdNotExistException,OrderNotFoundException;
}
