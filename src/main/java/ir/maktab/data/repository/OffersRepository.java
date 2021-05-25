package ir.maktab.data.repository;

import ir.maktab.data.domain.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OffersRepository extends JpaRepository<Offers,Integer> {
    void saveNewOffer(Offers offers);
    void deleteOffer(Offers offers);
    void updateOffer(Offers offers);
    List<Offers> fetchAllOffers();
}
