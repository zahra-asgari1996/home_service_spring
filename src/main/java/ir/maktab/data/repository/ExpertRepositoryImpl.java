//package ir.maktab.data.repository;
//
//import ir.maktab.data.domain.Customer;
//import ir.maktab.data.domain.Expert;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ExpertRepositoryImpl implements ExpertRepository{
//    private final SessionFactory sessionFactory;
//
//    public ExpertRepositoryImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void saveNewExpert(Expert expert) {
//        Session session= sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(expert);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void deleteExpert(Expert expert) {
//        Session session= sessionFactory.openSession();
//        session.beginTransaction();
//        session.delete(expert);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void updateExpert(Expert expert) {
//        Session session= sessionFactory.openSession();
//        session.beginTransaction();
//        session.update(expert);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public List<Expert> fetchAllExperts() {
//        Session session= sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Expert.class);
//        List<Expert> list = criteria.list();
//        session.getTransaction().commit();
//        session.close();
//        return list;
//    }
//}
