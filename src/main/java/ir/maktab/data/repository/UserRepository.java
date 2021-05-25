package ir.maktab.data.repository;

import ir.maktab.data.domain.Users;
import ir.maktab.dto.SearchCustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    List<Users> fetchAllUsers();
    void changePassword(Users user);
    List<Users> findByProperty(SearchCustomerDto dto);
}
