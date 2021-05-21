package ir.maktab.service;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.SearchCustomerDto;
import ir.maktab.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> fetchAllUsers();
    void changePassword(UserDto dto);
    List<UserDto> findByProperty(SearchCustomerDto dto);
}
