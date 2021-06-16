package ir.maktab.service;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.mapper.CustomerMapper;
import ir.maktab.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto dto) throws DuplicatedEmailAddressException {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());
        if (customer.isPresent()) {
            throw new DuplicatedEmailAddressException("This Email Is Available ! Please Choose Another Email Or Login... ");
        }
        customerRepository.save(customerMapper.toCustomer(dto));
        return dto;
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
    public CustomerDto loginCustomer(CustomerDto dto) throws InvalidPassword, NotFoundCustomerException {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());
        if (customer.isPresent()) {
            if (customer.get().getPassword().equals(dto.getPassword())) {
                return customerMapper.toCustomerDto(customer.get());
            } else {
                throw new InvalidPassword("Password Is Incorrect ! Please Try Again");
            }
        } else {
            throw new NotFoundCustomerException("This Email Is Not Available ! Please Try Again...");
        }
    }

    @Override
    public void changePassword(CustomerDto dto) {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());
        Customer customer1 = customer.get();
        customer1.setPassword(dto.getPassword());
        customerRepository.save(customer1);
    }

    @Override
    public List<OrderDto> showOrders(CustomerDto dto) {
        Optional<Customer> customer = customerRepository.findByEmail(dto.getEmail());
        return customer.get().getOrders().stream().map(i->orderMapper.toOrderDto(i)).collect(Collectors.toList());
    }
}
