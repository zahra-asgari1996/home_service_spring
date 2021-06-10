package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.OfferSituation;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.data.repository.OffersRepository;
import ir.maktab.data.repository.OrderRepository;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundOfferForOrder;
import ir.maktab.service.mapper.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper serviceMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;


    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OfferMapper offerMapper, OffersRepository offersRepository, SubServiceRepository subServiceRepository, SubServiceMapper serviceMapper, CustomerRepository customerRepository, CustomerMapper customerMapper, ExpertMapper expertMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.subServiceRepository = subServiceRepository;
        this.serviceMapper = serviceMapper;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.expertMapper = expertMapper;
    }

    @Override
    public void saveNewOrder(OrderDto dto) {
        Optional<SubService> subService= subServiceRepository.findByName(dto.getSubService().getName());
        if (subService.isPresent()){
            dto.setSubService(serviceMapper.covertToSubServiceDto(subService.get()));
        }
        Optional<Customer> customer = customerRepository.findByEmail(dto.getCustomer().getEmail());
        if (customer.isPresent()){
            dto.setCustomer(customerMapper.toCustomerDto(customer.get()));
        }
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
        if (equals){
           dto.setOfferSituation(OfferSituation.accepted);
           orderDto.setSituation(OrderSituation.Waiting_for_expert_to_come);

        }else{
            throw new NotFoundOfferForOrder("NotFoundOfferForOrder");
        }
    }

    @Override
    public List<OrderDto> findOrdersBaseOnExpertSubServicesAndSituation(ExpertDto expertDto) {
        List<Orders> orders = repository.findOrdersBaseOnExpertSubServices(expertMapper.toExpert(expertDto));
        return orders.stream().map(i->mapper.toOrderDto(i)).collect(Collectors.toList());
    }

}

