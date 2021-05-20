package ir.maktab.service;

import ir.maktab.data.domain.Orders;
import ir.maktab.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public void saveNewOrder(OrderDto dto) {

    }

    @Override
    public void deleteOrder(OrderDto dto) {

    }

    @Override
    public void updateOrder(OrderDto dto) {

    }

    @Override
    public List<Orders> fetchAllOrders() {
        return null;
    }
}
