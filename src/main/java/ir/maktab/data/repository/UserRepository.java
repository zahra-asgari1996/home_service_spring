package ir.maktab.data.repository;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.SearchCustomerDto;

import java.util.List;

public interface UserRepository {
    List<Users> fetchAllUsers();
    void changePassword(Users user);
    List<Users> findByProperty(SearchCustomerDto dto);
}
