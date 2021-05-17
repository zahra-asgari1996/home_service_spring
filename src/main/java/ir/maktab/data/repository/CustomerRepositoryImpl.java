package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewCustomer(Customer customer) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Customer> fetchAllCustomers() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
