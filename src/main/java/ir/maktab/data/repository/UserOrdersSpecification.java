package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.UserRole;
import ir.maktab.dto.UserOrdersFilterDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public interface UserOrdersSpecification {

    static Specification<Orders> filterOrders(UserOrdersFilterDto dto){
        return (root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<Orders> query = criteriaBuilder.createQuery(Orders.class);
            Join<Orders, Customer> customer = root.join("customer");
            Join<Orders, Expert> expert = root.join("expert");
            Join<Orders, SubService> subService = root.join("subService");
            List<Predicate> predicates=new ArrayList<>();
            if (dto.getUserId()!=null && dto.getRole().equals(UserRole.Expert)){
                predicates.add(criteriaBuilder.equal(expert.get("id"),dto.getUserId()));
            }
            if (dto.getUserId()!=null && dto.getRole().equals(UserRole.Customer)){
                predicates.add(criteriaBuilder.equal(customer.get("id"),dto.getUserId()));
            }
            if (dto.getEndDate()!=null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateOfWork"),dto.getEndDate()));
            }if (dto.getStartDate()!=null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfWork"),dto.getStartDate()));
            }
            if (dto.getMaxOfferPrice()!=null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(subService.get("basePrice"),dto.getMaxOfferPrice()));
            }
            if (dto.getMinOfferPrice()!=null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(subService.get("basePrice"),dto.getMinOfferPrice()));
            }
            query.select(root).where(predicates.toArray(new Predicate[0]));
            return query.getRestriction();
        };
    }
}
