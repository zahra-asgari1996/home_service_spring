package ir.maktab.data.repository;

import ir.maktab.data.domain.Offers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OffersRepositoryImpl implements OffersRepository{
    private final SessionFactory sessionFactory;

    public OffersRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewOffer(Offers offers) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(offers);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteOffer(Offers offers) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(offers);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void updateOffer(Offers offers) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(offers);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Offers> fetchAllOffers() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Offers.class);
        List<Offers> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
