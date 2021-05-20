package ir.maktab.data.repository;

import ir.maktab.data.domain.Users;

import java.util.List;

public interface UserRepository {
    List<Users> fetchAllUsers();
    void changePassword(Users user);
}
