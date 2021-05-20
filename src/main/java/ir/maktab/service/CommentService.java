package ir.maktab.service;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void saveNewComment(CommentDto dto);
    void deleteComment(CommentDto dto);
    void updateComment(CommentDto dto);
    List<Comments> fetchAllComments();

}
