package ir.maktab.data.repository;

import ir.maktab.data.domain.SubService;

public interface SubServiceRepository {
    void saveNewSubService(SubService subService);
    void updateSubService(SubService subService);
    void deleteSubService(SubService subService);
    SubService getSubService(SubService subService);
}
