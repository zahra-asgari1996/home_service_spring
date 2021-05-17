package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import org.springframework.stereotype.Repository;


public interface CustomerRepository {
    void saveNewCustomer(Customer customer);
}
