package ir.maktab.service;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundOrderException;

import java.util.List;

public interface CommentService {
    void saveNewComment(CommentDto dto) throws NotFoundOrderException;

    void deleteComment(CommentDto dto);

    void updateComment(CommentDto dto);

    List<CommentDto> fetchAllComments();
    List<CommentDto> findByExpert(ExpertDto expertDto) throws NotFoundExpertException;

}
