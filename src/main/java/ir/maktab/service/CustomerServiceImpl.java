package ir.maktab.service;

import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.dto.CustomerDto;
import ir.maktab.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(i -> customerMapper.toCustomerDto(i))
                .collect(Collectors.toList());
    }
}
