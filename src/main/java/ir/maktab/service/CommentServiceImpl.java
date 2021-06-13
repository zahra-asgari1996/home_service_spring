package ir.maktab.service;

import ir.maktab.data.repository.CommentsRepository;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;
    private final CustomerService customerService;
    private final ExpertService expertService;
    private final OrderService orderService;

    public CommentServiceImpl(CommentsRepository commentsRepository, CommentMapper commentMapper, CustomerService customerService, ExpertService expertService, OrderService orderService) {
        this.commentsRepository = commentsRepository;
        this.commentMapper = commentMapper;
        this.customerService = customerService;
        this.expertService = expertService;
        this.orderService = orderService;
    }

    @Override
    public void saveNewComment(CommentDto dto) throws NotFoundOrderException {
        OrderDto orderDto = orderService.findById(dto.getOrderDto().getId());
        dto.setExpert(orderDto.getExpert());
        dto.setCustomer(orderDto.getCustomer());
        dto.setOrderDto(orderDto);
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
