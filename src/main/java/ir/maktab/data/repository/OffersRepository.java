package ir.maktab.data.repository;

import ir.maktab.data.domain.Offers;

import java.util.List;

public interface OffersRepository {
    void saveNewOffer(Offers offers);
    void deleteOffer(Offers offers);
    void updateOffer(Offers offers);
    List<Offers> fetchAllOffers();
}
