package ir.maktab.data.repository;

import ir.maktab.data.domain.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final SessionFactory sessionFactory;

    public OrderRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveNewOrder(Orders orders) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orders);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteOrder(Orders orders) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(orders);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void updateOrder(Orders orders) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(orders);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Orders> fetchAllOrders() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Orders.class);
        List <Orders>list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
