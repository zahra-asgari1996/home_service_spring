package ir.maktab.service;

import ir.maktab.data.domain.Offers;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.repository.OffersRepository;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.LessOfferPriceException;
import ir.maktab.service.exception.NotSubServiceInExpertsListException;
import ir.maktab.service.mapper.OfferMapper;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OffersRepository repository;
    private final OfferMapper mapper;
    private final OrderMapper orderMapper;

    public OfferServiceImpl(OffersRepository repository, OfferMapper mapper, OrderMapper orderMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public void saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException {
        if (dto.getOfferPrice() < dto.getOrders().getSubService().getBasePrice()) {
            throw new LessOfferPriceException("Offer Price Is Less Than Sub Service Base Price");
        }
        if (dto.getOrders().getExpert().getServices().equals(dto.getOrders().getSubService())) {
            throw new NotSubServiceInExpertsListException("Sub Service Is Not In Experts List");
        }
        dto.getOrders().setSituation(OrderSituation.Waiting_for_expert_selection);
        repository.save(mapper.toOffer(dto));

    }

    @Override
    public void deleteOffer(OfferDto dto) {
        repository.deleteOffer(mapper.toOffer(dto));

    }

    @Override
    public void updateOffer(OfferDto dto) {
        repository.updateOffer(mapper.toOffer(dto));

    }

    @Override
    public List<OfferDto> fetchAllOffers() {
        return repository.fetchAllOffers()
                .stream().map(i -> mapper.toOfferDto(i))
                .collect(Collectors.toList());
    }
    public List<OfferDto> sortedList(OrderDto orderDto,int offset,int limit){
        Pageable pageable= PageRequest.of(offset,limit,Sort.Direction.ASC,"offerPrice");
        Page<Offers> matchedNectarines =
                repository.findAll(OffersRepository.findOffersByOrders(orderMapper.toOrder(orderDto)), pageable);
        return
                matchedNectarines
                        .getContent().stream()
                        .map(i->mapper.toOfferDto(i)).collect(Collectors.toList());

    }
}
