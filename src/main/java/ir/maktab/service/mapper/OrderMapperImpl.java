package ir.maktab.service.mapper;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {
    private final CustomerMapper customerMapper;
    private final OfferMapper offerMapper;
    private final SubServiceMapper serviceMapper;

    public OrderMapperImpl(CustomerMapper customerMapper, OfferMapper offerMapper, SubServiceMapper serviceMapper) {
        this.customerMapper = customerMapper;
        this.offerMapper = offerMapper;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public Orders toOrder(OrderDto dto) {
        Orders order=new Orders();
        order.setId(dto.getId());
        order.setCustomer(customerMapper.toCustomer(dto.getCustomer()));
        order.setDateOfOrderRegistration(dto.getDateOfOrderRegistration());
        order.setOffers(dto.getOffers().stream().map(i->offerMapper.toOffer(i)).collect(Collectors.toList()));
        order.setJobDescription(dto.getJobDescription());
        order.setDateOfWork(dto.getDateOfWork());
        order.setProposedPrice(order.getProposedPrice());
        order.setSituation(dto.getSituation());
        order.setSubService(serviceMapper.convertToSubService(dto.getSubService()));
        return order;
    }

    @Override
    public OrderDto toOrderDto(Orders order) {
        OrderDto dto=new OrderDto();
        dto.setId(order.getId());
        dto.setCustomer(customerMapper.toCustomerDto(order.getCustomer()));
        dto.setDateOfOrderRegistration(order.getDateOfOrderRegistration());
        dto.setOffers(order.getOffers().stream().map(i->offerMapper.toOfferDto(i)).collect(Collectors.toList()));
        dto.setJobDescription(order.getJobDescription());
        dto.setSubService(serviceMapper.covertToSubServiceDto(order.getSubService()));
        dto.setProposedPrice(order.getProposedPrice());
        dto.setSituation(order.getSituation());
        dto.setDateOfWork(order.getDateOfWork());
        return dto;
    }
}
