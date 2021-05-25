package ir.maktab.data.repository;

import ir.maktab.data.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    void saveNewComment(Comments comments);
    void deleteComment(Comments comments);
    void updateComment(Comments comments);
    List<Comments> fetchAllComments();
}
