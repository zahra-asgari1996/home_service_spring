package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public void saveNewCustomer(CustomerDto dto) {
        customerRepository.save(customerMapper.toCustomer(dto));
    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        customerRepository.save(customerMapper.toCustomer(dto));

    }

    @Override
    public void deleteCustomer(CustomerDto dto) {
        customerRepository.delete(customerMapper.toCustomer(dto));

    }

    @Override
    public List<CustomerDto> fetchAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto findByEmail(String email) throws NotFoundCustomerException {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            return customerMapper.toCustomerDto(customer.get());
        }
        throw new NotFoundCustomerException("Customer Is Not Available");
    }

    @Override
    public boolean loginCustomer(LoginCustomerDto dto) throws InvalidPassword, NotFoundCustomerException {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());
        if (customer.isPresent()) {
            if (customer.get().getPassword().equals(dto.getPassword())) {
                return true;
            } else {
                throw new InvalidPassword("Password Is Incorrect ! Please Try Again");
            }

        } else {
            throw new NotFoundCustomerException("This Email Is Not Available ! Please Try Again");
        }
    }
}
