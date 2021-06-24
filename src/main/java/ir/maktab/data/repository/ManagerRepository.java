package ir.maktab.data.repository;

import ir.maktab.data.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @Override
    Optional<Manager> findById(Integer integer);

    Optional<Manager> findByUserName(String userName);
}
