package mk.ukim.finki.emt.ordermanagment.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderTicketId;
import mk.ukim.finki.emt.ordermanagment.domain.model.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.emt.ordermanagment.domain.model.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagment.service.OrderService;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

   private final OrderRepository orderRepository;

   private final Validator validator;


    @Override
    public OrderId placeOrder(OrderForm orderForm) throws ConstraintViolationException {
         Objects.requireNonNull(orderForm,"order must not be null");
         var constraintVialations=validator.validate(orderForm);

         if(constraintVialations.size()>0)
         {
             throw new ConstraintViolationException("The order form is not valid"),constraintVialations;

         }

         var newOrder=orderRepository.saveAndFlush(toDomainObject(orderForm));

    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        order.addMovie(orderItemForm.getMovie(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);

    }

    @Override
    public void deleteItem(OrderId orderId, OrderTicketId orderTicketId) throws OrderItemIdNotExistException, OrderNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        order.removeItem(orderTicketId);
        orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm) {
        var order = new Order(Instant.now(),orderForm.getCurrency());
        orderForm.getItems().forEach(item->order.addMovie(item.getMovie(),item.getQuantity()));
        return order;
    }



}
