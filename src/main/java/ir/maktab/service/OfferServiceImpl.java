package ir.maktab.service;

import ir.maktab.data.domain.Offers;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.OffersRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.LessOfferPriceException;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.exception.NotSubServiceInExpertsListException;
import ir.maktab.service.mapper.OfferMapper;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OffersRepository repository;
    private final OfferMapper mapper;
    private final ExpertService expertService;
    private final OrderService orderService;

    public OfferServiceImpl(OffersRepository repository, OfferMapper mapper, OrderMapper orderMapper, ExpertService expertService, OrderService orderService) {
        this.repository = repository;
        this.mapper = mapper;
        this.expertService = expertService;
        this.orderService = orderService;
    }

    @Override
    public void
    saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException, NotFoundExpertException, NotFoundOrderException {
        ExpertDto expertDto = expertService.findByEmail(dto.getExpert().getEmail());
        OrderDto orderDto = orderService.findById(dto.getOrders().getId());
        Double basePrice = orderDto.getSubService().getBasePrice();
        dto.setExpert(expertDto);
        dto.setOrders(orderDto);
        if (dto.getOfferPrice() < basePrice) {
            throw new LessOfferPriceException("Offer Price Is Less Than Sub Service Base Price");
        }
        if (!expertDto.getServices().contains(orderDto.getSubService())) {
            throw new NotSubServiceInExpertsListException("Sub Service Is Not In Experts List");
        }
        dto.getOrders().setSituation(OrderSituation.Waiting_for_expert_selection);
        repository.save(mapper.toOffer(dto));
    }

    @Override
    public void deleteOffer(OfferDto dto) {
        repository.delete(mapper.toOffer(dto));

    }

    @Override
    public void updateOffer(OfferDto dto) {
        repository.save(mapper.toOffer(dto));

    }

    @Override
    public List<OfferDto> fetchAllOffers() {
        return repository.findAll()
                .stream().map(i -> mapper.toOfferDto(i))
                .collect(Collectors.toList());
    }

    public List<OfferDto> getOrderOffersSortByRateAndPrice(OrderDto orderDto, int offset, int limit) {
        List<Offers> offerPrice = repository.findAll(Sort.by("expert.rate").and(Sort.by("offerPrice")));
        return offerPrice.stream().filter(i -> i.getOrders().equals(orderDto)).map(i -> mapper.toOfferDto(i)).collect(Collectors.toList());
//        Pageable pageable= PageRequest.of(offset,limit,Sort.Direction.ASC,"offerPrice");
//        Page<Offers> matchedNectarines =
//                repository.findAll(OffersRepository.findOffersByOrders(orderMapper.toOrder(orderDto)), pageable);
//        return
//                matchedNectarines
//                        .getContent().stream()
//                        .map(i->mapper.toOfferDto(i)).collect(Collectors.toList());

    }
}
