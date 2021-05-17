package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ExpertRepositoryImpl implements ExpertRepository{
    private final SessionFactory sessionFactory;

    public ExpertRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewExpert(Expert expert) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(expert);
        session.getTransaction().commit();
        session.close();
    }
}
