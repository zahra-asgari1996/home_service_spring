package ir.maktab.service;

import ir.maktab.data.domain.Comments;
import ir.maktab.data.repository.CommentsRepository;
import ir.maktab.dto.CommentDto;
import ir.maktab.service.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentsRepository commentsRepository, CommentMapper commentMapper) {
        this.commentsRepository = commentsRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public void saveNewComment(CommentDto dto) {
        commentsRepository.save(commentMapper.toComment(dto));
    }

    @Override
    public void deleteComment(CommentDto dto) {
        commentsRepository.delete(commentMapper.toComment(dto));

    }

    @Override
    public void updateComment(CommentDto dto) {
        commentsRepository.save(commentMapper.toComment(dto));

    }

    @Override
    public List<CommentDto> fetchAllComments() {
        return
                commentsRepository.findAll()
                        .stream()
                        .map(commentMapper::toCommentDto).collect(Collectors.toList());
    }
}
