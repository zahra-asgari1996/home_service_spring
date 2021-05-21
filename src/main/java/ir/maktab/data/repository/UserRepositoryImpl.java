package ir.maktab.data.repository;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.SearchCustomerDto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public List<Users> findByProperty(SearchCustomerDto dto) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        if (dto.getName()!=null){
            criteria.add(Restrictions.eq("name",dto.getName()));
        }if (dto.getLastName()!=null){
            criteria.add(Restrictions.eq("lastName",dto.getLastName()));
        }if (dto.getEmail()!=null){
            criteria.add(Restrictions.eq("email",dto.getEmail()));
        }if (dto.getRole()!=null){
            criteria.add(Restrictions.eq("role",dto.getRole()));
        }
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
