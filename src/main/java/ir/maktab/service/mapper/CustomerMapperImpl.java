package ir.maktab.service.mapper;

import ir.maktab.data.domain.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toCustomer(CustomerDto dto) {
        Customer customer=new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setRole(dto.getRole());
        customer.setSituation(dto.getSituation());
        customer.setDate(dto.getDate());
        customer.setCredit(dto.getCredit());
        customer.setComments(dto.getComments());
        customer.setOrders(dto.getOrders());
        return customer;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        CustomerDto dto=new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPassword(customer.getPassword());
        dto.setDate(customer.getDate());
        dto.setComments(customer.getComments());
        dto.setOrders(customer.getOrders());
        dto.setRole(customer.getRole());
        dto.setSituation(customer.getSituation());
        dto.setCredit(customer.getCredit());
        return dto;
    }
}
