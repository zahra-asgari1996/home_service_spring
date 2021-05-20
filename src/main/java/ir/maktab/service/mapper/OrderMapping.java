package ir.maktab.service.mapper;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.OrderDto;

public interface OrderMapping {
    Orders toOrder(OrderDto dto);
    OrderDto toOrderDto(Orders order);
}
