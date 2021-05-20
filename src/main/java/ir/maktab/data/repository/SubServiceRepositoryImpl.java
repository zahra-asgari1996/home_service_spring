package ir.maktab.data.repository;

import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.SubService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubServiceRepositoryImpl implements SubServiceRepository{
    private final SessionFactory sessionFactory;

    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewSubService(SubService subService) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(subService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateSubService(SubService subService) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(subService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteSubService(SubService subService) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(subService);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public SubService getSubService(SubService subService) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        SubService service=session.get(SubService.class, subService.getId());
        session.getTransaction().commit();
        session.close();
        return service;
    }

    @Override
    public List<SubService> fetchAllSubServices() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SubService.class);
        List <SubService> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
