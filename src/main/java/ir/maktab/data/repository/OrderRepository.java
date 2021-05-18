package ir.maktab.data.repository;

import ir.maktab.data.domain.Orders;

import java.util.List;

public interface OrderRepository {
    void saveNewOrder(Orders orders);
    void deleteOrder(Orders orders);
    void updateOrder(Orders orders);
    List<Orders> fetchAllOrders();
}
