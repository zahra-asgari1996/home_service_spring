package ir.maktab.service.mapper;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapperImpl implements CommentMapper {
    @Override
    public Comments toComment(CommentDto dto) {
        Comments comments=new Comments();
        comments.setId(dto.getId());
        comments.setRate(dto.getRate());
        comments.setComment(dto.getComment());
        comments.setCustomer(dto.getCustomer());
        comments.setExpert(dto.getExpert());
        return comments;
    }

    @Override
    public CommentDto toCommentDto(Comments comments) {
        CommentDto dto=new CommentDto();
        dto.setId(comments.getId());
        dto.setComment(comments.getComment());
        dto.setRate(comments.getRate());
        dto.setCustomer(comments.getCustomer());
        dto.setExpert(comments.getExpert());
        return dto;
    }
}
