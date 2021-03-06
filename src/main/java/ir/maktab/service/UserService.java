package ir.maktab.service;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.SearchCustomerDto;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.UserHistoryDto;
import ir.maktab.service.exception.NotFoundUserException;

import java.util.List;

public interface UserService {
    List<UserDto> fetchAllUsers();

    void save(UserDto userDto);

    //    void changePassword(UserDto dto);
//    List<UserDto> findByProperty(SearchCustomerDto dto);
    List<UserDto> filterUsers(FilterUsersDto dto);
    List<UserDto> userHistory(UserHistoryDto dto) throws NotFoundUserException;
}
