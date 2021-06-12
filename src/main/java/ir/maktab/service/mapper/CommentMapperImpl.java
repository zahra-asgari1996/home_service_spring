package ir.maktab.service.mapper;

import ir.maktab.data.domain.Comments;
import ir.maktab.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapperImpl implements CommentMapper {
//    private final CustomerMapper customerMapper;
//    private final ExpertMapper expertMapper;
//
//    public CommentMapperImpl(CustomerMapper customerMapper, ExpertMapper expertMapper) {
//        this.customerMapper = customerMapper;
//        this.expertMapper = expertMapper;
//    }

    @Override
    public Comments toComment(CommentDto dto) {
        Comments comments = new Comments();
        comments.setId(dto.getId());
        comments.setRate(dto.getRate());
        comments.setComment(dto.getComment());
//        comments.setCustomer(customerMapper.toCustomer(dto.getCustomer()));
//        comments.setExpert(expertMapper.toExpert(dto.getExpert()));
        return comments;
    }

    @Override
    public CommentDto toCommentDto(Comments comments) {
        CommentDto dto = new CommentDto();
        dto.setId(comments.getId());
        dto.setComment(comments.getComment());
        dto.setRate(comments.getRate());
//        dto.setCustomer(customerMapper.toCustomerDto(comments.getCustomer()));
//        dto.setExpert(expertMapper.toExpertDto(comments.getExpert()));
        return dto;
    }
}
