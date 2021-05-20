package ir.maktab.data.repository;

import ir.maktab.data.domain.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    private final SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Users> fetchAllUsers() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        List <Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void changePassword(Users users) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(users);
        session.getTransaction().commit();
        session.close();

    }
}
