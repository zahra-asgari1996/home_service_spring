package ir.maktab.service;

import ir.maktab.data.repository.OffersRepository;
import ir.maktab.dto.OfferDto;
import ir.maktab.service.mapper.OfferMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OffersRepository repository;
    private final OfferMapper mapper;

    public OfferServiceImpl(OffersRepository repository, OfferMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveNewOffer(OfferDto dto) {
        repository.saveNewOffer(mapper.toOffer(dto));
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
}
