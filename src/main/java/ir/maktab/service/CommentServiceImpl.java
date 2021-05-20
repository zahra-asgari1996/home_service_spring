package ir.maktab.service;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Override
    public void saveNewComment(CommentDto dto) {

    }

    @Override
    public void deleteComment(CommentDto dto) {

    }

    @Override
    public void updateComment(CommentDto dto) {

    }

    @Override
    public List<Comments> fetchAllComments() {
        return null;
    }
}
