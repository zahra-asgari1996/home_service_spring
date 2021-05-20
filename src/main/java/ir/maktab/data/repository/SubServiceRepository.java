package ir.maktab.data.repository;

import ir.maktab.data.domain.SubService;

import java.util.List;

public interface SubServiceRepository {
    void saveNewSubService(SubService subService);
    void updateSubService(SubService subService);
    void deleteSubService(SubService subService);
    SubService getSubService(SubService subService);
    List<SubService> fetchAllSubServices();
}
