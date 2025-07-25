package es.pedrazamiguez.onlinebookstore.domain.repository;

import es.pedrazamiguez.onlinebookstore.domain.enums.PaymentMethod;
import es.pedrazamiguez.onlinebookstore.domain.model.Order;
import java.util.Optional;

public interface OrderRepository {

  Optional<Order> findCreatedOrderForCustomer(String username);

  Order createNewOrder(String username);

  Order saveOrderItem(Long orderId, Long bookId, Long quantity);

  Order deleteOrderItem(Long orderId, Long bookId, Long quantity);

  void deleteOrderItems(Long orderId);

  Order purchaseOrder(Order order, PaymentMethod paymentMethod, String shippingAddress);
}
