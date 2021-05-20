package ir.maktab.service.mapper;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMappingImpl implements OrderMapping {
    @Override
    public Orders toOrder(OrderDto dto) {
        Orders order=new Orders();
        order.setId(dto.getId());
        order.setCustomer(dto.getCustomer());
        order.setDateOfOrderRegistration(dto.getDateOfOrderRegistration());
        order.setOffers(dto.getOffers());
        order.setJobDescription(dto.getJobDescription());
        order.setDateOfWork(dto.getDateOfWork());
        order.setProposedPrice(order.getProposedPrice());
        order.setSituation(dto.getSituation());
        order.setSubService(dto.getSubService());
        return order;
    }

    @Override
    public OrderDto toOrderDto(Orders order) {
        OrderDto dto=new OrderDto();
        dto.setId(order.getId());
        dto.setCustomer(order.getCustomer());
        dto.setDateOfOrderRegistration(order.getDateOfOrderRegistration());
        dto.setOffers(order.getOffers());
        dto.setJobDescription(order.getJobDescription());
        dto.setSubService(order.getSubService());
        dto.setProposedPrice(order.getProposedPrice());
        dto.setSituation(order.getSituation());
        dto.setDateOfWork(order.getDateOfWork());
        return dto;
    }
}
