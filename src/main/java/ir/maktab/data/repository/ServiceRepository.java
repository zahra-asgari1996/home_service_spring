package ir.maktab.data.repository;

import ir.maktab.data.domain.Service;

import java.util.List;

public interface ServiceRepository {
    void saveNewService(Service service);
    Service getService(Service service);
    void  deleteService(Service service);
    void updateService(Service service);
    List<Service> fetchAllServices();
    boolean findByName(String name);
}
