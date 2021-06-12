package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.OfferSituation;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.*;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.exception.NotFoundOfferForOrder;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.mapper.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper serviceMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;
    private final ExpertRepository expertRepository;
    private final CustomerService customerService;



    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper
            , SubServiceRepository subServiceRepository,
                            SubServiceMapper serviceMapper,
                            CustomerRepository customerRepository,
                            CustomerMapper customerMapper,
                            ExpertMapper expertMapper,
                            ExpertRepository expertRepository, CustomerService customerService) {
        this.repository = repository;
        this.mapper = mapper;
        this.subServiceRepository = subServiceRepository;
        this.serviceMapper = serviceMapper;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.expertMapper = expertMapper;
        this.expertRepository = expertRepository;

        this.customerService = customerService;
    }

    @Override
    public void saveNewOrder(OrderDto dto) {
        Optional<SubService> subService = subServiceRepository.findByName(dto.getSubService().getName());
        if (subService.isPresent()) {
            dto.setSubService(serviceMapper.covertToSubServiceDto(subService.get()));
        }
        Optional<Customer> customer = customerRepository.findByEmail(dto.getCustomer().getEmail());
        if (customer.isPresent()) {
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
                .stream().map(i -> mapper.toOrderDto(i))
                .collect(Collectors.toList());
    }

    @Override
    public void selectOffer(OrderDto orderDto, OfferDto dto) throws NotFoundOfferForOrder {
        boolean equals = dto.getOrders().equals(orderDto);
        if (equals) {
            dto.setOfferSituation(OfferSituation.accepted);
            orderDto.setSituation(OrderSituation.Waiting_for_expert_to_come);

        } else {
            throw new NotFoundOfferForOrder("NotFoundOfferForOrder");
        }
    }

    @Override
    public List<OrderDto> findOrdersBaseOnExpertSubServicesAndSituation(ExpertDto expertDto) {
        Optional<Expert> expert = expertRepository.findByEmail(expertDto.getEmail());
        List<Orders> orders = repository.findOrdersBaseOnExpertSubServices(expert.get());
        return orders.stream().filter(i -> i.getSituation().equals(OrderSituation.Waiting_for_expert_suggestions)).map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) throws NotFoundOrderException {
        Optional<Orders> order = repository.findById(id);
        if (order.isPresent()) {
            return mapper.toOrderDto(order.get());
        } else {
            throw new NotFoundOrderException("This Order Is Not Available !");
        }
    }

    @Override
    public List<OrderDto> findByExpert(ExpertDto dto) throws NotFoundOrderException {
        Optional<Expert> expert= expertRepository.findByEmail(dto.getEmail());
        List<Orders> orders = repository.findByExpert(expert.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException("The Expert Has No Order History ! ");
        }
        return orders.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByCustomer(CustomerDto dto) throws NotFoundOrderException, NotFoundCustomerException {
        Optional<Customer> customerDto = customerRepository.findByEmail(dto.getEmail());
        List<Orders> orders = repository.findByCustomer(customerDto.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException("The Customer Has No Order History ! ");
        }
        return orders.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

}


