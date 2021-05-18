package ir.maktab.data.repository;

import ir.maktab.data.domain.Comments;

import java.util.List;

public interface CommentsRepository {
    void saveNewComment(Comments comments);
    void deleteComment(Comments comments);
    void updateComment(Comments comments);
    List<Comments> fetchAllComments();
}
