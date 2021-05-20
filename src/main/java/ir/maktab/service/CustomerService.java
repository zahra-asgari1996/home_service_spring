package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveNewCustomer(CustomerDto dto);
    void updateCustomer(CustomerDto dto);
    void deleteCustomer(CustomerDto dto);
    List<CustomerDto> fetchAllCustomers();
}
