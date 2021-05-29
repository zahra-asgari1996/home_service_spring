package ir.maktab.service;

import ir.maktab.data.enums.OfferSituation;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.OffersRepository;
import ir.maktab.data.repository.OrderRepository;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundOfferForOrder;
import ir.maktab.service.mapper.OfferMapper;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OfferMapper offerMapper;
    private final OffersRepository offersRepository;

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OfferMapper offerMapper, OffersRepository offersRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.offerMapper = offerMapper;
        this.offersRepository = offersRepository;
    }

    @Override
    public void saveNewOrder(OrderDto dto) {
        dto.setSituation(OrderSituation.Waiting_for_expert_suggestions);
        repository.save(mapper.toOrder(dto));

    }

    @Override
    public void deleteOrder(OrderDto dto) {
        repository.delete(mapper.toOrder(dto));

    }

    @Override
    public void updateOrder(OrderDto dto) {
        repository.save(mapper.toOrder(dto));

    }

    @Override
    public List<OrderDto> fetchAllOrders() {
        return repository.findAll()
                .stream().map(i->mapper.toOrderDto(i))
                .collect(Collectors.toList());
    }

    @Override
    public void selectOffer(OrderDto orderDto,OfferDto dto) throws NotFoundOfferForOrder {
        boolean equals = dto.getOrders().equals(orderDto);
        if (equals==true){
           dto.setOfferSituation(OfferSituation.accepted);
           orderDto.setSituation(OrderSituation.Waiting_for_expert_to_come);
        }else{
            throw new NotFoundOfferForOrder("NotFoundOfferForOrder");
        }
    }

}
