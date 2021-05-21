package ir.maktab.data.repository;

import com.google.protobuf.CodedInputStream;
import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Expert;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository {
    void saveNewCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> fetchAllCustomers();
}
