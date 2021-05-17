package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Manager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ManagerRepositoryImpl implements ManagerRepository{
    private final SessionFactory sessionFactory;

    public ManagerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewManager(Manager manager) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(manager);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteManager(Manager manager) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(manager);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateManager(Manager manager) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(manager);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Manager> fetchAllManagers() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Manager.class);
        List<Manager> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
