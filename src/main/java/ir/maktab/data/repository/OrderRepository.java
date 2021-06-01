package ir.maktab.data.repository;

import ir.maktab.data.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
//    void saveNewOrder(Orders orders);
//    void deleteOrder(Orders orders);
//    void updateOrder(Orders orders);
//    List<Orders> fetchAllOrders();
}
