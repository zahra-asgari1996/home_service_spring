package ir.maktab.service;

import ir.maktab.data.domain.Offers;
import ir.maktab.dto.OfferDto;

import java.util.List;

public interface OfferService {
    void saveNewOffer(OfferDto dto);
    void deleteOffer(OfferDto dto);
    void updateOffer(OfferDto dto);
    List<Offers> fetchAllOffers();
}
