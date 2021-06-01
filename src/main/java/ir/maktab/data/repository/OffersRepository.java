package ir.maktab.data.repository;

import ir.maktab.data.domain.Offers;
import ir.maktab.data.domain.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public interface OffersRepository extends JpaRepository<Offers,Integer>, JpaSpecificationExecutor<Offers> {


//    void saveNewOffer(Offers offers);
//    void deleteOffer(Offers offers);
//    void updateOffer(Offers offers);
//    List<Offers> fetchAllOffers();
//    static Specification<Offers> findOffersByOrders(Orders orders){
//        return (root, cq, cb) -> {
//            Predicate predicate = null;
//            if (orders != null) {
//                predicate = cb.equal(root.get("orders"), orders);
//            }
//            return cq.where(predicate).getRestriction();
//        };
//    }
}
