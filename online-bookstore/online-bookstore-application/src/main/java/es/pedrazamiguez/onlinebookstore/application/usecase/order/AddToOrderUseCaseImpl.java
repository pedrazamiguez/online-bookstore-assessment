package es.pedrazamiguez.onlinebookstore.application.usecase.order;

import es.pedrazamiguez.onlinebookstore.domain.model.Order;
import es.pedrazamiguez.onlinebookstore.domain.repository.OrderRepository;
import es.pedrazamiguez.onlinebookstore.domain.service.book.AvailableBookCopiesService;
import es.pedrazamiguez.onlinebookstore.domain.service.order.CurrentOrderService;
import es.pedrazamiguez.onlinebookstore.domain.service.order.FinalPriceService;
import es.pedrazamiguez.onlinebookstore.domain.service.security.SecurityService;
import es.pedrazamiguez.onlinebookstore.domain.usecase.order.AddToOrderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddToOrderUseCaseImpl implements AddToOrderUseCase {

  private final SecurityService securityService;

  private final AvailableBookCopiesService availableBookCopiesService;

  private final CurrentOrderService currentOrderService;

  private final OrderRepository orderRepository;

  private final FinalPriceService finalPriceService;

  @Override
  @Transactional
  public Order addToOrder(final Long bookId, final Long copies) {
    final String username = this.securityService.getCurrentUserName();
    this.availableBookCopiesService.assure(bookId, copies);

    log.info("Adding {} copies of bookId {} to order for user: {}", copies, bookId, username);
    final Order existingOrder = this.currentOrderService.getOrCreateOrder(username);
    final Order updatedOrder =
        this.orderRepository.saveOrderItem(existingOrder.getId(), bookId, copies);

    this.finalPriceService.calculate(updatedOrder);

    return updatedOrder;
  }
}
