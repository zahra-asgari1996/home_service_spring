package ir.maktab.data.repository;

import ir.maktab.data.domain.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepositoryImpl implements  ServiceRepository{
    private final SessionFactory sessionFactory;

    public ServiceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewService(Service service) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(service);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Service getService(Service service) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Service service1=session.get(Service.class,service.getId());
        session.getTransaction().commit();
        session.close();
        return service1;
    }

    @Override
    public void deleteService(Service service) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(service);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateService(Service service) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(service);
        session.getTransaction().commit();
        session.close();
    }
}
