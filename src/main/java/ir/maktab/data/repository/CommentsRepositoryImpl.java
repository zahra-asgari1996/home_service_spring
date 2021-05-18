package ir.maktab.data.repository;

import ir.maktab.data.domain.Comments;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository{
    private final SessionFactory sessionFactory;



    public CommentsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveNewComment(Comments comments) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(comments);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteComment(Comments comments) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(comments);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateComment(Comments comments) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.update(comments);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Comments> fetchAllComments() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comments.class);
        List<Comments> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
