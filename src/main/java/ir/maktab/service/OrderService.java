package ir.maktab.service;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.exception.NotFoundOfferForOrder;
import ir.maktab.service.exception.NotFoundOrderException;

import java.util.List;

public interface OrderService {
    void saveNewOrder(OrderDto dto) throws NotFoundCustomerException;

    void deleteOrder(OrderDto dto);

    void updateOrder(OrderDto dto);

    List<OrderDto> fetchAllOrders();

    void selectOffer(OrderDto orderDto, OfferDto dto) throws NotFoundOfferForOrder;

    List<OrderDto> findOrdersBaseOnExpertSubServicesAndSituation(ExpertDto expertDto);

    OrderDto findById(Integer id) throws NotFoundOrderException;

    List<OrderDto> findByExpert(ExpertDto dto) throws NotFoundOrderException;
    List<OrderDto> findByCustomer(CustomerDto dto) throws NotFoundOrderException, NotFoundCustomerException;

    void endOfWork(Integer id) throws NotFoundOrderException;
}
