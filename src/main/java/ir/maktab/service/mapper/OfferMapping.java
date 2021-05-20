package ir.maktab.service.mapper;

import ir.maktab.data.domain.Offers;
import ir.maktab.dto.OfferDto;

public interface OfferMapping {
    Offers toOffer(OfferDto dto);
    OfferDto toOfferDto(Offers offer);

}
