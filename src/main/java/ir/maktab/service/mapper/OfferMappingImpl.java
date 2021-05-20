package ir.maktab.service.mapper;

import ir.maktab.data.domain.Offers;
import ir.maktab.dto.OfferDto;
import org.springframework.stereotype.Component;

@Component
public class OfferMappingImpl implements OfferMapping {
    @Override
    public Offers toOffer(OfferDto dto) {
        Offers offer = new Offers();
        offer.setId(dto.getId());
        offer.setOfferPrice(dto.getOfferPrice());
        offer.setSubmitOffer(dto.getSubmitOffer());
        offer.setExpert(dto.getExpert());
        offer.setOrders(dto.getOrders());
        offer.setDurationOfWork(dto.getDurationOfWork());
        offer.setStartTime(dto.getStartTime());
        return offer;
    }

    @Override
    public OfferDto toOfferDto(Offers offer) {
        OfferDto dto = new OfferDto();
        dto.setExpert(offer.getExpert());
        dto.setOfferPrice(offer.getOfferPrice());
        dto.setSubmitOffer(offer.getSubmitOffer());
        dto.setDurationOfWork(offer.getDurationOfWork());
        dto.setId(offer.getId());
        dto.setStartTime(offer.getStartTime());
        dto.setOrders(offer.getOrders());
        return dto;
    }
}
