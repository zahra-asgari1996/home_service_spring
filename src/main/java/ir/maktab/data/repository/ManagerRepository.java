package ir.maktab.data.repository;

import ir.maktab.data.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    void saveNewManager(Manager manager);
    void deleteManager(Manager manager);
    void updateManager(Manager manager);
    List<Manager> fetchAllManagers();
}
