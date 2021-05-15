package ir.maktab.data.repository;

import ir.maktab.data.domain.Service;

public interface ServiceRepository {
    void saveNewService(Service service);
    Service findService(Service service);
    void  deleteService(Service service);
    void updateService(Service service);
}
