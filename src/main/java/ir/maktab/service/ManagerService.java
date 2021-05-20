package ir.maktab.service;

import ir.maktab.data.domain.Manager;
import ir.maktab.dto.ManagerDto;

import java.util.List;

public interface ManagerService {
    void saveNewManager(ManagerDto dto);
    void deleteManager(ManagerDto dto);
    void updateManager(ManagerDto dto);
    List<ManagerDto> fetchAllManagers();
}
