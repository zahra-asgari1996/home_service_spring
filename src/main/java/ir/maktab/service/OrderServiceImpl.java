package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.OfferSituation;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.*;
import ir.maktab.dto.*;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.exception.NotFoundOfferForOrder;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.exception.NotFoundOrderForExpertException;
import ir.maktab.service.mapper.*;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
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
    private final ExpertRepository expertRepository;
    private final OrderHistoryService orderHistoryService;
    private final MessageSource messageSource;



    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper
            , SubServiceRepository subServiceRepository,
                            SubServiceMapper serviceMapper,
                            CustomerRepository customerRepository,
                            CustomerMapper customerMapper,
                            ExpertRepository expertRepository,
                            OrderHistoryService orderHistoryService, MessageSource messageSource) {
        this.repository = repository;
        this.mapper = mapper;
        this.subServiceRepository = subServiceRepository;
        this.serviceMapper = serviceMapper;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.expertRepository = expertRepository;
        this.orderHistoryService = orderHistoryService;
        this.messageSource = messageSource;
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
        Orders save = repository.save(mapper.toOrder(dto));
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setOrderDto(mapper.toOrderDto(save));
        orderHistoryDto.setOrderSituation(OrderSituation.Waiting_for_expert_suggestions);
        orderHistoryService.save(orderHistoryDto);

    }

    @Override
    public void deleteOrder(OrderDto dto) {
        repository.delete(mapper.toOrder(dto));

    }

    @Override
    public OrderDto updateOrder(OrderDto dto) {
        Orders save = repository.save(mapper.toOrder(dto));
        return mapper.toOrderDto(save);

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
            throw new NotFoundOfferForOrder(messageSource.getMessage("not.found.offer.for.order",null,new Locale("fa_ir")));
        }
    }

    @Override
    public List<OrderDto> findOrdersBaseOnExpertSubServicesAndSituation(ExpertDto expertDto) throws NotFoundOrderForExpertException {
        Optional<Expert> expert = expertRepository.findByEmail(expertDto.getEmail());
        List<Orders> orders = repository.findOrdersBaseOnExpertSubServices(expert.get());
        if (orders.size()==0){
            throw new NotFoundOrderForExpertException(
                    messageSource.getMessage("not.found.order.for.expert",null,new Locale("fa_ir")));
        }
        return orders.stream().filter(i -> i.getSituation().equals(OrderSituation.Waiting_for_expert_suggestions))
                .map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) throws NotFoundOrderException {
        Optional<Orders> order = repository.findById(id);
        if (order.isPresent()) {
            return mapper.toOrderDto(order.get());
        } else {
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
    }

    @Override
    public List<OrderDto> findByExpert(ExpertDto dto) throws NotFoundOrderException {
        Optional<Expert> expert= expertRepository.findByEmail(dto.getEmail());
        List<Orders> orders = repository.findByExpert(expert.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        return orders.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByCustomer(CustomerDto dto) throws NotFoundOrderException{
        Optional<Customer> customerDto = customerRepository.findByEmail(dto.getEmail());
        List<Orders> orders = repository.findByCustomer(customerDto.get());
        if (orders.size() == 0) {
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        return orders.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public void endOfWork(Integer id) throws NotFoundOrderException {
        Optional<Orders> byId = repository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        byId.get().setSituation(OrderSituation.DONE);
        updateOrder(mapper.toOrderDto(byId.get()));
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setOrderDto(mapper.toOrderDto(byId.get()));
        orderHistoryDto.setOrderSituation(OrderSituation.DONE);
        orderHistoryService.save(orderHistoryDto);
    }

    @Override
    public void confirmPay(Integer id) throws NotFoundOrderException {
        Optional<Orders> byId = repository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        byId.get().setSituation(OrderSituation.FINISHED);
        OrderDto dto = updateOrder(mapper.toOrderDto(byId.get()));
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setOrderDto(dto);
        orderHistoryDto.setOrderSituation(OrderSituation.FINISHED);
        orderHistoryService.save(orderHistoryDto);
    }

    @Override
    public void startWork(Integer id) throws NotFoundOrderException {
        Optional<Orders> byId = repository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        byId.get().setSituation(OrderSituation.STARTED);
        OrderDto dto = updateOrder(mapper.toOrderDto(byId.get()));
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        orderHistoryDto.setOrderDto(dto);
        orderHistoryDto.setOrderSituation(OrderSituation.STARTED);
        orderHistoryService.save(orderHistoryDto);
    }

    @Override
    public List<OrderDto> filterOrders(OrderHistoryFilterDto dto) throws NotFoundOrderException {
        List<Orders> all = repository.findAll(Specification.where(OrderSpecification.filterOrders(dto)));

        List<OrderDto> collect = all.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
        if(collect.size()==0){
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        return collect;
    }

    @Override
    public List<OrderDto> filterUserOrders(UserOrdersFilterDto dto) throws NotFoundOrderException {
        List<Orders> all = repository.findAll(Specification.where(UserOrdersSpecification.filterOrders(dto)));
        List<OrderDto> collect = all.stream().map(i -> mapper.toOrderDto(i)).collect(Collectors.toList());
        if(collect.size()==0){
            throw new NotFoundOrderException(messageSource.getMessage("not.found.order",null,new Locale("fa_ir")));
        }
        return collect;

    }

}


