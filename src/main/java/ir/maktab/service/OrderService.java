package ir.maktab.service;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundOfferForOrder;

import java.util.List;

public interface OrderService {
    void saveNewOrder(OrderDto dto);
    void deleteOrder(OrderDto dto);
    void updateOrder(OrderDto dto);
    List<OrderDto> fetchAllOrders();
    void selectOffer(OrderDto orderDto,OfferDto dto) throws NotFoundOfferForOrder;
}
