package ir.maktab.service;

import ir.maktab.data.repository.OrderRepository;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveNewOrder(OrderDto dto) {
        repository.saveNewOrder(mapper.toOrder(dto));

    }

    @Override
    public void deleteOrder(OrderDto dto) {
        repository.deleteOrder(mapper.toOrder(dto));

    }

    @Override
    public void updateOrder(OrderDto dto) {
        repository.updateOrder(mapper.toOrder(dto));

    }

    @Override
    public List<OrderDto> fetchAllOrders() {
        return repository.fetchAllOrders()
                .stream().map(i->mapper.toOrderDto(i))
                .collect(Collectors.toList());
    }
}
