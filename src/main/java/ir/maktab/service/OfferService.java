package ir.maktab.service;

import ir.maktab.data.domain.Offers;
import ir.maktab.dto.OfferDto;
import ir.maktab.service.exception.LessOfferPriceException;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.exception.NotSubServiceInExpertsListException;

import java.util.List;

public interface OfferService {
    void saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException, NotFoundExpertException, NotFoundOrderException;

    void deleteOffer(OfferDto dto);

    void updateOffer(OfferDto dto);

    List<OfferDto> fetchAllOffers();
}
