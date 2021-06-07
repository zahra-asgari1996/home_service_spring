package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundCustomerException;

import java.util.List;

public interface CustomerService {
    void saveNewCustomer(CustomerDto dto);
    void updateCustomer(CustomerDto dto);
    void deleteCustomer(CustomerDto dto);
    List<CustomerDto> fetchAllCustomers();
    CustomerDto findByEmail(String email) throws NotFoundCustomerException;
    boolean loginCustomer(LoginCustomerDto dto) throws InvalidPassword, NotFoundCustomerException;
}
