package ir.maktab.data.repository;

import ir.maktab.data.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    void saveNewService(Service service);
    Service getService(Service service);
    void  deleteService(Service service);
    void updateService(Service service);
    List<Service> fetchAllServices();
    boolean findByName(String name);
}
