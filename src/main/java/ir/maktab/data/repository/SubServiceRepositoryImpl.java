package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.SubService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubServiceRepositoryImpl implements SubServiceRepository {
    private final SessionFactory sessionFactory;

    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(subService);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(subService);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public SubService getSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SubService service = session.get(SubService.class, subService.getId());
        session.getTransaction().commit();
        session.close();
        return service;
    }

    @Override
    public List<SubService> fetchAllSubServices() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SubService.class);
        List<SubService> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void deleteExpertFromSubService(SubService service, Expert expert) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SubService subService = session.get(SubService.class, service.getId());
        subService.getExperts().remove(expert);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateExpertInSubService(SubService service, Expert newExpert,Expert oldExpert) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SubService subService = session.get(SubService.class, service.getId());
        subService.getExperts().remove(oldExpert);
        subService.getExperts().add(newExpert);
        session.getTransaction().commit();
        session.close();


    }

    @Override
    public void addExpertToSubService(SubService service, Expert expert) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SubService subService = session.get(SubService.class, service.getId());
        subService.getExperts().add(expert);
        session.getTransaction().commit();
        session.close();

    }
}
