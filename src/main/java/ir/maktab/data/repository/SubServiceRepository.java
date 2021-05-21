package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.SubService;

import java.util.List;

public interface SubServiceRepository {
    void saveNewSubService(SubService subService);
    void updateSubService(SubService subService);
    void deleteSubService(SubService subService);
    SubService getSubService(SubService subService);
    List<SubService> fetchAllSubServices();
    void deleteExpertFromSubService(SubService service,Expert expert);
    void updateExpertInSubService(SubService service,Expert newExpert,Expert oldExpert);
    void addExpertToSubService(SubService service,Expert expert);
    boolean findByName(String name);
}
